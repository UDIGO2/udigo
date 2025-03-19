package com.udigo.hotel.auth.controller;

import com.udigo.hotel.member.model.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/auth")
public class AuthController {


    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;  // ✅ 추가

    @Autowired
    public AuthController(MemberService memberService, PasswordEncoder passwordEncoder) {
        this.memberService = memberService;
        this.passwordEncoder = passwordEncoder;  // ✅ 생성자에서 초기화
    }


    /** ✅ 로그인 페이지 이동 */
    @GetMapping("/login")
    public String loginPage(@RequestParam(value = "error", required = false) String error,
                            HttpServletRequest request,
                            Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        // 🔹 로그인 상태 체크 (이미 로그인된 경우)
        if (auth != null && auth.isAuthenticated() && auth.getPrincipal() instanceof User) {
            model.addAttribute("successMessage", "이미 로그인되어 있습니다.");
            return "main/main";
        }

        // 🔹 로그인 실패 시 에러 메시지 전달
        if (error != null) {
            model.addAttribute("errorMessage", "아이디 또는 비밀번호가 잘못되었습니다.");
        }

        // 🔹 로그인 전 페이지 저장 (Referer 활용)
        String referer = request.getHeader("Referer");
        if (referer != null && !referer.contains("/auth/login")) {
            request.getSession().setAttribute("prevPage", referer);
        }

        return "auth/login";
    }

    /** ✅ 로그인 성공 후 메인 페이지 이동 */
    @GetMapping("/")
    public String mainPage(HttpServletRequest request, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null && auth.isAuthenticated() && auth.getPrincipal() instanceof User) {
            model.addAttribute("memberId", auth.getName());
            model.addAttribute("successMessage", "로그인에 성공했습니다!");

            // 🔹 로그인 전 페이지로 이동
            String prevPage = (String) request.getSession().getAttribute("prevPage");
            if (prevPage != null) {
                request.getSession().removeAttribute("prevPage");
                return "redirect:" + prevPage;
            }

            return "main/main";
        }
        return "redirect:/auth/login";
    }

    /** ✅ 아이디 찾기 페이지 이동 */
    @GetMapping("/findid")
    public String findIdPage() {
        return "auth/findid";
    }

    /** ✅ 아이디 찾기 요청 처리 */
    @PostMapping("/findid")
    public String findId(@RequestParam("email") String email, Model model) {
        String findId = String.valueOf(memberService.findIdByEmail(email));

        if (findId != null && !findId.isEmpty()) {
            model.addAttribute("findId", findId);
        } else {
            model.addAttribute("error", "등록된 이메일이 없습니다.");
        }

        return "auth/findid";
    }

    /** 비밀번호 찾기 페이지 이동 */
    @GetMapping("/findpass")
    public String showFindPasswordPage() {
        return "auth/findpass";
    }

    /** 비밀번호 찾기 요청 처리 */
    @PostMapping("/findpass")
    public String processFindPassword(@RequestParam("memberId") String memberId,
                                      @RequestParam("email") String email,
                                      Model model) {
        String tempPassword = memberService.findPassword(memberId, email);

        if (tempPassword == null || tempPassword.isEmpty()) {
            model.addAttribute("error", "존재하지 않는 회원 정보입니다.");
            return "auth/findpass";  // 비밀번호 찾기 페이지로 유지
        }

        model.addAttribute("success", "임시 비밀번호가 이메일로 발송되었습니다.");
        return "auth/findpass";  // 성공 모달을 비밀번호 찾기 페이지에서 먼저 띄우기
    }

    /** 회원 탈퇴 페이지 이동 */
    @GetMapping("/withdraw")
    public String showWithdrawPage() {
        return "auth/withdraw";
    }

    /** 회원 탈퇴 처리 */
    @PostMapping("/withdraw")
    public String withdrawMember(@RequestParam("password") String password,
                                 HttpServletRequest request, Model model) {
        // 현재 로그인한 사용자 정보 가져오기
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String memberId = auth.getName();

        // ✅ DB에서 저장된 비밀번호 가져오기
        String storedPassword = memberService.getPasswordByMemberId(memberId);

        // ✅ 비밀번호 확인
        if (storedPassword == null || !passwordEncoder.matches(password, storedPassword)) {
            model.addAttribute("errorMessage", "비밀번호가 일치하지 않습니다.");
            return "auth/withdraw";
        }

        // ✅ 회원 탈퇴 진행
        boolean success = memberService.withdrawMember(memberId);

        if (success) {
            // ✅ 인증 정보 초기화
            SecurityContextHolder.clearContext();

            // ✅ 세션 초기화
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
            }

            // ✅ 로그인 페이지로 이동 (로그인 상태 초기화 확인)
            return "redirect:/";
        } else {
            model.addAttribute("errorMessage", "회원 탈퇴에 실패했습니다. 다시 시도해주세요.");
            return "auth/withdraw";
        }
    }
}

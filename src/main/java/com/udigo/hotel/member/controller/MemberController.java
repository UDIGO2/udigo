package com.udigo.hotel.member.controller;

import com.udigo.hotel.auth.model.service.AuthService;
import com.udigo.hotel.member.model.dto.MemberDTO;
import com.udigo.hotel.member.model.service.MemberService;
import com.udigo.hotel.member.security.CustomUserDetails;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;  // 비밀번호 암호화를 위한 객체


    public MemberController(MemberService memberService, PasswordEncoder passwordEncoder) {
        this.memberService = memberService;
        this.passwordEncoder = passwordEncoder;

    }

    /* 회원가입 페이지 이동 */
    @GetMapping("/signup")
    public String signupForm(Model model) {
        model.addAttribute("member", new MemberDTO());
        return "member/signup"; // signup.html 페이지로 이동
    }

    /* 회원가입 처리 */
    @PostMapping("/signup")
    public String signup(@ModelAttribute MemberDTO member, Model model) {
        try {
            memberService.signup(member);
            model.addAttribute("successMessage", "회원가입이 완료되었습니다!");
            return "member/signup";
        } catch (IllegalArgumentException e) { // 아이디 중복 등 사용자 입력 오류
            model.addAttribute("errorMessage", "이미 사용 중인 아이디입니다. 다른 아이디를 입력해주세요.");
        } catch (Exception e) { // 기타 모든 예외 (DB 오류 포함)
            model.addAttribute("errorMessage", "회원가입에 실패했습니다. 다시 시도해주세요.");
        }
        return "member/signup";
    }

    /* 아이디 & 이메일 중복 확인 (AJAX 지원, JSON 응답) */
    @GetMapping("/check-duplicate")
    @ResponseBody // JSON 형태의 응답을 반환
    public ResponseEntity<Map<String, Object>> checkDuplicate(
            @RequestParam("type") String type,
            @RequestParam("value") String value) {  // 중복 확인할 값 (사용자가 입력한 아이디 또는 이메일)

        boolean isDuplicate;
        if ("memberId".equals(type)) {
            isDuplicate = memberService.isMemberIdDuplicate(value);
        } else if ("email".equals(type)) {
            isDuplicate = memberService.isEmailDuplicate(value);
        } else {
            return ResponseEntity.badRequest().body(Map.of("message", "잘못된 요청입니다."));
        }

        Map<String, Object> response = new HashMap<>();
        response.put("isDuplicate", isDuplicate);
        response.put("message", isDuplicate ? "이미 사용 중입니다." : "사용 가능합니다.");

        return ResponseEntity.ok(response);     // JSON 형태의 응답 반환
    }

    /* 마이페이지 이동 */
    @GetMapping("/mypage")
    public String myPage(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getPrincipal() instanceof CustomUserDetails) {
            CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();
            model.addAttribute("memberId", userDetails.getMemberId());
            model.addAttribute("memberName", userDetails.getMemberName());
            model.addAttribute("currentPage", "mypage");
        }
        return "member/mypage";
    }

    /* 회원 정보 조회 */
    @GetMapping("/myinfo")
    public String myInfo(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getPrincipal() instanceof CustomUserDetails) {
            CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();

            // 현재 로그인한 회원의 상세 정보 조회
            MemberDTO member = memberService.findByMemberId(userDetails.getMemberId());

            model.addAttribute("member", member);
            return "member/myinfo";
        }

        return "redirect:/auth/login";
    }

    /* 회원 정보 수정 */
    @PostMapping("/myinfo/update")
    public String updateMyInfo(@ModelAttribute MemberDTO memberDTO, RedirectAttributes redirectAttributes) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getPrincipal() instanceof CustomUserDetails) {
            CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();

            // 현재 로그인한 회원의 memberCode 설정
            memberDTO.setMemberCode(userDetails.getMemberCode());

            memberService.updateMember(memberDTO);
            redirectAttributes.addFlashAttribute("successMessage", "수정이 완료되었습니다!");
            return "redirect:/member/myinfo?success=true";
        }

        return "redirect:/auth/login";
    }

    /* 쿠폰 사용 */
    @PostMapping("/useCoupon")
    public String useCoupon(@ModelAttribute MemberDTO memberDTO, RedirectAttributes redirectAttributes) {
        try {
            memberService.useCoupon(memberDTO.getMemberId());
            redirectAttributes.addFlashAttribute("successMessage", "쿠폰이 성공적으로 사용되었습니다.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "쿠폰 사용 실패: " + e.getMessage());
        }
        return "redirect:/member/mypage";
    }

    /* 비밀번호 변경 페이지 이동 */
    @GetMapping("/changepassword")
    public String showChangePasswordForm() {
        return "member/changepassword";
    }

    /* 비밀번호 변경 처리 */
    @PostMapping("/changepassword")
    public String changePassword(
            @RequestParam("currentPassword") String currentPassword,
            @RequestParam("newPassword") String newPassword,
            @RequestParam("confirmPassword") String confirmPassword,
            Authentication authentication,
            HttpServletRequest request,
            Model model,
            RedirectAttributes redirectAttributes) {

        String memberId = authentication.getName();     // 로그인한 사용자 아이디 가져오기
        MemberDTO member = memberService.getMemberById(memberId);

        // 회원 존재 여부 확인
        if (member == null) {
            model.addAttribute("error", "회원 정보를 찾을 수 없습니다.");
            return "member/changepassword";
        }

        // 현재 비밀번호 일치 확인
        if (!passwordEncoder.matches(currentPassword, member.getPassword())) {
            model.addAttribute("error", "현재 비밀번호가 올바르지 않습니다.");
            return "member/changepassword";
        }

        // 새 비밀번호와 확인 비밀번호 일치 확인
        if (!newPassword.equals(confirmPassword)) {
            model.addAttribute("error", "새 비밀번호와 확인 비밀번호가 일치하지 않습니다.");
            return "member/changepassword";
        }

        // 비밀번호 업데이트 후 성공 메시지 추가
        memberService.updatePassword(memberId, passwordEncoder.encode(newPassword));  // 비밀번호 암호화 후 변경
        redirectAttributes.addFlashAttribute("successMessage", "비밀번호가 성공적으로 변경되었습니다.");

        // 세션 무효화 (로그아웃 처리)
        request.getSession().invalidate();      // 현재 세션 제거
        SecurityContextHolder.clearContext();   // Spring Security 인증 정보 제거

        redirectAttributes.addFlashAttribute("successMessage", "비밀번호가 성공적으로 변경되었습니다. 다시 로그인해 주세요.");
        return "redirect:/auth/login";
    }
}

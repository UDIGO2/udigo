package com.udigo.hotel.member.controller;

import com.udigo.hotel.member.model.dto.MemberDTO;
import com.udigo.hotel.member.model.service.MemberService;
import com.udigo.hotel.member.security.CustomUserDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;


    public MemberController(MemberService memberService, PasswordEncoder passwordEncoder) {
        this.memberService = memberService;
        this.passwordEncoder = passwordEncoder;
    }

    /** 회원가입 페이지 이동 **/
    @GetMapping("/signup")
    public String signupForm(Model model) {
        model.addAttribute("member", new MemberDTO());
        return "member/signup"; // signup.html 페이지로 이동
    }

    /** 회원가입 처리 **/
    @PostMapping("/signup")
    public String signup(@ModelAttribute MemberDTO member, RedirectAttributes redirectAttributes) {
        try {
            memberService.signup(member);
            redirectAttributes.addFlashAttribute("successMessage", "회원가입이 완료되었습니다!");
            return "redirect:/member/signup";
        } catch (IllegalArgumentException e) { // 아이디 중복 등 사용자 입력 오류
            redirectAttributes.addFlashAttribute("errorMessage", "이미 사용 중인 아이디입니다. 다른 아이디를 입력해주세요.");
        } catch (Exception e) { // 기타 모든 예외 (DB 오류 포함)
            redirectAttributes.addFlashAttribute("errorMessage", "회원가입에 실패했습니다. 다시 시도해주세요.");
        }
        return "redirect:/member/signup";
    }

    @GetMapping("/mypage")
    public String myPage(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();       // security 관련부분
        if (auth != null && auth.getPrincipal() instanceof CustomUserDetails) {
            CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();
            model.addAttribute("memberId", userDetails.getMemberId());
            model.addAttribute("memberName", userDetails.getMemberName());
            model.addAttribute("currentPage", "mypage");
        }
        return "member/mypage";
    }

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

    /** ✅ 쿠폰 사용 API */
    @PostMapping("/useCoupon")
    public String useCoupon(@ModelAttribute MemberDTO memberDTO, RedirectAttributes redirectAttributes) {
        try {
            memberService.useCoupon(memberDTO.getMemberId());
            redirectAttributes.addFlashAttribute("successMessage", "쿠폰이 성공적으로 사용되었습니다.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "쿠폰 사용 실패: " + e.getMessage());
        }
        return "redirect:/member/mypage"; // ✅ 마이페이지로 리디렉트
    }

    /** ✅ GET 요청 지원: 브라우저에서 실행 가능하도록 변경 */
    @GetMapping("/useCoupon")
    public String useCouponGet(@ModelAttribute MemberDTO memberDTO, RedirectAttributes redirectAttributes) {
        return useCoupon(memberDTO, redirectAttributes);
    }
    /** ✅ 쿠폰 사용 여부 조회 API */
    @GetMapping("/coupons")
    public ResponseEntity<String> getCouponStatus(@RequestParam("memberId") String memberId) {
        boolean couponUsed = memberService.checkCouponStatus(memberId);

        if (couponUsed) {
            return ResponseEntity.ok("이미 사용한 쿠폰입니다.");
        } else {
            return ResponseEntity.ok("사용 가능한 쿠폰이 있습니다!");
        }
    }

    // ✅ 비밀번호 변경 페이지 이동
    @GetMapping("/changepassword")
    public String showChangePasswordForm() {
        return "member/changepassword"; // Thymeleaf 템플릿 이동
    }

    // ✅ 비밀번호 변경 처리 (POST 요청)
    @PostMapping("/changepassword")
    public String changePassword(
            @RequestParam("currentPassword") String currentPassword,
            @RequestParam("newPassword") String newPassword,
            @RequestParam("confirmPassword") String confirmPassword,
            Authentication authentication,
            Model model,
            RedirectAttributes redirectAttributes) {

        String memberId = authentication.getName();
        MemberDTO member = memberService.getMemberById(memberId);

        // ✅ 회원 존재 여부 확인
        if (member == null) {
            model.addAttribute("error", "회원 정보를 찾을 수 없습니다.");
            return "member/changepassword";
        }

        if (!passwordEncoder.matches(currentPassword, member.getPassword())) {
            model.addAttribute("error", "현재 비밀번호가 올바르지 않습니다.");
            return "member/changepassword";
        }

        // ✅ 새 비밀번호와 확인 비밀번호 일치 확인
        if (!newPassword.equals(confirmPassword)) {
            model.addAttribute("error", "새 비밀번호와 확인 비밀번호가 일치하지 않습니다.");
            return "member/changepassword";
        }

        // ✅ 비밀번호 업데이트 후 성공 메시지 추가
        memberService.updatePassword(memberId, passwordEncoder.encode(newPassword));
        redirectAttributes.addFlashAttribute("successMessage", "비밀번호가 성공적으로 변경되었습니다.");

        return "redirect:/member/changepassword";  // 로그인 페이지로 이동
    }
}
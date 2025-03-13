package com.udigo.hotel.member.controller;

import com.udigo.hotel.member.model.dto.MemberDTO;
import com.udigo.hotel.member.model.service.MemberService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    /** 회원가입 페이지 이동 */
    @GetMapping("/signup")
    public String signup() {
        return "member/signup";
    }

    /** 회원가입 처리 */
    @PostMapping("/signup")
    public String signup(@ModelAttribute MemberDTO member,
                         @ModelAttribute("confirmPassword") String confirmPassword,
                         RedirectAttributes rttr) {

        try {
            memberService.signup(member, confirmPassword);
            rttr.addFlashAttribute("successMessage", "회원가입이 완료되었습니다.");
            return "redirect:/login"; // 🚀 회원가입 완료 후 로그인 페이지로 이동
        } catch (Exception e) {
            rttr.addFlashAttribute("errorMessage", "회원가입 실패: " + e.getMessage());
            return "redirect:/member/signup";
        }
    }

    /** 마이페이지 이동 */
    @GetMapping("/mypage")
    public String mypage(@AuthenticationPrincipal MemberDTO member, Model model) {

        if (member == null) {
            return "redirect:/login"; //  로그인되지 않은 경우 로그인 페이지로 이동
        }

        model.addAttribute("member", member);
        model.addAttribute("currentPage", "mypage");

        return "member/mypage";
    }

    /** 회원 정보 수정 */
    @PostMapping("/update")
    public String update(@ModelAttribute MemberDTO updateMember,
                         @AuthenticationPrincipal MemberDTO member,
                         RedirectAttributes rttr) {

        if (member == null) {
            rttr.addFlashAttribute("errorMessage", "로그인이 필요합니다.");
            return "redirect:/login"; //  로그인되지 않은 경우 로그인 페이지로 이동
        }

        try {
            updateMember.setMemberCode(member.getMemberCode());
            memberService.update(updateMember);
            rttr.addFlashAttribute("successMessage", "회원정보가 수정되었습니다.");
            return "redirect:/member/mypage";
        } catch (Exception e) {
            rttr.addFlashAttribute("errorMessage", "회원정보 수정 실패: " + e.getMessage());
            return "redirect:/member/mypage";
        }
    }
}

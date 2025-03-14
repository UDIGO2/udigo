package com.udigo.hotel.member.controller;

import com.udigo.hotel.member.model.dto.MemberDTO;
import com.udigo.hotel.member.model.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
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
}

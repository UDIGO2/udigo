package com.udigo.hotel.member.controller;

import com.udigo.hotel.member.model.dto.MemberDTO;
import com.udigo.hotel.member.model.service.MemberService;
import com.udigo.hotel.member.security.CustomUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final MemberService memberService;


    public AdminController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 관리자 권한 체크 메소드
    private boolean isAdmin() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getPrincipal() instanceof CustomUserDetails) {
            CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();
            return "ADMIN".equals(userDetails.getRole());
        }
        return false;
    }

    // 관리자 마이페이지 이동
    @GetMapping("/adminpage")
    public String adminMypage(Model model) {
        if (!isAdmin()) {
            return "redirect:/"; // 관리자 권한이 없으면 메인으로 리디렉트
        }

        // 현재 로그인한 관리자 정보 가져오기
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();

        model.addAttribute("adminId", userDetails.getMemberId());

        return "member/admin/adminpage"; // 관리자 마이페이지 템플릿 반환
    }

    @GetMapping("/memberlist")
    public String getMemberList(Model model) {
        List<MemberDTO> members = memberService.getAllMembers();

        // LocalDateTime을 String으로 변환 (yyyy-MM-dd 형식)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        List<MemberDTO> formattedMembers = members.stream()
                .map(member -> {
                    if (member.getJoinDate() != null) {
                        member.setFormattedJoinDate(member.getJoinDate().format(formatter));
                    }
                    return member;
                })
                .collect(Collectors.toList());

        model.addAttribute("memberList", formattedMembers); // Thymeleaf에서 사용할 데이터 전달
        return "member/admin/memberlist";
    }

    // 회원 상세 조회 페이지
    @GetMapping("/member/detail/{memberId}")
    public String getMemberDetail(@PathVariable String memberId, Model model) {
        MemberDTO member = memberService.getMemberById(memberId);

        // LocalDateTime을 String으로 변환하여 전달
        if (member.getJoinDate() != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            member.setFormattedJoinDate(member.getJoinDate().format(formatter));
        }

        model.addAttribute("member", member);
        return "member/admin/memberdetail";
    }


}

package com.udigo.hotel.resv.controller;

import com.udigo.hotel.resv.model.dto.ResvDTO;
import com.udigo.hotel.resv.model.service.ResvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/reservations")
public class ResvController {

    @Autowired
    private ResvService resvService;

    // 현재 예약 페이지
    @GetMapping("/current")
    public String getCurrentReservations(Model model) {
        // 임시로 회원 코드 1로 설정 (실제로는 로그인한 사용자의 회원 코드를 사용)
        int memberCode = 101;
        List<ResvDTO> currentReservations = resvService.getCurrentReservationsByMemberCode(memberCode);
        model.addAttribute("reservations", currentReservations);
        return "resv/current";
    }

    // 이전 예약 페이지
    @GetMapping("/past")
    public String getPastReservations(Model model) {
        // 임시로 회원 코드 1로 설정 (실제로는 로그인한 사용자의 회원 코드를 사용)
        int memberCode = 101;
        List<ResvDTO> pastReservations = resvService.getPastReservationsByMemberCode(memberCode);
        model.addAttribute("reservations", pastReservations);
        return "resv/past";
    }

    // 예약 취소 페이지
    @GetMapping("/cancel")
    public String getCancelReservations(Model model) {
        // 임시로 회원 코드 1로 설정 (실제로는 로그인한 사용자의 회원 코드를 사용)
        int memberCode = 101;
        List<ResvDTO> cancelableReservations = resvService.getCancelableReservationsByMemberCode(memberCode);
        model.addAttribute("reservations", cancelableReservations);
        return "resv/cancel";
    }

    // 예약 취소 처리
    @GetMapping("/cancel/{resvId}")
    public String cancelReservation(@PathVariable("resvId") int resvId) {
        resvService.cancelReservation(resvId);
        return "redirect:/reservations/current";
    }
}
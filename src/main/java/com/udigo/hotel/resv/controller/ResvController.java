package com.udigo.hotel.resv.controller;

import com.udigo.hotel.member.security.CustomUserDetails;
import com.udigo.hotel.resv.model.dto.ResvDTO;
import com.udigo.hotel.resv.model.service.ResvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/resv")
public class ResvController {

    @Autowired
    private ResvService resvService;

    // 현재 예약 조회
    @GetMapping("/current")
    public String getCurrentResv(Model model) {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (!(auth.getPrincipal() instanceof CustomUserDetails)) {
                return "redirect:/auth/login";
            }

            CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();
            int memberCode = userDetails.getMemberCode();

            List<ResvDTO> reservations = resvService.getCurrentResv(memberCode);
            model.addAttribute("reservations", reservations);

            return "resv/current";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/auth/login";
        }
    }

    // 이전 예약 조회
    @GetMapping("/past")
    public String getPastResv(Model model) {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (!(auth.getPrincipal() instanceof CustomUserDetails)) {
                return "redirect:/auth/login";
            }

            CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();
            int memberCode = userDetails.getMemberCode();

            model.addAttribute("resvList", resvService.getPastResv(memberCode));
            return "resv/past";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/auth/login";
        }
    }

    // 취소 가능한 예약 조회
    @GetMapping("/cancel")
    public String getCancelableResv(Model model) {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (!(auth.getPrincipal() instanceof CustomUserDetails)) {
                return "redirect:/auth/login";
            }

            CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();
            int memberCode = userDetails.getMemberCode();

            model.addAttribute("reservations", resvService.getCancelableResv(memberCode));
            return "resv/cancel";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/auth/login";
        }
    }

    // 예약 취소 처리
    @PostMapping("/cancel/{resvId}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> cancelReservation(@PathVariable int resvId) {
        Map<String, Object> response = new HashMap<>();

        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (!(auth.getPrincipal() instanceof CustomUserDetails)) {
                response.put("success", false);
                response.put("message", "로그인이 필요합니다.");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
            }

            CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();
            int memberCode = userDetails.getMemberCode();

            resvService.cancelReservation(resvId, memberCode);
            response.put("success", true);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
}
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

import java.util.ArrayList;
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

    // 결제 ID로 현재 예약 페이지에 데이터 출력
    @GetMapping("/current/payment/{payId}")
    public String getCurrentResvByPayment(@PathVariable("payId") int payId, Model model) {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (!(auth.getPrincipal() instanceof CustomUserDetails)) {
                return "redirect:/auth/login";
            }

            CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();
            int memberCode = userDetails.getMemberCode();

            // 결제 ID로 예약 정보 조회
            ResvDTO reservation = resvService.getReservationByPayId(payId);

            if (reservation == null) {
                return "redirect:/error?message=해당 결제 정보를 찾을 수 없습니다.";
            }

            // 보안 검사: 현재 로그인한 사용자의 예약인지 확인
            if (reservation.getMemberCode() != memberCode) {
                return "redirect:/error?message=접근 권한이 없습니다.";
            }

            // 단일 예약을 리스트에 담아서 전달
            List<ResvDTO> reservations = new ArrayList<>();
            reservations.add(reservation);
            model.addAttribute("reservations", reservations);

            // 결제 ID로 조회했음을 표시
            model.addAttribute("fromPayment", true);
            model.addAttribute("payId", payId);

            return "resv/current";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/error?message=" + e.getMessage();
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
    public ResponseEntity<Map<String, Object>> cancelReservation(
            @PathVariable int resvId,
            @RequestBody Map<String, Object> requestData) {
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
            
            // 환불 금액 가져오기
            int refundAmount = 0;
            if (requestData.containsKey("refundAmount")) {
                refundAmount = Integer.parseInt(requestData.get("refundAmount").toString());
            }

            // 예약 취소 및 환불 처리
            resvService.cancelReservationWithRefund(resvId, memberCode, refundAmount);
            
            response.put("success", true);
            response.put("refundAmount", refundAmount);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            response.put("success", false);
            response.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
}
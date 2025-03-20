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

/**
 * 예약 관련 요청을 처리하는 컨트롤러
 * 사용자의 현재 예약, 이전 예약, 예약 취소 등 예약과 관련된 모든 웹 요청을 처리함
 */
@Controller
@RequestMapping("/resv")
public class ResvController {

    @Autowired
    private ResvService resvService;

    /**
     * 사용자의 현재 예약 목록을 조회하여 보여주는 페이지
     * 
     * @param model 뷰에 전달할 데이터를 담는 모델 객체
     * @return 현재 예약 조회 페이지의 뷰 이름 또는 로그인 페이지로의 리다이렉트
     */
    @GetMapping("/current")
    public String getCurrentResv(Model model) {
        try {
            // 현재 로그인한 사용자 정보 확인
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (!(auth.getPrincipal() instanceof CustomUserDetails)) {
                return "redirect:/auth/login"; // 로그인되지 않은 경우 로그인 페이지로 리다이렉트
            }

            // 로그인한 사용자의 회원 코드 추출
            CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();
            int memberCode = userDetails.getMemberCode();

            // 사용자의 현재 예약 목록 조회
            List<ResvDTO> reservations = resvService.getCurrentResv(memberCode);
            model.addAttribute("reservations", reservations);

            return "resv/current"; // 현재 예약 조회 페이지 리턴
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/auth/login"; // 오류 발생시 로그인 페이지로 리다이렉트
        }
    }

    /**
     * 결제 ID를 통해 특정 예약 정보를 조회하여 현재 예약 페이지에 표시
     * 주로 결제 완료 후 예약 상세 페이지로 리다이렉트되는 경우 사용
     * 
     * @param payId 조회할 결제 ID
     * @param model 뷰에 전달할 데이터를 담는 모델 객체
     * @return 현재 예약 조회 페이지의 뷰 이름 또는 오류 페이지로의 리다이렉트
     */
    @GetMapping("/current/payment/{payId}")
    public String getCurrentResvByPayment(@PathVariable("payId") int payId, Model model) {
        try {
            // 현재 로그인한 사용자 정보 확인
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (!(auth.getPrincipal() instanceof CustomUserDetails)) {
                return "redirect:/auth/login"; // 로그인되지 않은 경우 로그인 페이지로 리다이렉트
            }

            // 로그인한 사용자의 회원 코드 추출
            CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();
            int memberCode = userDetails.getMemberCode();

            // 결제 ID로 예약 정보 조회
            ResvDTO reservation = resvService.getReservationByPayId(payId);

            // 결제 정보가 없는 경우 에러 페이지로 리다이렉트
            if (reservation == null) {
                return "redirect:/error?message=해당 결제 정보를 찾을 수 없습니다.";
            }

            // 보안 검사: 현재 로그인한 사용자의 예약인지 확인
            if (reservation.getMemberCode() != memberCode) {
                return "redirect:/error?message=접근 권한이 없습니다.";
            }

            // 단일 예약을 리스트에 담아서 전달 (현재 예약 페이지와 같은 형태로 표시하기 위함)
            List<ResvDTO> reservations = new ArrayList<>();
            reservations.add(reservation);
            model.addAttribute("reservations", reservations);

            // 결제 ID로 조회했음을 표시하는 추가 정보 전달
            model.addAttribute("fromPayment", true);
            model.addAttribute("payId", payId);

            return "resv/current"; // 현재 예약 조회 페이지 리턴
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/error?message=" + e.getMessage(); // 오류 발생시 에러 메시지와 함께 에러 페이지로 리다이렉트
        }
    }

    /**
     * 사용자의 이전 예약 목록(지난 예약 또는 취소된 예약)을 조회하여 보여주는 페이지
     * 
     * @param model 뷰에 전달할 데이터를 담는 모델 객체
     * @return 이전 예약 조회 페이지의 뷰 이름 또는 로그인 페이지로의 리다이렉트
     */
    @GetMapping("/past")
    public String getPastResv(Model model) {
        try {
            // 현재 로그인한 사용자 정보 확인
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (!(auth.getPrincipal() instanceof CustomUserDetails)) {
                return "redirect:/auth/login"; // 로그인되지 않은 경우 로그인 페이지로 리다이렉트
            }

            // 로그인한 사용자의 회원 코드 추출
            CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();
            int memberCode = userDetails.getMemberCode();

            // 사용자의 이전 예약 목록 조회 및 모델에 추가
            model.addAttribute("resvList", resvService.getPastResv(memberCode));
            return "resv/past"; // 이전 예약 조회 페이지 리턴
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/auth/login"; // 오류 발생시 로그인 페이지로 리다이렉트
        }
    }

    /**
     * 사용자의 취소 가능한 예약 목록을 조회하여 보여주는 페이지
     * 체크인 날짜가 현재 이후인 예약만 취소 가능
     * 
     * @param model 뷰에 전달할 데이터를 담는 모델 객체
     * @return 예약 취소 페이지의 뷰 이름 또는 로그인 페이지로의 리다이렉트
     */
    @GetMapping("/cancel")
    public String getCancelableResv(Model model) {
        try {
            // 현재 로그인한 사용자 정보 확인
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (!(auth.getPrincipal() instanceof CustomUserDetails)) {
                return "redirect:/auth/login"; // 로그인되지 않은 경우 로그인 페이지로 리다이렉트
            }

            // 로그인한 사용자의 회원 코드 추출
            CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();
            int memberCode = userDetails.getMemberCode();

            // 사용자의 취소 가능한 예약 목록 조회 및 모델에 추가
            model.addAttribute("reservations", resvService.getCancelableResv(memberCode));
            return "resv/cancel"; // 예약 취소 페이지 리턴
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/auth/login"; // 오류 발생시 로그인 페이지로 리다이렉트
        }
    }

    /**
     * 예약 취소 요청을 처리하는 REST 엔드포인트
     * AJAX 요청을 통해 호출되며, 예약 취소 및 환불 처리를 수행
     * 
     * @param resvId 취소할 예약 ID
     * @param requestData 요청 데이터(환불 금액 등 포함)
     * @return 요청 처리 결과를 담은 ResponseEntity 객체
     */
    @PostMapping("/cancel/{resvId}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> cancelReservation(
            @PathVariable int resvId,
            @RequestBody Map<String, Object> requestData) {
        Map<String, Object> response = new HashMap<>();

        try {
            // 현재 로그인한 사용자 정보 확인
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (!(auth.getPrincipal() instanceof CustomUserDetails)) {
                response.put("success", false);
                response.put("message", "로그인이 필요합니다.");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
            }

            // 로그인한 사용자의 회원 코드 추출
            CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();
            int memberCode = userDetails.getMemberCode();
            
            // 환불 금액 가져오기
            int refundAmount = 0;
            if (requestData.containsKey("refundAmount")) {
                refundAmount = Integer.parseInt(requestData.get("refundAmount").toString());
            }

            // 예약 취소 및 환불 처리
            resvService.cancelReservationWithRefund(resvId, memberCode, refundAmount);
            
            // 성공 응답 반환
            response.put("success", true);
            response.put("refundAmount", refundAmount);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // 오류 처리 및 실패 응답 반환
            e.printStackTrace();
            response.put("success", false);
            response.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
}
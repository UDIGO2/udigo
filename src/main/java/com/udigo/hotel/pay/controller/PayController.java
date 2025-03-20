package com.udigo.hotel.pay.controller;

import com.udigo.hotel.acm.model.dto.AcmDTO;
import com.udigo.hotel.member.security.CustomUserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.udigo.hotel.member.model.dto.MemberDTO;
import com.udigo.hotel.pay.model.service.PayService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.time.format.DateTimeFormatter;
import jakarta.servlet.http.HttpServletRequest;
import com.udigo.hotel.pay.model.dto.PayDTO;

/*
 * 결제 관련 요청을 처리하는 컨트롤러
 * 결제 페이지 표시, 결제 정보 저장, 결제 내역 조회 등의 기능을 제공
 */
@Controller
@RequestMapping("/pay")
public class PayController {
    private final PayService payService;
    public PayController(PayService payService) {
        this.payService = payService;
    }

    private static final Logger logger = LoggerFactory.getLogger(PayController.class);

    /*
     * 접속자 정보를 가져오는 헬퍼 메소드
     * Spring Security Context에서 현재 인증된 사용자 정보를 추출
     * 
     * @return 현재 인증된 사용자의 CustomUserDetails 객체, 인증되지 않은 경우 null
     */
    private CustomUserDetails getMemberData() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication(); // 보안 정보 가져오기
        if (auth != null && auth.getPrincipal() instanceof CustomUserDetails) {
            return (CustomUserDetails) auth.getPrincipal(); // 접속자 정보 가져오기
        }
        return null;
    }

    /*
     * 결제 페이지를 표시하는 메소드
     * 예약 정보를 받아 결제 페이지에 필요한 데이터를 모델에 추가
     * 
     * @param acmId 숙소 ID
     * @param acmName 숙소 이름
     * @param acmPrice 숙소 가격
     * @param acmPhoto 숙소 사진 URL
     * @param checkInDate 체크인 날짜
     * @param checkOutDate 체크아웃 날짜
     * @param guestCount 투숙객 수
     * @param model Spring MVC 모델
     * @return 결제 페이지 뷰 이름 또는 로그인 페이지로 리다이렉션
     */
    @PostMapping("/payment")
    public String showPaymentPage(@RequestParam String acmId,
                                  @RequestParam String acmName,
                                  @RequestParam String acmPrice,
                                  @RequestParam String acmPhoto,
                                  @RequestParam String checkInDate,
                                  @RequestParam String checkOutDate,
                                  @RequestParam String guestCount,
                                  Model model) {
        
        logger.info("결제 페이지 요청 - 숙소: {}, 체크인: {}, 체크아웃: {}, 인원: {}", 
                   acmName, checkInDate, checkOutDate, guestCount);
        
        try {
            // 로그인 확인
            CustomUserDetails userDetails = getMemberData();
            if (userDetails == null) {
                return "redirect:/auth/login";
            }
            
            // 회원 정보 조회
            MemberDTO memberInfo = payService.getMemberInfo(userDetails.getMemberCode());
            
            // 숙박 일수 계산
            LocalDate start = LocalDate.parse(checkInDate);
            LocalDate end = LocalDate.parse(checkOutDate);
            long nights = ChronoUnit.DAYS.between(start, end);
            
            // 총 가격 계산 (숙박일수 * 숙소가격)
            long totalPrice = nights * Long.parseLong(acmPrice);
            
            // 모델에 데이터 추가
            model.addAttribute("memberInfo", memberInfo);
            model.addAttribute("acmId", acmId);
            model.addAttribute("acmName", acmName);
            model.addAttribute("acmPrice", acmPrice);
            model.addAttribute("acmPhoto", acmPhoto);
            model.addAttribute("checkInDate", checkInDate);
            model.addAttribute("checkOutDate", checkOutDate);
            model.addAttribute("guestCount", guestCount);
            model.addAttribute("nights", nights);
            model.addAttribute("totalPrice", totalPrice);
            
            return "pay/payment";
        } catch (Exception e) {
            logger.error("결제 페이지 처리 중 오류 발생: ", e);
            return "redirect:/error";
        }
    }

    /*
     * API 결제 성공 후 결제 데이터를 저장하는 메소드
     * 클라이언트에서 전송한 결제 정보를 DB에 저장하고 결과를 JSON으로 반환
     * 
     * @param paymentData 클라이언트에서 전송한 결제 정보
     * @return 결제 저장 결과를 담은 ResponseEntity 객체
     */
    @PostMapping("/save")
    @ResponseBody
    public ResponseEntity<?> savePayment(@RequestBody Map<String, Object> paymentData) {
        try {
            logger.info(" 결제 요청 데이터: " + paymentData);

            // 로그인 확인
            CustomUserDetails userDetails = getMemberData();
            if (userDetails == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(Map.of("message", "로그인이 필요합니다.", "status", false));
            }
            
            // 멤버 코드 추가
            paymentData.put("memberCode", userDetails.getMemberCode());

            // 결제 정보 저장
            payService.savePaymentRecord(paymentData);

            return ResponseEntity.ok(Map.of("message", " 결제 성공!", "status", true));
        } catch (Exception e) {
            logger.error(" 결제 처리 오류: ", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("message", " 결제 저장 실패!", "status", false));
        }
    }
    
    /*
     * 모바일 결제 완료 후 리다이렉션을 처리하는 메소드
     * 모바일에서 결제 완료 후 호출되는 콜백 URL
     * 
     * @param merchant_uid 상점 주문번호
     * @param imp_uid 포트원 결제 고유번호
     * @param error_msg 오류 메시지
     * @param model Spring MVC 모델
     * @return 리다이렉션 URL 또는 오류 페이지
     * 
     * @implNote 현재는 단순 리다이렉션만 수행. 결제 검증 로직 추가 필요
     * @ 포트원 API를 사용하여 imp_uid로 결제 정보를 검증하고 DB에 저장하는 로직 구현
     */
    @GetMapping("/complete")
    public String paymentComplete(@RequestParam(required = false) String merchant_uid,
                                 @RequestParam(required = false) String imp_uid,
                                 @RequestParam(required = false) String error_msg,
                                 Model model) {
        
        logger.info("모바일 결제 완료 - merchant_uid: {}, imp_uid: {}", merchant_uid, imp_uid);
        
        if (error_msg != null && !error_msg.isEmpty()) {
            logger.error("결제 오류 발생: {}", error_msg);
            model.addAttribute("errorMsg", error_msg);
            return "pay/paymentError";
        }
        
        // 여기서 실제로는 imp_uid를 사용하여 포트원 API로 결제 정보를 검증할 수 있음
        // 검증이 완료되면 savePayment 메서드처럼 결제 정보를 저장
        
        return "redirect:/resv/current";
    }

    /*
     * 회원별 결제 내역 조회 페이지
     * 로그인한 회원의 결제 내역을 기간별로 조회하여 표시
     * 
     * @param model Spring MVC 모델
     * @param startDate 시작 날짜 (선택)
     * @param endDate 종료 날짜 (선택)
     * @return 결제 내역 페이지 뷰 이름 또는 로그인 페이지로 리다이렉션
     */
    @GetMapping("/payList")
    public String getPaymentsByMember(Model model,
                                      @RequestParam(required = false) String startDate,
                                      @RequestParam(required = false) String endDate) {
        // 로그인 정보에서 회원 정보 가져오기
        CustomUserDetails userDetails = getMemberData();
        if (userDetails == null) {
            return "redirect:/auth/login"; // 로그인 페이지로 리다이렉트
        }
        
        int memberCode = userDetails.getMemberCode();
        
        // 기간 설정이 없을 경우 기본값 (최근 3개월)
        if (startDate == null || endDate == null) {
            LocalDate today = LocalDate.now();
            LocalDate threeMonthsAgo = today.minusMonths(3);
            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            endDate = today.format(formatter);
            startDate = threeMonthsAgo.format(formatter);
        }
        
        // 종료일에 시간을 23:59:59로 설정하기 위해 하루를 더함
        LocalDate endDatePlusOne = LocalDate.parse(endDate).plusDays(1);
        String endDateWithTime = endDatePlusOne.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        
        // 회원의 결제 내역 조회
        List<PayDTO> payments = payService.getMemberPayments(memberCode, startDate, endDateWithTime);
        
        model.addAttribute("payments", payments);
        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);
        
        return "pay/payList";
    }
}
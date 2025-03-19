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

@Controller
@RequestMapping("/pay")
public class PayController {
    private final PayService payService;
    public PayController(PayService payService) {
        this.payService = payService;
    }

    private static final Logger logger = LoggerFactory.getLogger(PayController.class);

    // 접속자 정보 가져오는 메소드
    private CustomUserDetails getMemberData() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication(); // 보안 정보 가져오기
        if (auth != null && auth.getPrincipal() instanceof CustomUserDetails) {
            return (CustomUserDetails) auth.getPrincipal(); // 접속자 정보 가져오기
        }
        return null;
    }

    // 결제 페이지 보여주기
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

    // API 결제 성공 후 컨트롤러에서 결제 데이터 저장
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
    
    // 모바일 결제 완료 후 리다이렉션 처리
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
}
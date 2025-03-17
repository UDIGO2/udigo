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
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/payment")
public class PayController {
    private final PayService payService;
    public PayController(PayService payService) {
        this.payService = payService;
    }

    private static final Logger logger = LoggerFactory.getLogger(PayController.class);

    // 접속자 정보 가져오는 메서드
    private CustomUserDetails getMemberData() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication(); // 보안 정보 가져오기
        return (CustomUserDetails) auth.getPrincipal(); // 접속자 정보 가져오기
    }

    // 사용자가 체크한 장바구니 아이템 조회
    @PostMapping
    public ResponseEntity<Map<String, Object>> payment(@RequestBody Map<String, Object> requestData) {
        // 반환할 response 생성
        Map<String, Object> response = new HashMap<>();

        try {
            // 사용자가 체크한 장바구니 아이템 상세 조회
            AcmDTO cartItems = payService.getCartItems(Integer.parseInt((String) requestData.get("selectedIds")));

            // 접속한 사용자 정보 가져오기
            MemberDTO memberInfo = payService.getMemberInfo(getMemberData().getMemberCode());

            response.put("cartItems", cartItems);
            response.put("memberInfo", memberInfo);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("errorMsg", "로그인이 필요합니다.");

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }


    // API 결제 성공 후 컨트롤러에서 결제 데이터 저장
    @PostMapping("/save")
    public ResponseEntity<?> savePayment(@RequestBody Map<String, Object> paymentData) {
        try {
            logger.info("✅ 결제 요청 데이터: " + paymentData);

            // 결제 정보 저장
            payService.savePaymentRecord(paymentData);

            return ResponseEntity.ok(Map.of("message", "✅ 결제 성공!", "status", true));
        } catch (Exception e) {
            System.out.println("❌ 결제 처리 오류: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("message", "❌ 결제 저장 실패!", "status", false));
        }
    }

}
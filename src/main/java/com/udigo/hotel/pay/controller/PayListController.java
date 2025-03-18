package com.udigo.hotel.pay.controller;

import com.udigo.hotel.member.security.CustomUserDetails;
import com.udigo.hotel.pay.model.service.PayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/payList")
public class PayListController {
    private final PayService payService;
    public PayListController(PayService payService) {
        this.payService = payService;
    }

    private static final Logger logger = LoggerFactory.getLogger(PayListController.class);

    // 접속자 정보 가져오는 메서드
    private CustomUserDetails getMemberData() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication(); // 보안 정보 가져오기
        return (CustomUserDetails) auth.getPrincipal(); // 접속자 정보 가져오기
    }

    // 사용자가 예약한 숙소 내역 출력
    @PostMapping
    public ResponseEntity<Map<String, Object>> payment() {
        // 반환할 response 생성
        Map<String, Object> response = new HashMap<>();

//        try {
        // 사용자가 예약한 숙소 내역 상세 조회
        List<Map<String, Object>> payListItems = payService.getPayListItems(getMemberData().getMemberCode());

        logger.info("payListItems: " + payListItems);

        response.put("payListItems", payListItems);

        return ResponseEntity.ok(response);
//        } catch (Exception e) {
//            response.put("errorMsg", "로그인이 필요합니다.");
//
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
//        }
    }
}
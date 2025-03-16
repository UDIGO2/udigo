package com.udigo.hotel.pay.controller;

import com.udigo.hotel.pay.model.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RestController
@RequestMapping("/payment")
public class PayController {

    @Autowired
    private PayService payService;


    // 프론트에서 /pay/payment-perview API를 호출하면 결제 예정 숙소 정보를 Json으로 반환
    @PostMapping
    public ResponseEntity<Map<String, Object>> processPayment(@RequestBody Map<String, Object> requestData) {
        // TODO: cartController 참고
        String memberCode = (String) requestData.get("member_code");
        String payMethod = (String) requestData.get("pay_method");
        // TODO: acmId 리스트 추가



        List<Map<String, Object>> accommodations = (List<Map<String, Object>>) requestData.get("accommodations");

        // ✅ 결제 ID 생성
        String payId = UUID.randomUUID().toString();

        // ✅ 결제 정보 DB 저장
        boolean isSaved = savePaymentToDatabase(memberCode, payId, payMethod, accommodations);

        // ✅ 응답 데이터 생성
        Map<String, Object> response = new HashMap<>();
        response.put("success", isSaved);
        response.put("pay_id", payId);

        return ResponseEntity.ok(response);
    }

    private boolean savePaymentToDatabase(String memberCode, String payId, String payMethod, List<Map<String, Object>> accommodations) {
        try {
            System.out.println("🔹 결제 저장: " + payId + " / 회원: " + memberCode);
            return true;
        } catch (Exception e) {
            return false;
        }
    }




}





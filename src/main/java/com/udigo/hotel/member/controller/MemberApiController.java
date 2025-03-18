package com.udigo.hotel.member.controller;

import com.udigo.hotel.member.model.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/member") // ✅ API 전용 엔드포인트 생성
public class MemberApiController {

    @Autowired
    private MemberService memberService;

    /** ✅ 쿠폰 사용 여부 조회 API */
    @GetMapping("/coupons")
    public ResponseEntity<String> getCouponStatus(@RequestParam("memberId") String memberId) {
        System.out.println("✅ 쿠폰 조회 요청: memberId = " + memberId);

        if (memberId == null || memberId.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("잘못된 요청입니다.");
        }

        boolean couponUsed = memberService.checkCouponStatus(memberId);
        return ResponseEntity.ok(couponUsed ? "이미 사용한 쿠폰입니다." : "사용 가능한 쿠폰이 있습니다!");
    }
}

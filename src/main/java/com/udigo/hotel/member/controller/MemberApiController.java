package com.udigo.hotel.member.controller;

import com.udigo.hotel.member.model.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller //  @RestController 대신 @Controller 사용
@RequestMapping("/api/member") //  API 전용 엔드포인트 생성
public class MemberApiController {

    @Autowired
    private MemberService memberService;

    /* 쿠폰 사용 여부 조회 API */
    @GetMapping("/coupons")
    @ResponseBody //  JSON 데이터를 반환하기 위해 추가
    public ResponseEntity<String> getCouponStatus(@RequestParam("memberId") String memberId) {
        System.out.println(" 쿠폰 조회 요청: memberId = " + memberId);

        if (memberId == null || memberId.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("잘못된 요청입니다.");
        }

        boolean couponUsed = memberService.checkCouponStatus(memberId);
        return ResponseEntity.ok(couponUsed ? "이미 사용한 쿠폰입니다." : "사용 가능한 쿠폰이 있습니다!");
    }
}

package com.udigo.hotel.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String mainPage() {
        return "main/main";  // templates/main/main.html을 반환
    }

    // 결제 페이지
    @GetMapping("/payment")
    public String paymentPage() {
        return "pay/payment";
    }

    // 회원별 결제 내역 조회
    @GetMapping("/payList")
    public String payListPage() {
        return "pay/payList";
    }

    @GetMapping("/cart-main")
    public String cart() {
        return "cart/cart";  // 다른 뷰로 변경
    }

}

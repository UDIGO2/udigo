package com.udigo.hotel.main;

import com.udigo.hotel.member.security.CustomUserDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String mainPage(Model model, @AuthenticationPrincipal CustomUserDetails userDetails) {
        if (userDetails != null) {
            int memberCode = userDetails.getMemberCode(); // ✅ memberCode 가져오기
            model.addAttribute("memberCode", String.valueOf(memberCode));
        }
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

    // 회원별 결제 내역 조회
    @GetMapping("/admin/adminpay")
    public String adminPay() {
        return "pay/admin/adminpay";
    }


    @GetMapping("/cart-main")
    public String cart() {
        return "cart/cart";  // 다른 뷰로 변경
    }

}

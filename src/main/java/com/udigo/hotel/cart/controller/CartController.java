package com.udigo.hotel.cart.controller;

import com.udigo.hotel.cart.model.dto.CartDTO;
import com.udigo.hotel.cart.model.service.CartService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public String cartList(Model model) {
        // model.addAttribute("someData", someValue);
        return "cart/cart"; // 뷰 이름
    }

    @GetMapping("/session")
    public String cartList(HttpSession session, Model model) {
        Integer memberCode = (Integer) session.getAttribute("memberCode");
        if (memberCode == null) {
            return "redirect:/member/login";
        }


        List<CartDTO> cartList = cartService.getCartByMember(memberCode);
        model.addAttribute("cartList", cartList);
        return "cart/cartList";  // Thymeleaf 템플릿으로 반환
    }
    // 장바구니에 숙소 추가
    @PostMapping("/add")
    public String addToCart(HttpSession session, @RequestParam int acmId) {
        Integer memberCode = (Integer) session.getAttribute("memberCode");
        if (memberCode == null) {
            return "redirect:/member/login";
        }

        cartService.addToCart(memberCode, acmId);
        return "redirect:/cart";  // 장바구니로 다시 리디렉션
    }

    @PostMapping("/delete")
    public String deleteCartItem(@RequestParam("cartCode") int cartCode) {
        cartService.deleteCartItem(cartCode);
        return "redirect:/cart";  // 장바구니로 다시 리디렉션
    }

}

package com.udigo.hotel.cart.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.udigo.hotel.cart.model.dto.CartDTO;
import com.udigo.hotel.cart.model.service.CartService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    // 장바구니 목록 조회 (로그인 없이 세션 기반으로)
    @GetMapping
    public String cartList(HttpSession session, Model model) {
        Integer memberCode = (Integer) session.getAttribute("memberCode");

        List<CartDTO> cartItems = new ArrayList<>();
        if (memberCode != null) {
            // 로그인한 경우, DB에서 장바구니 데이터 불러오기
            cartItems = cartService.getCartItems(memberCode);
        }

        model.addAttribute("cartItems", cartItems);

        // 장바구니가 비었으면 cart.html, 상품이 있으면 cartadd.html 반환
        return cartItems.isEmpty() ? "cart/cart" : "cart/cartadd";
    }

    // 장바구니에 아이템 추가 (세션 기반)
    @PostMapping("/add")
    public String addItemToCart(@RequestParam int acmId, HttpSession session) {
        Integer memberCode = (Integer) session.getAttribute("memberCode");

        if (memberCode != null) {
            // 로그인한 경우, DB에 추가
            cartService.addItemToCart(memberCode, acmId);
        } else {
            // 로그인하지 않은 경우, 세션에 저장
            List<CartDTO> cartItems = (List<CartDTO>) session.getAttribute("cart");
            if (cartItems == null) {
                cartItems = new ArrayList<>();
            }
            cartItems.add(new CartDTO(0, 0, acmId)); // 임시 cartCode, memberCode=0으로 설정
            session.setAttribute("cart", cartItems);
        }

        return "redirect:/cart";

        // ✅ 장바구니에서 결제 페이지(`payment.html`)로 이동
//        @PostMapping("/payment")
//        public String payment(@RequestParam("cartItemsJson") String cartItemsJson, Model model) {
//            List<CartDTO> cartItems = new ArrayList<>();
//            try {
//                ObjectMapper objectMapper = new ObjectMapper();
//                cartItems = objectMapper.readValue(cartItemsJson, new TypeReference<List<CartDTO>>() {});
//            } catch (JsonProcessingException e) {
//                e.printStackTrace();
//            }
//
//            model.addAttribute("cartItems", cartItems);
//            return "payment"; // ✅ 결제 페이지(`payment.html`)로 이동
        }
    }
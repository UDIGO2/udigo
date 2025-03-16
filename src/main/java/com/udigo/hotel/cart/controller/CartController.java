package com.udigo.hotel.cart.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.udigo.hotel.acm.model.service.AcmService;
import com.udigo.hotel.cart.model.dto.CartDTO;
import com.udigo.hotel.cart.model.dto.CartParamDTO;
import com.udigo.hotel.cart.model.service.CartService;
import com.udigo.hotel.member.model.dto.MemberDTO;
import com.udigo.hotel.member.model.service.MemberService;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping( method = RequestMethod.GET,value = "/cart")
public class CartController {

    private final CartService cartService;
    private final MemberService memberService;
    private final AcmService acmService;

    public CartController(CartService cartService, MemberService memberService, AcmService acmService) {
        this.cartService = cartService;
        this.memberService = memberService;
        this.acmService = acmService;
    }

    // TODO: 참고
    private int getMemberCode() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        MemberDTO memberDTO = memberService.findMemberById(auth.getName());
        return memberDTO.getMemberCode();
    }

    // 장바구니 목록 조회 (로그인 없이 세션 기반으로)
    @GetMapping
    public String cartList(Model model) {
        List<CartDTO> cartItems = cartService.getCartItems(getMemberCode());

        if (cartItems.isEmpty()) {
            model.addAttribute("cartItems", new ArrayList<>());
        } else {
            List<Integer> cartIds = cartItems.stream().map(CartDTO::getAcmId).collect(Collectors.toList());

            model.addAttribute("cartItems", acmService.getAcmsFromCart(cartIds));
        }

        return "cart/cart";
    }

    // 장바구니에 아이템 추가 (세션 기반)
    @PostMapping("/add")
    public String addItemToCart(@RequestBody Map<String, Object> requestBody) {
        int acmId = (int) requestBody.get("acmId");

        System.out.println("acmId" + acmId);

        cartService.addItemToCart(getMemberCode(), acmId);

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

    @DeleteMapping("/delete")
    public String deleteItems(@RequestBody List<Integer> requestBody) {

        int memberCode = getMemberCode();

        List<CartParamDTO> cartParamItems = new ArrayList<>();
        for (Integer acmId : requestBody) {
            cartParamItems.add(new CartParamDTO(memberCode, acmId));  // 직접 추가
        }

        cartService.deleteItemFromCart(cartParamItems);

        return "cart/cartadd";
    }
}
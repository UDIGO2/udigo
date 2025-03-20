package com.udigo.hotel.cart.controller;

import com.udigo.hotel.acm.model.service.AcmService;
import com.udigo.hotel.cart.model.dto.CartDTO;
import com.udigo.hotel.cart.model.dto.CartParamDTO;
import com.udigo.hotel.cart.model.service.CartService;
import com.udigo.hotel.member.model.dto.MemberDTO;
import com.udigo.hotel.member.model.service.MemberService;
import com.udigo.hotel.member.security.CustomUserDetails;
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

//    // TODO: 참고
//    private int getMemberCode() {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        MemberDTO memberDTO = memberService.findMemberById(auth.getMemberId());
//        return memberDTO.getMemberCode();
//    }

    /* 오류 때문에 이걸로 바꿔 놓긴했는데 확인부탁드립니다! */
    private int getMemberCode() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        // 인증되지 않은 사용자일 경우 기본값 반환
        if (auth == null || !auth.isAuthenticated() || auth.getPrincipal().equals("anonymousUser")) {
            throw new IllegalStateException("인증되지 않은 사용자입니다.");
        }

        // 현재 로그인한 사용자 정보 가져오기 (CustomUserDetails로 변환)
        CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();

        // memberId를 이용해 DB에서 memberCode 조회
        MemberDTO memberDTO = memberService.findByMemberId(userDetails.getMemberId());

        if (memberDTO == null) {
            throw new IllegalStateException("사용자 정보를 찾을 수 없습니다.");
        }

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

        // 장바구니에서 결제 페이지(`payment.html`)로 이동
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
//            return "payment"; // 결제 페이지(`payment.html`)로 이동
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
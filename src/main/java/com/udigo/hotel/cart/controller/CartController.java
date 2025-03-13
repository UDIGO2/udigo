package com.udigo.hotel.cart.controller;

import com.udigo.hotel.cart.model.dto.CartDTO;
import com.udigo.hotel.cart.model.service.CartService;
import com.udigo.hotel.member.model.dto.MemberDTO;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;
    private static final Logger logger = LoggerFactory.getLogger(CartController.class);

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    private MemberDTO getLoginMember(HttpSession session) {
        return (MemberDTO) session.getAttribute("loginMember");
    }


    @GetMapping("/page")
    public String showCart(Model model) {
        return "cart/page";  // cart.html을 렌더링
    }

    // 장바구니 추가
    @PostMapping("/add")
    public String addCart(@RequestParam("acmId") int acmId, HttpSession session, Model model) {
        MemberDTO member = getLoginMember(session);
        if (member == null) {
            return "redirect:/member/login";
        }
        CartDTO cartDTO = new CartDTO();
        cartDTO.setMemberCode(member.getMemberCode());
        cartDTO.setAcmId(acmId);
        try {
            cartService.addCart(cartDTO);
            logger.info("장바구니에 숙소 추가: {}", cartDTO);
        } catch (Exception e) {
            logger.error("장바구니 추가 중 오류 발생: {}", e.getMessage(), e);
            model.addAttribute("errorMessage", "오류가 발생했습니다. 다시 시도해 주세요.");
            return "redirect:/cart/list";
        }
        return "redirect:/cart/list";
    }

    // 장바구니 목록 조회
    @GetMapping("/list")
    public String cartList(HttpSession session, Model model) {
        MemberDTO member = (MemberDTO) session.getAttribute("loginMember");
        if (member == null) {
            return "redirect:/member/login";
        }

        List<CartDTO> cartList = cartService.getCartList(member.getMemberCode());
        model.addAttribute("cartList", cartList);
        model.addAttribute("emptyCart", cartList == null || cartList.isEmpty());
        return "cart/cart";  // cart/cart.html을 렌더링
    }

    // 장바구니 삭제
    @PostMapping("/delete")
    public String deleteCart(@RequestParam("cartCode") int cartCode) {
        cartService.removeCart(Collections.singletonList(cartCode));
        return "redirect:/cart/list";
    }

    // 수량 업데이트
    @PostMapping("/updateQuantity")
    public String updateQuantity(@RequestParam("cartCode") int cartCode, @RequestParam("change") int change) {
        cartService.updateQuantity(cartCode, change);
        return "redirect:/cart/list";
    }

    // 구매하기 (현재는 기능 없음)
    @PostMapping("/checkout")
    public String checkout(@RequestParam("cartCodes") List<Integer> cartCodes, HttpSession session, Model model) {
        return "redirect:/cart/list";
    }
}
package com.udigo.hotel.cart.controller;


import com.udigo.hotel.cart.model.dto.CartDTO;
import com.udigo.hotel.cart.model.service.CartService;
import com.udigo.hotel.member.model.dto.MemberDTO;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;

    @PostMapping("/add")
    public String addCart(@ModelAttribute CartDTO cartDTO, HttpSession session) {
        MemberDTO member = (MemberDTO)session.getAttribute("loginMember");
//        cartDTO.setMemberCode( member.getMemberCode()));
        cartService.addCart(cartDTO);
        return "redirect:/cart/list";
    }

    @GetMapping("/list")
    public String cartList(HttpSession session, Model model) {
        MemberDTO member = (MemberDTO)session.getAttribute("loginMember");
//        model.addAttribute("cartList", cartService.getCartList( member.getMemberCode()));
        return "cart/cartList";
    }

    @PostMapping("/delete")
    public String deleteCart(@RequestParam int cartCode) {
        cartService.removeCart(cartCode);
        return "redirect:/cart/list";
    }

    @PostMapping("/checkout")
    public String checkoutCart(@RequestParam("cartCodes") List<Integer> cartCodes,
                               HttpSession session,
                               Model model) {

        MemberDTO member = (MemberDTO) session.getAttribute("loginMember");
        if(member == null) {
            return "redirect:/member/login";
        }

//        List<CartDTO> selectedItems = cartService.getSelectedCartItems(cartCodes);
//        int totalPrice = cartService.calculateTotalPrice(selectedItems);

//        model.addAttribute("selectedItems", selectedItems);
//        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("member", member);

        return "pay/payStart";
    }
}

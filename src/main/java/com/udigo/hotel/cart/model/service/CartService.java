package com.udigo.hotel.cart.model.service;

import com.udigo.hotel.cart.model.dao.CartMapper;
import com.udigo.hotel.cart.model.dto.CartDTO;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CartService {
    private final CartMapper cartMapper;

    public CartService(CartMapper cartMapper) {
        this.cartMapper = cartMapper;
    }
    // 장바구니 목록 조회 (회원별)
    public List<CartDTO> getCartByMember(int memberCode) {
        return cartMapper.selectCartByMemberCode(memberCode);
    }
    // 장바구니 아이템 추가
    public void addToCart(int memberCode, int acmId) {
        cartMapper.insertCartItem(memberCode, acmId);
    }

    // 장바구니 아이템 삭제
    public void deleteCartItem(int cartCode) {
        cartMapper.deleteCartItem(cartCode);
    }


}

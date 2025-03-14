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

    // 장바구니 조회
    public List<CartDTO> getCartItems(int memberCode) {
        return cartMapper.selectCartItems(memberCode);
    }

    // 장바구니에 추가
    public void addItemToCart(int memberCode, int acmId) {
        cartMapper.insertCartItem(memberCode, acmId);
    }

    // 장바구니에서 삭제
    public void removeItemFromCart(int acmId, int memberCode) {
        cartMapper.deleteCartItem(acmId, memberCode);
    }
}
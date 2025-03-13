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

    // 기존의 장바구니 추가 메소드
    public void addCart(CartDTO cartDTO) {
        cartMapper.insertCart(cartDTO);
    }

    // 장바구니 목록 조회 메소드
    public List<CartDTO> getCartList(int memberCode) {
        return cartMapper.selectCartByMemberCode(memberCode);
    }

    // 장바구니 삭제 메소드
    public void removeCart(List<Integer> cartCodes) {
        cartMapper.deleteCart(cartCodes);
    }

    // 수량 업데이트 메소드
    public void updateQuantity(int cartCode, int change) {
        CartDTO cartDTO = cartMapper.selectCartByCode(cartCode);
        if (cartDTO != null) {
            // 기존 수량에 change만큼 더하거나 빼는 로직
            int updatedQuantity = cartDTO.getQuantity() + change;
            if (updatedQuantity >= 0) {  // 수량이 0 이상이어야 하므로
                cartDTO.setQuantity(updatedQuantity);
                cartMapper.updateCart(cartDTO);
            }
        }
    }
}

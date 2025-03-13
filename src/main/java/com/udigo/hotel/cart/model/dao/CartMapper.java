package com.udigo.hotel.cart.model.dao;

import com.udigo.hotel.cart.model.dto.CartDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartMapper {
    void insertCart(CartDTO cartDTO);
    List<CartDTO> selectCartByMemberCode(int memberCode);
    void deleteCart(List<Integer> cartCode);

    // 장바구니 아이템 수량 업데이트 메소드
    void updateCart(CartDTO cartDTO);

    // 장바구니 아이템 조회 메소드 (수량 업데이트에 필요)
    CartDTO selectCartByCode(int cartCode);
}

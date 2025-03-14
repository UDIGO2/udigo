package com.udigo.hotel.cart.model.dao;

import com.udigo.hotel.cart.model.dto.CartDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CartMapper {

        // 장바구니 조회
        List<CartDTO> selectCartItems(int memberCode);

        // 장바구니에 추가
        void insertCartItem(@Param("memberCode") int memberCode, @Param("acmId") int acmId);

        // 장바구니에서 삭제
        void deleteCartItem(@Param("acmId") int acmId, @Param("memberCode") int memberCode);
}
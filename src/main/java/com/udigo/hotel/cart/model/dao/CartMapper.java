package com.udigo.hotel.cart.model.dao;

import com.udigo.hotel.cart.model.dto.CartDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CartMapper {

        List<CartDTO> getCartByUserId(@Param("memberCode") Long memberCode);

        @Select("SELECT * FROM tbl_cart WHERE member_code = #{memberCode}")
        List<CartDTO> selectCartByMemberCode(int memberCode);

        // 장바구니 아이템 추가
        @Insert("INSERT INTO tbl_cart (member_code, acm_id) VALUES (#{memberCode}, #{acmId})")
        void insertCartItem(int memberCode, int acmId);

        // 장바구니 아이템 삭제
        @Delete("DELETE FROM tbl_cart WHERE cart_code = #{cartCode}")
        void deleteCartItem(int cartCode);
}

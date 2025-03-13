package com.udigo.hotel.cart.model.dao;

import com.udigo.hotel.cart.model.dto.CartDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartMapper {
    void insertCart(CartDTO cartDTO);
    List<CartDTO> selectCartByMemberCode(int memberCode);
    void deleteCart(int cartCode);
}

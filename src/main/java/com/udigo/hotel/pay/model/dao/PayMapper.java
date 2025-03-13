package com.udigo.hotel.pay.model.dao;

import com.udigo.hotel.pay.model.dto.PayDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PayMapper {
    void insertPay(PayDTO payDTO);
    List<PayDTO> selectPayByMemberCode(int memberCode);
}

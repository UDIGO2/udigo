package com.udigo.hotel.pay.model.dao;

import com.udigo.hotel.pay.model.dto.PayDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.boot.json.JsonWriter;

import java.util.List;
import java.util.Map;

@Mapper
public interface PayMapper {
    void insertPay(PayDTO payDTO);
    List<PayDTO> selectPayByMemberCode(int memberCode);

    //장바구니에서 체크한 값(숙소)만 조회
    List<Map<String, Object>> getCheckedCartItemsForPayment(Map<String, Object> paramMap);

    //
    List<Map<String, Object>> getPaymentPreview(Map<String, Object> paramMap);

    // 회원이 장바구니에 담은 숙소 목록 조회
    List<Map<String, Object>> getCartItemsByMember(String memberCode);

    // 숙소 ID로 가격 조회
    Map<String, Object> getAccommodationPrice(int acmId);

//    @Mapper
//    public interface MemberMapper {
//        @Select("SELECT member_code, member_name, meme_phone FROM member WHERE member_code = #{memberCode}")
//        JsonWriter.Member findByMemberCode(String memberCode);
//    }

}

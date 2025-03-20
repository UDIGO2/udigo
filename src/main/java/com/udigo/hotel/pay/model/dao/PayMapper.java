package com.udigo.hotel.pay.model.dao;

import com.udigo.hotel.acm.model.dto.AcmDTO;
import com.udigo.hotel.member.model.dto.MemberDTO;
import com.udigo.hotel.pay.model.dto.PayDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface PayMapper {
    //  ============================
    //   Payment
    //  ============================

    // 사용자가 체크한 장바구니 아이템 조회
    AcmDTO getCartItems(int acmId);

    // 접속한 사용자 정보 조회
    MemberDTO getMemberInfo(@Param("member_code") int memberCode);

    // 결제 정보 저장
    void savePaymentRecord(Map<String, Object> paymentData);

    // 가장 최근 insert된 PayId 값 반환
    int getLastPayId();

    // 예약 정보 저장
    void saveReservationRecord(Map<String, Object> paymentData);



    //  ============================
    //   PayList
    //  ============================

    // 접속한 사용자가 예약했던 숙소 내역 조회
    List<Map<String, Object>> getPayListItems(@Param("memberCode") int memberCode);
    
    // 관리자용 - 모든 결제 내역 조회
    List<Map<String, Object>> getAllPayments();

    /**
     * 회원별 결제 내역 조회
     * @param memberCode 회원 코드
     * @param startDate 시작 날짜 (선택)
     * @param endDate 종료 날짜 (선택)
     * @return 회원의 결제 내역 목록
     */
    List<PayDTO> findPaymentsByMemberId(@Param("memberCode") int memberCode, 
                                       @Param("startDate") String startDate,
                                       @Param("endDate") String endDate);
}

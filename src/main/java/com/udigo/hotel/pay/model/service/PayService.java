package com.udigo.hotel.pay.model.service;

import com.udigo.hotel.acm.model.dto.AcmDTO;
import com.udigo.hotel.member.model.dto.MemberDTO;
import com.udigo.hotel.pay.model.dao.PayMapper;
import com.udigo.hotel.pay.model.dto.PayDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PayService {
    private final PayMapper payMapper;

    // ✅ 생성자 주입 방식
    @Autowired
    public PayService(PayMapper payMapper) {
        this.payMapper = payMapper;
    }

    //  ============================
    //   Payment
    //  ============================

    // 사용자가 체크한 장바구니 아이템 조회
    public AcmDTO getCartItems(int acmId) {
        return payMapper.getCartItems(acmId);
    }

    // 접속한 사용자 정보 가져오기
    public MemberDTO getMemberInfo(int memberCode) {
        return payMapper.getMemberInfo(memberCode);
    }

    // 결제 정보 저장
    public void savePaymentRecord(Map<String, Object> paymentData) {
        payMapper.savePaymentRecord(paymentData); // 결제 정보 저장
        int payId = payMapper.getLastPayId(); // 결제 ID 정보 가져오기
        paymentData.put("payId", payId); // 결제 ID 저장
        payMapper.saveReservationRecord(paymentData); // 예약 정보 저장
    }

    //  ============================
    //   PayList
    //  ============================

    // 접속한 사용자가 예약했던 숙소 내역 조회
    public List<Map<String, Object>> getPayListItems(int memberCode) {
        return  payMapper.getPayListItems(memberCode);
    }
    
    // 관리자용 - 모든 결제 내역 조회
    public List<Map<String, Object>> getAllPayments() {
        return payMapper.getAllPayments();
    }

    /**
     * 로그인한 회원의 결제 내역 조회
     * @param memberCode 회원 코드
     * @param startDate 시작 날짜 (선택)
     * @param endDate 종료 날짜 (선택)
     * @return 회원의 결제 내역 목록
     */
    public List<PayDTO> getMemberPayments(int memberCode, String startDate, String endDate) {
        return payMapper.findPaymentsByMemberId(memberCode, startDate, endDate);
    }
}

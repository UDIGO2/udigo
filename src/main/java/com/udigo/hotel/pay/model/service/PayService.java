package com.udigo.hotel.pay.model.service;

import com.udigo.hotel.acm.model.dto.AcmDTO;
import com.udigo.hotel.member.model.dto.MemberDTO;
import com.udigo.hotel.pay.model.dao.PayMapper;
import com.udigo.hotel.pay.model.dto.PayDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 결제 관련 비즈니스 로직을 처리하는 서비스 클래스
 * 결제 정보 저장, 조회 및 검증 등의 기능을 제공
 */
@Service
public class PayService {
    private final PayMapper payMapper;

    /**
     * 생성자 주입 방식을 통한 PayMapper 의존성 주입
     * 
     * @param payMapper 결제 관련 데이터 접근 매퍼
     */
    @Autowired
    public PayService(PayMapper payMapper) {
        this.payMapper = payMapper;
    }

    //  ============================
    //   Payment (결제) 관련 메소드
    //  ============================

    /**
     * 숙소 ID로 숙소 정보를 조회
     * 
     * @param acmId 숙소 ID
     * @return 숙소 정보
     */
    public AcmDTO getCartItems(int acmId) {
        return payMapper.getCartItems(acmId);
    }

    /**
     * 회원 코드로 회원 정보를 조회
     * 
     * @param memberCode 회원 코드
     * @return 회원 정보
     */
    public MemberDTO getMemberInfo(int memberCode) {
        return payMapper.getMemberInfo(memberCode);
    }

    /**
     * 결제 정보를 저장하고 예약 정보를 연결하여 저장
     * 트랜잭션은 아니지만 순차적으로 결제 정보 저장 후 예약 정보를 저장
     * 
     * @param paymentData 결제 및 예약 관련 데이터
     */
    public void savePaymentRecord(Map<String, Object> paymentData) {
        payMapper.savePaymentRecord(paymentData); // 결제 정보 저장
        int payId = payMapper.getLastPayId(); // 결제 ID 정보 가져오기
        paymentData.put("payId", payId); // 결제 ID 저장
        payMapper.saveReservationRecord(paymentData); // 예약 정보 저장
    }

    //  ============================
    //   PayList (결제내역) 관련 메소드
    //  ============================

    /**
     * 회원이 예약한 숙소 내역을 조회
     * 
     * @param memberCode 회원 코드
     * @return 회원의 예약/결제 내역 목록
     */
    public List<Map<String, Object>> getPayListItems(int memberCode) {
        return  payMapper.getPayListItems(memberCode);
    }
    
    /**
     * 관리자용 - 모든 회원의 결제 내역 조회
     * 
     * @return 모든 결제 내역 목록
     */
    public List<Map<String, Object>> getAllPayments() {
        return payMapper.getAllPayments();
    }

    /**
     * 로그인한 회원의 결제 내역을 날짜 범위로 조회
     * 시작 날짜와 종료 날짜 사이의 결제 내역을 조회
     * 
     * @param memberCode 회원 코드
     * @param startDate 시작 날짜 (선택)
     * @param endDate 종료 날짜 (선택)
     * @return 회원의 결제 내역 목록
     */
    public List<PayDTO> getMemberPayments(int memberCode, String startDate, String endDate) {
        return payMapper.findPaymentsByMemberId(memberCode, startDate, endDate);
    }
}

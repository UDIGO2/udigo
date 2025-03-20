package com.udigo.hotel.pay.model.service;

import com.udigo.hotel.acm.model.dto.AcmDTO;
import com.udigo.hotel.member.model.dao.MemberMapper;
import com.udigo.hotel.member.model.dto.MemberDTO;
import com.udigo.hotel.pay.model.dao.PayMapper;
import com.udigo.hotel.pay.model.dto.PayDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * 결제 관련 비즈니스 로직을 처리하는 서비스 클래스
 * 결제 정보 저장, 조회 및 검증 등의 기능을 제공
 */
@Service
public class PayService {
    private static final Logger logger = LoggerFactory.getLogger(PayService.class);

    private final PayMapper payMapper;
    private final MemberMapper memberMapper;
    /**
     * 생성자 주입 방식을 통한 PayMapper 의존성 주입
     * 
     * @param payMapper 결제 관련 데이터 접근 매퍼
     */
    @Autowired
    public PayService(PayMapper payMapper, MemberMapper memberMapper) {
        this.payMapper = payMapper;
        this.memberMapper = memberMapper;
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
        try {
            // 🔎 디버깅용 로그 추가
            logger.debug("결제 요청 데이터 확인: " + paymentData);

            // 필수 데이터 확인
            if (!paymentData.containsKey("acmId") ||
                    !paymentData.containsKey("payMethod") ||
                    !paymentData.containsKey("payStatus") ||
                    !paymentData.containsKey("payPrice") ||
                    !paymentData.containsKey("transactionId") ||
                    !paymentData.containsKey("payProvider")) {
                throw new IllegalArgumentException("필수 결제 데이터가 누락되었습니다.");
            }

            // memberCode 가져오기
            int memberCode = Optional.ofNullable((Integer) paymentData.get("memberCode"))
                    .orElseThrow(() -> new IllegalArgumentException("memberCode가 없습니다."));

            // totalPrice 가져오기 (payPrice 사용)
            int totalPrice = Optional.ofNullable((Integer) paymentData.get("totalPrice"))
                    .orElse(Optional.ofNullable((Integer) paymentData.get("payPrice")).orElse(0));

            if (totalPrice == 0) { // ✅ 이제 `null` 체크 없이 0으로 처리 가능
                throw new IllegalArgumentException("totalPrice 또는 payPrice가 유효하지 않습니다.");
            }

            // 쿠폰 사용 여부 확인
            int couponStatus = Optional.ofNullable(memberMapper.getCouponStatusByCode(memberCode))
                    .orElse(0);
            int discount = (couponStatus == 0) ? 5000 : 0; // 쿠폰 미사용 시 5,000원 할인

            // 결제 금액 계산
            paymentData.put("discount", discount);
            paymentData.put("finalPrice", totalPrice - discount);

            // 디버깅용 로그
            logger.info("결제 저장 - memberCode: {}, totalPrice: {}, discount: {}", memberCode, totalPrice, discount);

            // 결제 정보 저장
            payMapper.savePaymentRecord(paymentData);
            int payId = payMapper.getLastPayId();
            paymentData.put("payId", payId);

            // 예약 정보 저장
            payMapper.saveReservationRecord(paymentData);

            // 쿠폰 사용 여부 업데이트
            if (discount > 0) {
                memberMapper.updateCouponUsed(memberCode);
            }

            logger.info("결제 및 예약 저장 완료 - payId: {}", payId);

        } catch (Exception e) {
            logger.error("결제 저장 오류: ", e);
            throw new RuntimeException("결제 저장 중 오류 발생");
        }
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

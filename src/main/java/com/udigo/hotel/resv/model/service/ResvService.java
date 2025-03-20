package com.udigo.hotel.resv.model.service;

import com.udigo.hotel.resv.model.dto.ResvDTO;
import com.udigo.hotel.resv.model.dao.ResvMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 예약 관련 비즈니스 로직을 처리하는 서비스 클래스
 * 예약 조회, 취소 등의 기능 제공
 */
@Service
public class ResvService {

    @Autowired
    private ResvMapper resvMapper;

    /**
     * 회원의 현재 예약(체크아웃 날짜가 현재 이후인 예약) 목록을 조회
     * 
     * @param memberCode 회원 코드
     * @return 현재 예약 목록
     */
    public List<ResvDTO> getCurrentResv(int memberCode) {
        return resvMapper.selectCurrentResv(memberCode);
    }
    /**
     * 회원의 지난 예약(체크아웃 날짜가 현재 이전인 예약 또는 취소된 예약) 목록을 조회
     * 
     * @param memberCode 회원 코드
     * @return 지난 예약 목록
     */
    public List<ResvDTO> getPastResv(int memberCode) {
        return resvMapper.selectPastResv(memberCode);
    }

    /**
     * 회원의 취소 가능한 예약(체크인 날짜가 현재 이후인 예약) 목록을 조회
     * 
     * @param memberCode 회원 코드
     * @return 취소 가능한 예약 목록
     */
    public List<ResvDTO> getCancelableResv(int memberCode) {
        return resvMapper.selectCancelableResv(memberCode);
    }

    /**
     * 예약을 취소 상태로 변경
     * 트랜잭션 처리로 데이터 일관성 보장
     * 
     * @param resvId 취소할 예약 ID
     * @param memberCode 예약자 회원 코드 (보안 검증용)
     */
    @Transactional
    public void cancelReservation(int resvId, int memberCode) {
        resvMapper.updateResvCancel(resvId, memberCode);
    }

    /**
     * 결제 ID로 예약 정보 조회
     * 
     * @param payId 조회할 결제 ID
     * @return 예약 정보
     */
    public ResvDTO getReservationByPayId(int payId) {
        return resvMapper.selectResvByPayId(payId);
    }

    /**
     * 특정 숙소의 모든 예약 정보를 조회합니다.
     * 숙소 상세 페이지에서 예약 가능 날짜를 확인할 때 사용
     * 
     * @param acmId 숙소 ID
     * @return 예약 목록
     */
    public List<ResvDTO> getReservationsByAcmId(int acmId) {
        return resvMapper.selectReservationsByAcmId(acmId);
    }

    /**
     * 예약 취소 및 환불 처리를 수행
     * 트랜잭션 처리로 결제 상태 변경과 예약 취소가 함께 이루어짐
     * 
     * @param resvId 취소할 예약 ID
     * @param memberCode 예약자 회원 코드 (보안 검증용)
     * @param refundAmount 환불 금액
     * @throws RuntimeException 예약 정보가 없거나, 권한이 없거나, 체크인 이후인 경우, 결제 정보가 없는 경우
     */
    @Transactional
    public void cancelReservationWithRefund(int resvId, int memberCode, int refundAmount) {
        // 예약 정보 조회
        ResvDTO reservation = resvMapper.findById(resvId);
        if (reservation == null) {
            throw new RuntimeException("예약 정보를 찾을 수 없습니다.");
        }
        
        // 보안 검사: 현재 로그인한 사용자의 예약인지 확인
        if (reservation.getMemberCode() != memberCode) {
            throw new RuntimeException("권한이 없습니다.");
        }
        
        // 체크인 날짜 확인 (체크인 이후에는 취소 불가)
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime checkIn = reservation.getCheckIn();
        long daysUntilCheckIn = java.time.Duration.between(now, checkIn).toDays();
        
        if (daysUntilCheckIn < 0) {
            throw new RuntimeException("체크인 이후에는 예약을 취소할 수 없습니다.");
        }
        
        // 결제 ID 가져오기
        Integer payId = reservation.getPayId();
        if (payId == null) {
            throw new RuntimeException("결제 정보를 찾을 수 없습니다.");
        }
        
        // 1. 결제 테이블에서 상태를 '환불완료'로 변경하고 환불 금액 업데이트
        resvMapper.updatePaymentForRefund(payId, refundAmount);
        
        // 2. 예약 테이블에서 예약 취소 (is_resv = 0 설정)
        resvMapper.updateResvCancel(resvId, memberCode);
    }
}
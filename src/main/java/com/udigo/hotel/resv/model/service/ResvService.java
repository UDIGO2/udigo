package com.udigo.hotel.resv.model.service;

import com.udigo.hotel.resv.model.dto.ResvDTO;
import com.udigo.hotel.resv.model.dao.ResvMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ResvService {

    @Autowired
    private ResvMapper resvMapper;

    public List<ResvDTO> getCurrentResv(int memberCode) {
        return resvMapper.selectCurrentResv(memberCode);
    }

    public List<ResvDTO> getPastResv(int memberCode) {
        return resvMapper.selectPastResv(memberCode);
    }

    public List<ResvDTO> getCancelableResv(int memberCode) {
        return resvMapper.selectCancelableResv(memberCode);
    }

    @Transactional
    public void cancelReservation(int resvId, int memberCode) {
        resvMapper.updateResvCancel(resvId, memberCode);
    }

    // 결제 ID로 예약 정보 조회
    public ResvDTO getReservationByPayId(int payId) {
        return resvMapper.selectResvByPayId(payId);
    }

    /**
     * 특정 숙소의 모든 예약 정보를 조회합니다.
     * @param acmId 숙소 ID
     * @return 예약 목록
     */
    public List<ResvDTO> getReservationsByAcmId(int acmId) {
        return resvMapper.selectReservationsByAcmId(acmId);
    }

    // 모든 예약 조회
    public List<ResvDTO> getAllReservations() {
        return resvMapper.findAll();
    }

    // 회원 코드별 현재 예약 조회 (체크아웃 날짜가 현재 이후인 예약)
    public List<ResvDTO> getCurrentReservationsByMemberCode(int memberCode) {
        return resvMapper.findCurrentByMemberCode(memberCode, LocalDateTime.now());
    }

    // 회원 코드별 이전 예약 조회 (체크아웃 날짜가 현재 이전인 예약)
    public List<ResvDTO> getPastReservationsByMemberCode(int memberCode) {
        return resvMapper.findPastByMemberCode(memberCode, LocalDateTime.now());
    }

    // 회원 코드별 취소 가능한 예약 조회 (체크인 날짜가 현재 이후인 예약)
    public List<ResvDTO> getCancelableReservationsByMemberCode(int memberCode) {
        return resvMapper.findCancelableByMemberCode(memberCode, LocalDateTime.now());
    }

    // 예약 취소
    public void cancelReservation(int resvId) {
        resvMapper.cancelReservation(resvId);
    }

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
        
        // 체크인 날짜 확인 (체크인 3일 이전까지만 취소 가능)
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
        
        // 2. 예약 테이블에서 예약 취소 (is_resv = 0 또는 예약 삭제)
        resvMapper.updateResvCancel(resvId, memberCode);
    }
}
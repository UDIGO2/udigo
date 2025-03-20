package com.udigo.hotel.resv.model.dao;

import com.udigo.hotel.resv.model.dto.ResvDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 예약 정보 데이터 접근을 위한 MyBatis 매퍼 인터페이스
 * 예약 조회, 취소 등의 데이터베이스 작업을 수행
 */
@Mapper
public interface ResvMapper {

    /**
     * 회원의 현재 예약 목록을 조회 (체크아웃 날짜가 현재 이후인 예약)
     * 조인을 통해 숙소 정보, 결제 정보도 함께 가져옴
     * 
     * @param memberCode 회원 코드
     * @return 현재 예약 목록
     */
    List<ResvDTO> selectCurrentResv(int memberCode);
    
    /**
     * 회원의 이전 예약 목록을 조회 (체크아웃 날짜가 현재 이전이거나 취소된 예약)
     * 조인을 통해 숙소 정보, 결제 정보도 함께 가져옴
     * 
     * @param memberCode 회원 코드
     * @return 이전 예약 목록
     */
    List<ResvDTO> selectPastResv(int memberCode);
    
    /**
     * 회원의 취소 가능한 예약 목록을 조회 (체크인 날짜가 현재 이후인 예약)
     * 조인을 통해 숙소 정보, 결제 정보도 함께 가져옴
     * 
     * @param memberCode 회원 코드
     * @return 취소 가능한 예약 목록
     */
    List<ResvDTO> selectCancelableResv(int memberCode);
    
    /**
     * 예약을 취소 상태로 변경 (is_resv = 0)
     * 회원 코드를 통한 보안 검증 포함
     * 
     * @param resvId 예약 ID
     * @param memberCode 회원 코드
     */
    void updateResvCancel(@Param("resvId") int resvId, @Param("memberCode") int memberCode);

    /**
     * 결제 ID로 예약 정보를 조회
     * 조인을 통해 숙소 정보, 결제 정보도 함께 가져옴
     * 
     * @param payId 결제 ID
     * @return 예약 정보
     */
    ResvDTO selectResvByPayId(@Param("payId") int payId);

    /**
     * 특정 숙소의 모든 예약 정보를 조회합니다.
     * 취소되지 않은 예약(is_resv = 1)만 조회
     * 
     * @param acmId 숙소 ID
     * @return 예약 목록
     */
    List<ResvDTO> selectReservationsByAcmId(int acmId);
    
    /**
     * 예약 ID로 예약 정보를 조회합니다.
     * 조인을 통해 숙소 정보도 함께 가져옴
     * 
     * @param resvId 예약 ID
     * @return 예약 정보
     */
    ResvDTO findById(@Param("resvId") int resvId);
    
    /**
     * 결제 테이블의 상태를 '환불완료'로 변경하고 환불 금액을 저장합니다.
     * 예약 취소 프로세스의 일부로, 결제 상태를 업데이트
     * 
     * @param payId 결제 ID
     * @param refundAmount 환불 금액
     */
    void updatePaymentForRefund(@Param("payId") int payId, @Param("refundAmount") int refundAmount);

}
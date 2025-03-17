package com.udigo.hotel.resv.model.dao;

import com.udigo.hotel.resv.model.dto.ResvDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface ResvMapper {

    List<ResvDTO> findAll();

    List<ResvDTO> findCurrentByMemberCode(@Param("memberCode") int memberCode, @Param("now") LocalDateTime now);

    List<ResvDTO> findPastByMemberCode(@Param("memberCode") int memberCode, @Param("now") LocalDateTime now);

    List<ResvDTO> findCancelableByMemberCode(@Param("memberCode") int memberCode, @Param("now") LocalDateTime now);

    List<ResvDTO> selectCurrentResv(int memberCode);
    List<ResvDTO> selectPastResv(int memberCode);
    List<ResvDTO> selectCancelableResv(int memberCode);
    void updateResvCancel(@Param("resvId") int resvId, @Param("memberCode") int memberCode);

    void cancelReservation(@Param("resvId") int resvId);
    // 결제 ID로 예약 정보 조회
    ResvDTO selectResvByPayId(@Param("payId") int payId);

    /**
     * 특정 숙소의 모든 예약 정보를 조회합니다.
     * @param acmId 숙소 ID
     * @return 예약 목록
     */
    List<ResvDTO> selectReservationsByAcmId(int acmId);

}
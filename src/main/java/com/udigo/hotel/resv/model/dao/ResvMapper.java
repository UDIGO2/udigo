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

    void cancelReservation(@Param("resvId") int resvId);
}
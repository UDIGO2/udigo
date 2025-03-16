package com.udigo.hotel.acm.model.dao;

import com.udigo.hotel.acm.model.dto.AcmDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AcmMapper {

    // 초기 9개 숙소 조회
    List<AcmDTO> selectInitialAcms();

    // 추가 9개 숙소 조회 (offset 사용)
    List<AcmDTO> selectNextAcms(@Param("offset") int offset);

    // 전체 숙소 수 조회
    int getTotalAcmCount();

    // 검색 기능 (옵션)
    List<AcmDTO> searchAcms(@Param("acmLocation") String location,
                            @Param("checkInDate") String checkInDate,
                            @Param("checkOutDate") String checkOutDate,
                            @Param("maxGuests") Integer guests);

    AcmDTO selectAcmDetail(int acmId);

    List<AcmDTO> selectAcmIds(List<Integer> acmIds);
}

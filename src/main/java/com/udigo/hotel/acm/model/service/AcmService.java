package com.udigo.hotel.acm.model.service;

import com.udigo.hotel.acm.model.dao.AcmMapper;
import com.udigo.hotel.acm.model.dto.AcmDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AcmService {

    private final AcmMapper acmMapper;

    public AcmService(AcmMapper acmMapper) {
        this.acmMapper = acmMapper;
    }

    // 초기 숙소 목록 조회
    public List<AcmDTO> getInitialAcms() {
        return acmMapper.selectInitialAcms();
    }

    // 추가 숙소 목록 조회
    public List<AcmDTO> getMoreAcms(int currentCount, int pageSize) {
        return acmMapper.selectMoreAcms(currentCount, pageSize);
    }

    // 더 보여줄 숙소가 있는지 확인
    public boolean hasMoreAcms(int currentCount) {
        int totalCount = acmMapper.getTotalCount();
        return currentCount < totalCount;
    }

    // 검색 조건에 맞는 숙소 조회
    public List<AcmDTO> searchAcms(String location, String checkInDate, String checkOutDate, Integer guests) {
        // 지역명 변환
        location = switch (location) {
            case "경상북도/남도" -> "경상";
            case "전라북도/남도" -> "전라";
            case "충청북도/남도" -> "충청";
            case "강원도" -> "강원";
            default -> location;
        };

        return acmMapper.searchAcms(location, checkInDate, checkOutDate, guests);
    }

    // 숙소 상세 정보 조회
    public AcmDTO getAcmDetail(int acmId) {
        return acmMapper.selectAcmDetail(acmId);
    }

    // 장바구니에 있는 숙소 정보 조회
    public List<AcmDTO> getAcmsFromCart(List<Integer> acmIds) {
        return acmMapper.selectAcmIds(acmIds);
    }

    // 전체 숙소 수 조회
    public int getTotalAcmCount() {
        return acmMapper.getTotalCount();
    }
}
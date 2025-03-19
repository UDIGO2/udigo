package com.udigo.hotel.acm.model.service;

import com.udigo.hotel.acm.model.dao.AcmMapper;
import com.udigo.hotel.acm.model.dto.AcmDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AcmService {

    private static final Logger logger = LoggerFactory.getLogger(AcmService.class);
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

    // 관리자용 숙소 삭제
    @Transactional
    public void deleteAcm(int acmId) {
        acmMapper.deleteAcm(acmId);
    }

    // 관리자용 숙소 추가
    @Transactional
    public void addAcm(AcmDTO acmDTO) {
        logger.info("숙소 추가 시작: {}", acmDTO);
        try {
            acmMapper.insertAcm(acmDTO);
            logger.info("숙소 추가 성공: {}", acmDTO);
        } catch (Exception e) {
            logger.error("숙소 추가 실패: {}", e.getMessage(), e);
            throw e;
        }
    }

    public void updateAcm(AcmDTO acm) {
        // 데이터베이스에 수정된 데이터 저장
        acmMapper.updateAcm(acm); // AcmMapper에 updateAcm 메소드가 구현되어 있어야 합니다.
    }

    // 모든 숙소 정보 조회
    public List<AcmDTO> getAllAcms() {
        return acmMapper.selectAllAcms();
    }
}
package com.udigo.hotel.admin.service;

import com.udigo.hotel.acm.model.dto.AcmDTO;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class adminAcmService {

    // 임시 저장소 (실제로는 DB를 사용하지만, 여기서는 테스트를 위해 List 사용)
    private final List<AcmDTO> acmList = new ArrayList<>();
    private int nextId = 1;

    // 모든 숙소 목록 조회
    public List<AcmDTO> getAllAcms() {
        return new ArrayList<>(acmList);
    }

    // 페이지네이션을 위한 숙소 목록 조회
    public Map<String, Object> getAcmsWithPagination(int currentCount, int pageSize) {
        Map<String, Object> result = new HashMap<>();

        if (currentCount >= acmList.size()) {
            result.put("acms", new ArrayList<>());
            result.put("hasMore", false);
            return result;
        }

        int endIndex = Math.min(currentCount + pageSize, acmList.size());
        result.put("acms", acmList.subList(currentCount, endIndex));
        result.put("hasMore", endIndex < acmList.size());

        return result;
    }

    // ID로 숙소 조회
    public AcmDTO getAcmById(int acmId) {
        return acmList.stream()
                .filter(acm -> acm.getAcmId() == acmId)
                .findFirst()
                .orElse(null);
    }

    // 숙소 저장
    public AcmDTO saveAcm(AcmDTO acmDTO) {
        if (acmDTO.getAcmId() == 0) {
            // 새 숙소 추가
            acmDTO.setAcmId(nextId++);
            acmList.add(acmDTO);
        } else {
            // 기존 숙소 업데이트
            for (int i = 0; i < acmList.size(); i++) {
                if (Objects.equals(acmList.get(i).getAcmId(), acmDTO.getAcmId())) {  // Objects.equals() 사용
                    acmList.set(i, acmDTO);
                    break;
                }
            }
        }
        return acmDTO;
    }

    // 숙소 삭제
    public boolean deleteAcm(int acmId) {
        return acmList.removeIf(acm -> acm.getAcmId() == acmId);
    }
}
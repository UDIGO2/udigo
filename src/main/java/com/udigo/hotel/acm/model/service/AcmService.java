package com.udigo.hotel.acm.model.service;

import com.udigo.hotel.acm.model.dao.AcmMapper;
import com.udigo.hotel.acm.model.dto.AcmDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcmService {

    @Autowired
    private AcmMapper acmMapper;

    public List<AcmDTO> getInitialAcms() {
        return acmMapper.selectInitialAcms();
    }

    public List<AcmDTO> getNextAcms(int currentCount) {
        return acmMapper.selectNextAcms(currentCount);
    }

    public boolean hasMoreAcms(int currentCount) {
        int totalCount = acmMapper.getTotalAcmCount();
        return currentCount < totalCount;
        }
}


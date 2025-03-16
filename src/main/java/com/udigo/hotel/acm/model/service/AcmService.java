package com.udigo.hotel.acm.model.service;

import com.udigo.hotel.acm.model.dao.AcmMapper;
import com.udigo.hotel.acm.model.dto.AcmDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public List<AcmDTO> searchAcms(String location, String checkInDate, String checkOutDate, Integer guests) {
        return acmMapper.searchAcms(location, checkInDate, checkOutDate, guests);
    }

    public AcmDTO getAcmDetail(int acmId) {
        return acmMapper.selectAcmDetail(acmId);
    }

    public List<AcmDTO> getAcmsFromCart(List<Integer> acmIds) {
      return acmMapper.selectAcmIds(acmIds);
    }
}


      /*  System.out.println("장소2--->"+location);
        System.out.println("날짜2--->"+date);
        System.out.println("인원수2--->"+guests);
        System.out.println("결과2--->"+acmMapper.searchAcms(location, date, guests));*/




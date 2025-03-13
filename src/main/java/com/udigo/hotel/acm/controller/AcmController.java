package com.udigo.hotel.acm.controller;

import com.udigo.hotel.acm.model.dto.AcmDTO;
import com.udigo.hotel.acm.model.service.AcmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/acm")
public class AcmController {

    private final AcmService acmService;

    @Autowired
    public AcmController(AcmService acmService) {
        this.acmService = acmService;
    }

    // 초기 숙소 목록 페이지 로드
    @GetMapping("/acm/list")
    public String listAcms(Model model) {
        List<AcmDTO> acms = acmService.getInitialAcms();
        model.addAttribute("acms", acms);
        return "acm/list";
    }

    // View More API - 추가 숙소 데이터 로드
    @GetMapping("/api/more")
    @ResponseBody
    public Map<String, Object> getMoreAcms(@RequestParam(defaultValue = "9") int currentCount) {
        Map<String, Object> response = new HashMap<>();

        try {
            List<AcmDTO> acms = acmService.getNextAcms(currentCount);
            boolean hasMore = acmService.hasMoreAcms(currentCount + acms.size());

            response.put("acms", acms);
            response.put("hasMore", hasMore);
            response.put("success", true);
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "데이터 로드 중 오류가 발생했습니다.");
        }

        return response;
    }

//    // 숙소 검색 기능 (옵션)
//    @GetMapping("/search")
//    @ResponseBody
//    public Map<String, Object> searchAcms(
//            @RequestParam String keyword,
//            @RequestParam(required = false) String checkIn,
//            @RequestParam(required = false) String checkOut,
//            @RequestParam(required = false) Integer guests) {
//
//        Map<String, Object> response = new HashMap<>();
//
//        try {
//            // 검색 로직 구현 필요
//            response.put("success", true);
//            // response.put("acms", searchResults);
//        } catch (Exception e) {
//            response.put("success", false);
//            response.put("message", "검색 중 오류가 발생했습니다.");
//        }
//
//        return response;
//    }
}
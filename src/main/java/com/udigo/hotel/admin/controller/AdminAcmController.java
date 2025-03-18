package com.udigo.hotel.admin.controller;

import com.udigo.hotel.acm.model.dto.AcmDTO;
import com.udigo.hotel.acm.model.service.AcmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.UUID;

@Controller
@RequestMapping("/admin/acm")
public class AdminAcmController {

    private static final Logger logger = LoggerFactory.getLogger(AdminAcmController.class);
    private final AcmService acmService;
    private final String UPLOAD_DIR = "src/main/resources/static/image/acm/";

    public AdminAcmController(AcmService acmService) {
        this.acmService = acmService;
    }

    @GetMapping("/list")
    public String listAccommodations(Model model) {
        List<AcmDTO> acms = acmService.getInitialAcms();
        model.addAttribute("acms", acms);
        return "admin/adminAcmList";
    }

    @GetMapping("/more")
    @ResponseBody
    public Map<String, Object> getMoreAccommodations(@RequestParam int currentCount) {
        List<AcmDTO> acms = acmService.getMoreAcms(currentCount, 9);
        Map<String, Object> response = new HashMap<>();
        response.put("acms", acms);
        response.put("hasMore", acms.size() == 9);
        response.put("success", true);
        return response;
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public Map<String, Object> deleteAccommodation(@PathVariable int id) {
        Map<String, Object> response = new HashMap<>();
        try {
            acmService.deleteAcm(id);
            response.put("success", true);
        } catch (Exception e) {
            response.put("success", false);
        }
        return response;
    }
    
    @GetMapping("/add")
    public String showAddAcmForm(Model model) {
        model.addAttribute("acmDTO", new AcmDTO());
        return "admin/addAcm";
    }
    
    @PostMapping("/add")
    public String addAccommodation(
            @ModelAttribute AcmDTO acmDTO,
            @RequestParam("photo1") MultipartFile photo1,
            @RequestParam("photo2") MultipartFile photo2,
            @RequestParam("photo3") MultipartFile photo3,
            @RequestParam(value = "photo4", required = false) MultipartFile photo4,
            @RequestParam(value = "photo5", required = false) MultipartFile photo5) {
        
        logger.info("숙소 등록 요청: {}", acmDTO);
        
        try {
            // 각 지역에 맞는 디렉토리 찾기
            String locationDir = getLocationDir(acmDTO.getAcmLocation());
            logger.info("지역 디렉토리: {}", locationDir);
            
            // 파일 저장 및 경로 설정
            acmDTO.setAcmPhoto1(saveFile(photo1, locationDir));
            acmDTO.setAcmPhoto2(saveFile(photo2, locationDir));
            acmDTO.setAcmPhoto3(saveFile(photo3, locationDir));
            
            if (photo4 != null && !photo4.isEmpty()) {
                acmDTO.setAcmPhoto4(saveFile(photo4, locationDir));
            }
            
            if (photo5 != null && !photo5.isEmpty()) {
                acmDTO.setAcmPhoto5(saveFile(photo5, locationDir));
            }
            
            // 현재 날짜 설정
            acmDTO.setAcmDate(LocalDateTime.now());
            // 좋아요 수 초기화
            acmDTO.setLikedCount(0);
            
            logger.info("DB 저장 전 숙소 정보: {}", acmDTO);
            
            // 숙소 저장
            acmService.addAcm(acmDTO);
            
            logger.info("숙소 등록 성공: {}", acmDTO);
            
            return "redirect:/admin/acm/list";
        } catch (Exception e) {
            logger.error("숙소 등록 실패: {}", e.getMessage(), e);
            return "redirect:/admin/acm/add?error=true";
        }
    }
    
    private String getLocationDir(String location) {
        return switch (location) {
            case "서울/경기" -> "seoul";
            case "충청" -> "chuncheong";
            case "강원" -> "gangwon";
            case "제주" -> "jeju";
            case "전라" -> "jeonla";
            case "경상" -> "gueongsang";
            default -> "seoul";
        };
    }
    
    private String saveFile(MultipartFile file, String locationDir) throws IOException {
        if (file.isEmpty()) {
            return null;
        }
        
        // 파일명 생성 (중복 방지를 위한 UUID 사용)
        String originalFilename = file.getOriginalFilename();
        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        String savedFilename = UUID.randomUUID().toString() + extension;
        
        logger.info("파일 저장 시작: 원본파일명={}, 저장파일명={}, 위치={}", originalFilename, savedFilename, locationDir);
        
        // 저장 디렉토리 경로 생성
        File saveDir = new File(UPLOAD_DIR + locationDir);
        if (!saveDir.exists()) {
            boolean created = saveDir.mkdirs();
            logger.info("디렉토리 생성 결과: {}, 경로={}", created, saveDir.getAbsolutePath());
        }
        
        // 파일 저장
        File saveFile = new File(saveDir, savedFilename);
        try {
            file.transferTo(saveFile);
            logger.info("파일 저장 성공: {}", saveFile.getAbsolutePath());
        } catch (IOException e) {
            logger.error("파일 저장 실패: {}", e.getMessage(), e);
            throw e;
        }
        
        // 이미지 경로 반환 (DB에 저장할 상대 경로)
        String imagePath = "/image/acm/" + locationDir + "/" + savedFilename;
        logger.info("이미지 경로: {}", imagePath);
        return imagePath;
    }
}
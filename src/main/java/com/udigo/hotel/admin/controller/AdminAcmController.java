package com.udigo.hotel.admin.controller;

import com.udigo.hotel.acm.model.dto.AcmDTO;
import com.udigo.hotel.acm.model.service.AcmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/acm")
public class AdminAcmController {

    private final AcmService acmService;

    @Autowired
    public AdminAcmController(AcmService acmService) {
        this.acmService = acmService;
    }

    // 관리자용 숙소 목록 페이지
    @GetMapping("/list")
    public String listAcms(Model model) {
        List<AcmDTO> acms = acmService.getAllAcms();
        model.addAttribute("acms", acms);
        return "admin/adminAcmList";
    }

    // 더 많은 숙소 데이터 로드 (AJAX)
    @GetMapping("/api/more")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getMoreAcms(@RequestParam int currentCount) {
        Map<String, Object> response = new HashMap<>();

        try {
            int pageSize = 9;
            List<AcmDTO> moreAcms = acmService.getMoreAcms(currentCount, pageSize);
            int totalCount = acmService.getTotalAcmCount();

            response.put("success", true);
            response.put("acms", moreAcms);
            response.put("hasMore", currentCount + moreAcms.size() < totalCount);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "Failed to load more accommodations");
            return ResponseEntity.badRequest().body(response);
        }
    }

    // 숙소 삭제 처리
    @DeleteMapping("/delete/{acmId}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> deleteAcm(@PathVariable int acmId) {
        Map<String, Object> response = new HashMap<>();

        try {
            acmService.deleteAcm(acmId);
            response.put("success", true);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "해당 숙소는 이미 예약된 데이터가 있는 숙소입니다. 연관 데이터 삭제 후 다시 시도하세요.");
            return ResponseEntity.badRequest().body(response);
        }
    }

    // 숙소 상세 정보 페이지
    @GetMapping("/detail/{acmId}")
    public String acmDetail(@PathVariable int acmId, Model model) {
        // getAcmById(acmId) 대신 getAcmDetail(acmId) 사용
        AcmDTO acm = acmService.getAcmDetail(acmId);
        model.addAttribute("acm", acm);
        return "admin/acm/acmDetail";
    }

    // 숙소 등록 페이지 표시
    @GetMapping("/register")
    public String showAddAcmForm(Model model) {
        model.addAttribute("acm", new AcmDTO());
        return "admin/addAcm";
    }

    // 숙소 등록 처리
    @PostMapping("/add")
    public String addAcm(@ModelAttribute AcmDTO acm,
                         @RequestParam("photo1") MultipartFile photo1,
                         @RequestParam("photo2") MultipartFile photo2,
                         @RequestParam("photo3") MultipartFile photo3,
                         @RequestParam(value = "photo4", required = false) MultipartFile photo4,
                         @RequestParam(value = "photo5", required = false) MultipartFile photo5) throws IOException {

        try {
            // 현재 시간 설정
            acm.setAcmDate(LocalDateTime.now());

            // 파일 저장 및 경로 설정
            if (!photo1.isEmpty()) {
                String fileName = "acm_" + System.currentTimeMillis() + "_1";
                acm.setAcmPhoto1("/image/new/" + com.udigo.hotel.admin.fileupload.AcmFileUploadController.saveFile("image/new", fileName, photo1));
            }

            if (!photo2.isEmpty()) {
                String fileName = "acm_" + System.currentTimeMillis() + "_2";
                acm.setAcmPhoto2("/image/new/" + com.udigo.hotel.admin.fileupload.AcmFileUploadController.saveFile("image/new", fileName, photo2));
            }

            if (!photo3.isEmpty()) {
                String fileName = "acm_" + System.currentTimeMillis() + "_3";
                acm.setAcmPhoto3("/image/new/" + com.udigo.hotel.admin.fileupload.AcmFileUploadController.saveFile("image/new", fileName, photo3));
            }

            if (photo4 != null && !photo4.isEmpty()) {
                String fileName = "acm_" + System.currentTimeMillis() + "_4";
                acm.setAcmPhoto4("/image/new/" + com.udigo.hotel.admin.fileupload.AcmFileUploadController.saveFile("image/new", fileName, photo4));
            }

            if (photo5 != null && !photo5.isEmpty()) {
                String fileName = "acm_" + System.currentTimeMillis() + "_5";
                acm.setAcmPhoto5("/image/new/" + com.udigo.hotel.admin.fileupload.AcmFileUploadController.saveFile("image/new", fileName, photo5));
            }

            acmService.addAcm(acm);
            return "redirect:/admin/acm/list";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/admin/acm/add?error=true";
        }
    }

    // 숙소 수정 페이지 표시
    @GetMapping("/edit/{acmId}")
    public String showEditAcmForm(@PathVariable int acmId, Model model) {
        AcmDTO acm = acmService.getAcmDetail(acmId); // 기존 메소드 사용
        model.addAttribute("acm", acm);
        return "admin/editAcm";
    }

    // 숙소 수정 처리
    @PostMapping("/edit/{acmId}")
    public String editAcm(@PathVariable int acmId,
                          @ModelAttribute AcmDTO acm,
                          @RequestParam("photo1") MultipartFile photo1,
                          @RequestParam("photo2") MultipartFile photo2,
                          @RequestParam("photo3") MultipartFile photo3,
                          @RequestParam(value = "photo4", required = false) MultipartFile photo4,
                          @RequestParam(value = "photo5", required = false) MultipartFile photo5) throws IOException {

        try {
            // 기존 숙소 정보 가져오기
            AcmDTO existingAcm = acmService.getAcmDetail(acmId); // 기존 메소드 사용

            // 파일 저장 및 경로 설정
            if (!photo1.isEmpty()) {
                String fileName = "acm_" + System.currentTimeMillis() + "_1";
                existingAcm.setAcmPhoto1("/image/new/" + com.udigo.hotel.admin.fileupload.AcmFileUploadController.saveFile("image/new", fileName, photo1));
            }

            if (!photo2.isEmpty()) {
                String fileName = "acm_" + System.currentTimeMillis() + "_2";
                existingAcm.setAcmPhoto2("/image/new/" + com.udigo.hotel.admin.fileupload.AcmFileUploadController.saveFile("image/new", fileName, photo2));
            }

            if (!photo3.isEmpty()) {
                String fileName = "acm_" + System.currentTimeMillis() + "_3";
                existingAcm.setAcmPhoto3("/image/new/" + com.udigo.hotel.admin.fileupload.AcmFileUploadController.saveFile("image/new", fileName, photo3));
            }

            if (photo4 != null && !photo4.isEmpty()) {
                String fileName = "acm_" + System.currentTimeMillis() + "_4";
                existingAcm.setAcmPhoto4("/image/new/" + com.udigo.hotel.admin.fileupload.AcmFileUploadController.saveFile("image/new", fileName, photo4));
            }

            if (photo5 != null && !photo5.isEmpty()) {
                String fileName = "acm_" + System.currentTimeMillis() + "_5";
                existingAcm.setAcmPhoto5("/image/new/" + com.udigo.hotel.admin.fileupload.AcmFileUploadController.saveFile("image/new", fileName, photo5));
            }

            // 수정된 정보 설정
            existingAcm.setAcmName(acm.getAcmName());
            existingAcm.setAcmLocation(acm.getAcmLocation());
            existingAcm.setAcmAddress(acm.getAcmAddress());
            existingAcm.setAcmPrice(acm.getAcmPrice());
            existingAcm.setMaxGuest(acm.getMaxGuest());
            existingAcm.setAcmPhone(acm.getAcmPhone());
            existingAcm.setAcmInfo(acm.getAcmInfo());
            
            // 현재 시간으로 acmDate 설정
            existingAcm.setAcmDate(LocalDateTime.now());

            // 데이터베이스에 저장
            acmService.updateAcm(existingAcm);
            return "redirect:/admin/acm/list";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/admin/acm/edit/" + acmId + "?error=true";
        }
    }

}
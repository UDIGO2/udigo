package com.udigo.hotel.admin.controller;

import com.udigo.hotel.acm.model.dto.AcmDTO;
import com.udigo.hotel.acm.model.service.AcmService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Controller
@RequestMapping("/admin/acm")
public class AdminAcmController {

    private final AcmService acmService;

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
}
package com.udigo.hotel.admin.controller;

import com.udigo.hotel.pay.model.service.PayService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminPayController {

    private final PayService payService;

    public AdminPayController(PayService payService) {
        this.payService = payService;
    }

    @GetMapping("/paylistall")
    public String getAllPayments(Model model) {
        List<Map<String, Object>> allPayments = payService.getAllPayments();
        model.addAttribute("payments", allPayments);
        return "pay/admin/paylistall";
    }
} 
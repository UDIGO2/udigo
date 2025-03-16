package com.udigo.hotel.auth.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/auth")
public class AuthController {

    /** ✅ 로그인 페이지 이동 */
    @GetMapping("/login")
    public String loginPage(@RequestParam(value = "error", required = false) String error,
                            HttpServletRequest request,
                            Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        // 🔹 로그인 상태 체크 (이미 로그인된 경우)
        if (auth != null && auth.isAuthenticated() && auth.getPrincipal() instanceof User) {
            model.addAttribute("successMessage", "이미 로그인되어 있습니다.");
            return "main/main"; // ✅ Flash Attribute 대신 Model을 사용하여 로그인 성공 메시지 전달
        }

        // 🔹 로그인 실패 시 에러 메시지 전달
        if (error != null) {
            model.addAttribute("errorMessage", "아이디 또는 비밀번호가 잘못되었습니다.");
        }


        // 🔹 로그인 전 페이지 저장 (Referer 활용)
        String referer = request.getHeader("Referer");
        if (referer != null && !referer.contains("/auth/login")) {
            request.getSession().setAttribute("prevPage", referer);
        }

        return "auth/login";
    }

    /** ✅ 로그인 성공 후 메인 페이지 이동 */
    @GetMapping("/")
    public String mainPage(HttpServletRequest request, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        // 🔹 로그인 상태 확인 후 처리
        if (auth != null && auth.isAuthenticated() && auth.getPrincipal() instanceof User) {
            model.addAttribute("memberId", auth.getName());
            model.addAttribute("successMessage", "로그인에 성공했습니다!"); // ✅ Flash Attribute 대신 Model 사용

            // 🔹 로그인 전 페이지로 이동
            String prevPage = (String) request.getSession().getAttribute("prevPage");
            if (prevPage != null) {
                request.getSession().removeAttribute("prevPage");
                return "redirect:" + prevPage;
            }

            return "main/main"; // ✅ Flash Attribute를 없애고 Model을 직접 사용
        }
        return "redirect:/auth/login";
    }


}

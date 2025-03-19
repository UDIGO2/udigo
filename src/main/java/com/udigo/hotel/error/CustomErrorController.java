package com.udigo.hotel.error;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        // 에러 상태 코드 가져오기
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        
        // 에러 메시지 초기화
        String errorMessage = "알 수 없는 오류가 발생했습니다.";
        
        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());
            
            // 상태 코드에 따른 에러 메시지 설정
            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                errorMessage = "요청하신 페이지를 찾을 수 없습니다.";
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                errorMessage = "서버 내부 오류가 발생했습니다.";
            } else if (statusCode == HttpStatus.FORBIDDEN.value()) {
                errorMessage = "접근 권한이 없습니다.";
            }
            
            // 에러 코드 모델에 추가
            model.addAttribute("statusCode", statusCode);
        }
        
        // 에러 메시지 모델에 추가
        model.addAttribute("errorMessage", errorMessage);
        
        // 커스텀 에러 페이지 반환
        return "error/errorpage";
    }
} 
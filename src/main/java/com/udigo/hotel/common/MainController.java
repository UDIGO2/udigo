package com.udigo.hotel.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String mainPage() {
        return "main/main";  // templates/main/main.html을 반환
    }

    /*@GetMapping("/mypage")  // 마이페이지 요청
    public String myPage() {
        return "member/mypage";  // templates/mypage.html 반환
    }*/
}

//
//package com.ohgiraffers.udigo.common.main.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class MainController {
//
//    @GetMapping("/")
//    public String Main() {
//        return "main"; // main.html 또는 main.jsp가 있어야 함
//    }
//
////    @GetMapping("/mypage")  // 마이페이지 요청
////    public String myPage() {
////        return "member/mypage";  // templates/mypage.html 반환
////    }
//
//}

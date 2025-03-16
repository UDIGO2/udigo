package com.udigo.hotel.review.controller;

import com.udigo.hotel.member.security.CustomUserDetails;
import com.udigo.hotel.review.dto.ReviewDTO;
import com.udigo.hotel.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // 초기 숙소 목록 페이지 로드
    @GetMapping("/myReview")
    public String listReview(Model model) {
        // 현재 로그인한 사용자 정보 가져오기
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getPrincipal() instanceof CustomUserDetails userDetails) {
            int memberCode = userDetails.getMemberCode();

            // 해당 회원의 리뷰 목록 조회
            List<ReviewDTO> reviews = reviewService.getReviewsByMember(memberCode);
            model.addAttribute("reviews", reviews);
            return "review/myReview";
        }
        return "redirect:/auth/login";
    }

    // 초기 숙소 목록 페이지 로드
    @GetMapping("/writeReview")
    public String writeReview(Model model) {

        int resvId = 1; //데이터 임시
        int acmId = 202; //데이터 임시
        System.out.println("11111111111");
        // 해당 회원의 리뷰 목록 조회
        ReviewDTO review = reviewService.findReviewsByWrite(resvId, acmId);
        System.out.println("review--->"+review);
        model.addAttribute("review", review);
        return "review/writeReview";

    }



/*    @GetMapping("/myinfo/update")
    public String updateMyInfo(Model model) {
        // 현재 로그인한 사용자 정보 가져오기
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getPrincipal() instanceof CustomUserDetails) {
            CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();
            int memberCode = userDetails.getMemberCode();

            // 해당 회원의 리뷰 목록 조회
            List<ReviewDTO> reviews = reviewService.getReviewsByMember(memberCode);
            model.addAttribute("reviews", reviews);

            return "review/myReview";
        }

        return "redirect:/auth/login";
    }*/

    @PostMapping("/delete")
    public String deleteReview(@RequestParam int reviewId) {
        // 현재 로그인한 사용자 정보 가져오기
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getPrincipal() instanceof CustomUserDetails userDetails) {
            int memberCode = userDetails.getMemberCode();

            System.out.println("reviewParam-->" + reviewId);
            System.out.println("reviewParam-->" + memberCode);
            reviewService.deleteReview(reviewId, memberCode);
        }
        return "redirect:/review/myReview";
    }



}
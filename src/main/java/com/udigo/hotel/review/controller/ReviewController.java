package com.udigo.hotel.review.controller;

import com.udigo.hotel.member.security.CustomUserDetails;
import com.udigo.hotel.review.dto.ReviewDTO;
import com.udigo.hotel.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    /* ====== myPage ====== */

    @GetMapping("/myReview")
    public String listReview(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getPrincipal() instanceof CustomUserDetails userDetails) {
            int memberCode = userDetails.getMemberCode();
            List<ReviewDTO> reviews = reviewService.getReviewsByMember(memberCode);
            model.addAttribute("reviews", reviews);
            return "review/myReview";
        }
        return "redirect:/auth/login";
    }

    @GetMapping("/writeReview")
    public String writeReview(@RequestParam(required = false) Integer resvId,
                              @RequestParam(required = false) Integer acmId,
                              Model model) {
        if (resvId == null) resvId = 1;  // 임시 데이터
        if (acmId == null) acmId = 202;  // 임시 데이터

        ReviewDTO review = reviewService.findReviewsByWrite(resvId, acmId);
        model.addAttribute("review", review);
        return "review/writeReview";
    }

    @PostMapping("/write")
    public String submitReview(@ModelAttribute ReviewDTO reviewDTO,
                               @RequestParam("photos") List<MultipartFile> photos) throws IOException {
        // 리뷰 내용만 검증
        if (reviewDTO.getContent() == null || reviewDTO.getContent().trim().isEmpty()) {
            return "redirect:/review/writeReview?resvId=" + reviewDTO.getResvId()
                    + "&acmId=" + reviewDTO.getAcmId()
                    + "&error=content";
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getPrincipal() instanceof CustomUserDetails userDetails) {
            reviewDTO.setMemberCode(userDetails.getMemberCode());
            reviewService.saveReview(reviewDTO, photos);
        }
        return "redirect:/review/myReview";
    }

    @PostMapping("/delete")
    public String deleteReview(@RequestParam int reviewId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getPrincipal() instanceof CustomUserDetails userDetails) {
            int memberCode = userDetails.getMemberCode();
            reviewService.deleteReview(reviewId, memberCode);
        }
        return "redirect:/review/myReview";
    }

    /* ====== adminPage ====== */

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/list")
    public String adminReviewList(@RequestParam(defaultValue = "1") int page, Model model) {
        Map<String, Object> reviewData = reviewService.getAllReviews(page);
        model.addAttribute("reviews", reviewData.get("reviews"));
        model.addAttribute("currentPage", reviewData.get("currentPage"));
        model.addAttribute("totalPages", reviewData.get("totalPages"));
        model.addAttribute("totalReviews", reviewData.get("totalReviews"));
        return "review/adminReviewList";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/admin/delete")
    public String adminDeleteReview(@RequestParam int reviewId) {
        reviewService.deleteReviewByAdmin(reviewId);
        return "redirect:/review/admin/list";
    }

    @ExceptionHandler({IOException.class, RuntimeException.class})
    public String handleException(Exception e) {
        // 로그 기록 추가
        return "redirect:/error";
    }
}
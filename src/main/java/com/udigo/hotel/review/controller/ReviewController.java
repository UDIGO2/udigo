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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String writeReview(@RequestParam Integer resvId,
                            @RequestParam Integer acmId,
                            Model model) {
        System.out.println("resvId--->"+resvId);
        System.out.println("acmId--->"+acmId);
        ReviewDTO review = reviewService.findReviewsByWrite(resvId, acmId);
        if (review == null) {
            return "redirect:/error";  // 적절한 에러 페이지로 리다이렉트
        }
        model.addAttribute("review", review);
        return "review/writeReview";
    }

    @PostMapping("/write")
    public String submitReview(@ModelAttribute ReviewDTO reviewDTO,
                               @RequestParam("photos") List<MultipartFile> photos,
                               RedirectAttributes rttr) throws IOException {
        //System.out.println("up1");
        // 리뷰 내용만 검증
        if (reviewDTO.getContent() == null || reviewDTO.getContent().trim().isEmpty()) {
            return "redirect:/review/writeReview?resvId=" + reviewDTO.getResvId()
                    + "&acmId=" + reviewDTO.getAcmId()
                    + "&error=content";
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getPrincipal() instanceof CustomUserDetails userDetails) {
            reviewDTO.setMemberCode(userDetails.getMemberCode());
            System.out.println("photos--->"+photos);
            System.out.println("reviewDTO--->"+reviewDTO);
            reviewService.saveReview(reviewDTO, photos);
            System.out.println("----saveReview----");
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

    @GetMapping("/admin/review/list")
    public String adminReviewList(@RequestParam(defaultValue = "1") int page, Model model) {
        Map<String, Object> reviewData = reviewService.getAllReviews(page);
        model.addAttribute("reviews", reviewData.get("reviews"));
        model.addAttribute("currentPage", reviewData.get("currentPage"));
        model.addAttribute("totalPages", reviewData.get("totalPages"));
        model.addAttribute("totalReviews", reviewData.get("totalReviews"));
        return "review/adminReviewList";
    }

    @PostMapping("/admin/delete")
    public String adminDeleteReview(@RequestParam int reviewId) {
        reviewService.deleteReviewByAdmin(reviewId);
        return "redirect:/review/admin/review/list";
    }

    @ExceptionHandler({IOException.class, RuntimeException.class})
    public String handleException(Exception e) {
        // 로그 기록 추가
        return "redirect:/error";
    }

    // 숙소별 리뷰 조회 API
    @GetMapping("/api/acm/{acmId}")
    @ResponseBody
    public List<ReviewDTO> getReviewsByAcm(@PathVariable int acmId) {
        return reviewService.getReviewsByAcmId(acmId);
    }
}
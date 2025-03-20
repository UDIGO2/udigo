package com.udigo.hotel.review.controller;

import com.udigo.hotel.review.dto.ReviewDTO;
import com.udigo.hotel.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewApiController {

    @Autowired
    private ReviewService reviewService;

    // 숙소별 후기 조회 API
    @GetMapping("/acm/{acmId}")
    public ResponseEntity<List<ReviewDTO>> getReviewsByAcmId(@PathVariable("acmId") int acmId) {
        try {
            List<ReviewDTO> reviews = reviewService.getReviewsByAcmId(acmId);
            return ResponseEntity.ok(reviews);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
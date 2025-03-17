package com.udigo.hotel.review.service;

import com.udigo.hotel.review.dao.ReviewMapper;
import com.udigo.hotel.review.dto.ReviewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

@Service
public class ReviewService {

    @Autowired
    private ReviewMapper reviewMapper;

    public List<ReviewDTO> getReviewsByMember(int memberCode) {
        return reviewMapper.findReviewsByMember(memberCode);
    }

    public ReviewDTO findReviewsByWrite(int resvId, int acmId) {
        return reviewMapper.findReviewsByWrite(resvId, acmId);
    }

    public void deleteReview(int reviewId, int memberCode) {
        reviewMapper.deleteReview(reviewId, memberCode);
    }

    public void saveReview(ReviewDTO reviewDTO, List<MultipartFile> photos) {
        reviewMapper.insertReview(reviewDTO);
    }

    // 관리자용 메소드 추가
    public Map<String, Object> getAllReviews(int page) {
        int limit = 10; // 한 페이지당 보여줄 리뷰 수
        int offset = (page - 1) * limit;

        List<ReviewDTO> reviews = reviewMapper.findAllReviews(offset, limit);
        int totalReviews = reviewMapper.getTotalReviewCount();
        int totalPages = (int) Math.ceil((double) totalReviews / limit);

        Map<String, Object> result = new HashMap<>();
        result.put("reviews", reviews);
        result.put("currentPage", page);
        result.put("totalPages", totalPages);
        result.put("totalReviews", totalReviews);

        return result;
    }

    public void deleteReviewByAdmin(int reviewId) {
        reviewMapper.deleteReviewByAdmin(reviewId);
    }
}


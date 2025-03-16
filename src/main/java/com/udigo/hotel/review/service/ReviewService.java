package com.udigo.hotel.review.service;

import com.udigo.hotel.review.dao.ReviewMapper;
import com.udigo.hotel.review.dto.ReviewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}

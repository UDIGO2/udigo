package com.udigo.hotel.review.dao;

import com.udigo.hotel.review.dto.ReviewDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface ReviewMapper {
    List<ReviewDTO> findReviewsByMember(@Param("memberCode") int memberCode);
    ReviewDTO findReviewsByWrite(@Param("resvId") int resvId, @Param("acmId") int acmId);
    ReviewDTO findReviewById(@Param("reviewId") int reviewId);
    void insertReview(ReviewDTO reviewDTO);
    void deleteReview(@Param("reviewId") int reviewId, @Param("memberCode") int memberCode);

     // 관리자용 메소드 추가
     List<ReviewDTO> findAllReviews(@Param("offset") int offset, @Param("limit") int limit);
     int getTotalReviewCount();
     void deleteReviewByAdmin(@Param("reviewId") int reviewId);

    }


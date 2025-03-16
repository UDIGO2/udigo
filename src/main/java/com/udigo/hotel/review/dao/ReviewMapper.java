package com.udigo.hotel.review.dao;

import com.udigo.hotel.review.dto.ReviewDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface ReviewMapper {
    List<ReviewDTO> findReviewsByMember(@Param("memberCode") int memberCode);
    ReviewDTO findReviewsByWrite(@Param("resvId") int resvId, @Param("acmId") int acmId);

    void deleteReview(int reviewId, int memberCode);
}

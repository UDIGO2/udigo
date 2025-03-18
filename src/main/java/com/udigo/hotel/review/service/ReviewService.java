package com.udigo.hotel.review.service;

import com.udigo.hotel.review.dao.ReviewMapper;
import com.udigo.hotel.review.dto.ReviewDTO;
import com.udigo.hotel.review.fileupload.FileUploadController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class ReviewService {
    @Value("${image.image-dir}")
    private String IMAGE_DIR;

    @Value("${image.image-url}")
    private String IMAGE_URL;

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

    public void saveReview(ReviewDTO reviewDTO, List<MultipartFile> photos) throws IOException {
        System.out.println("photos--->"+photos);
        // 이미지 저장
        if (!photos.isEmpty()) {
            int i = 1;
            for (MultipartFile photo : photos) {  // 'for' 문을 올바르게 수정
                System.out.println("photo--->"+photo);
                if (!photo.isEmpty()) {  // 파일이 비어 있지 않은지 확인
                    // 이미지 파일의 이름을 고유하게 생성
                    String imageName = UUID.randomUUID().toString().replace("-", "");
                    System.out.println("IMAGE_DIR--->"+IMAGE_DIR);
                    System.out.println("imageName--->"+imageName);
                    System.out.println("photo--->"+photo);
                    // 이미지 파일 저장
                    String savedFileName = FileUploadController.saveFile(IMAGE_DIR, imageName, photo);

                    // 사진 URL을 리뷰에 추가 (여기서는 예시로 productImageUrl을 사용)
                    if(i == 1){
                        reviewDTO.setRePhoto1(savedFileName);
                    }else if(i == 2){
                        reviewDTO.setRePhoto2(savedFileName);
                    }else if(i == 3){
                        reviewDTO.setRePhoto3(savedFileName);
                    }
                    System.out.println("savedFileName--->"+savedFileName);
                }
                i++;
            }
        }
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


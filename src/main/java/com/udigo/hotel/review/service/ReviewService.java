package com.udigo.hotel.review.service;

import com.udigo.hotel.review.dao.ReviewMapper;
import com.udigo.hotel.review.dto.ReviewDTO;
import com.udigo.hotel.review.fileupload.FileUploadController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.annotation.PostConstruct;
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

    // 애플리케이션 시작 시 이미지 URL 업데이트 실행
    @PostConstruct
    public void initializeImageUrls() {
        try {
            updateAllImageUrls();
            System.out.println("리뷰 이미지 URL 업데이트 완료");
        } catch (Exception e) {
            System.err.println("리뷰 이미지 URL 업데이트 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    // 모든 리뷰 이미지 URL 업데이트
    public void updateAllImageUrls() {
        reviewMapper.updateImageUrls();
    }

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
//        System.out.println("photos--->"+photos);
        // 이미지 저장
        if (!photos.isEmpty()) {
            int i = 1;
            for (MultipartFile photo : photos) {  // 'for' 문을 올바르게 수정
//                System.out.println("photo--->"+photo);

                if (!photo.isEmpty()) {

                    String imageName = UUID.randomUUID().toString().replace("-", "");
//                    System.out.println("IMAGE_DIR--->"+IMAGE_DIR);
//                    System.out.println("imageName--->"+imageName);
//                    System.out.println("photo--->"+photo);
                    // 이미지 파일 저장
                    String savedFileName = FileUploadController.saveFile(IMAGE_DIR, imageName, photo);

                    // 전체 이미지 URL 생성 (컨텍스트 경로 포함)
                    String fullImageUrl = "/image/review/" + savedFileName;

                    // 사진 URL을 리뷰에 추가
                    if(i == 1){
                        reviewDTO.setRePhoto1(fullImageUrl);
                    }else if(i == 2){
                        reviewDTO.setRePhoto2(fullImageUrl);
                    }else if(i == 3){
                        reviewDTO.setRePhoto3(fullImageUrl);
                    }
                    System.out.println("savedFileName--->"+savedFileName);
                    System.out.println("fullImageUrl--->"+fullImageUrl);
                }
                i++;
            }
        }
        reviewMapper.insertReview(reviewDTO);
    }

    // 관리자용 전체 리뷰 조회 (페이징)
    public Map<String, Object> getAllReviews(int page) {
        int limit = 10; // 페이지당 리뷰 수
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

    // 관리자용 리뷰 삭제
    public void deleteReviewByAdmin(int reviewId) {
        reviewMapper.deleteReviewByAdmin(reviewId);
    }

    // 숙소별 후기 조회
    public List<ReviewDTO> getReviewsByAcmId(int acmId) {
        return reviewMapper.findReviewsByAcmId(acmId);
    }
}
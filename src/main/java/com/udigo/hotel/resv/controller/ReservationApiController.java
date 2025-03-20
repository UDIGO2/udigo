package com.udigo.hotel.resv.controller;

import com.udigo.hotel.member.security.CustomUserDetails;
import com.udigo.hotel.resv.model.dto.ResvDTO;
import com.udigo.hotel.resv.model.service.ResvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 예약 관련 API 요청을 처리하는 REST 컨트롤러
 * 프론트엔드(주로 JavaScript)에서 AJAX 호출을 통해 예약 데이터를 요청할 때 사용
 * JSON 형식으로 데이터를 반환함
 */
@RestController
@RequestMapping("/api/reservations")
public class ReservationApiController {

    @Autowired
    private ResvService resvService;

    /**
     * 특정 숙소의 모든 예약 정보를 조회하는 API 엔드포인트
     * 현재 로그인한 사용자의 예약인지 여부도 함께 표시
     * 
     * @param acmId 조회할 숙소 ID
     * @return 해당 숙소의 예약 정보 목록을 담은 ResponseEntity
     */
    @GetMapping("/acm/{acmId}")
    public ResponseEntity<List<ReservationResponse>> getReservationsByAcmId(@PathVariable("acmId") int acmId) {
        try {
            // 현재 로그인한 사용자 정보 가져오기
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            // final로 선언하여 람다에서 참조 가능하게 함
            final int currentUserCode;

            // 로그인 상태에 따라 회원 코드 설정
            if (auth.getPrincipal() instanceof CustomUserDetails) {
                CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();
                currentUserCode = userDetails.getMemberCode();
            } else {
                currentUserCode = -1; // 로그인하지 않은 경우 -1로 설정
            }

            // 해당 숙소의 모든 예약 정보 가져오기
            List<ResvDTO> reservations = resvService.getReservationsByAcmId(acmId);

            // 응답 데이터 변환 (DTO → Response 객체)
            List<ReservationResponse> response = reservations.stream()
                    .map(resv -> {
                        // 현재 로그인한 사용자의 예약인지 확인
                        boolean isCurrentUserReservation = (resv.getMemberCode() == currentUserCode);
                        return new ReservationResponse(
                                resv.getResvId(),
                                resv.getCheckIn(),
                                resv.getCheckOut(),
                                isCurrentUserReservation
                        );
                    })
                    .collect(Collectors.toList());

            return ResponseEntity.ok(response); // 성공 시 200 OK와 함께 데이터 반환
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build(); // 오류 시 400 Bad Request 반환
        }
    }

    /**
     * 예약 정보 API 응답을 위한 내부 정적 클래스
     * 필요한 정보만 클라이언트에 노출하기 위한 DTO 역할
     */
    public static class ReservationResponse {
        private int resvId;
        private String checkIn;
        private String checkOut;
        private boolean isCurrentUserReservation;

        /**
         * 예약 응답 객체 생성자
         * 
         * @param resvId 예약 ID
         * @param checkIn 체크인 날짜/시간
         * @param checkOut 체크아웃 날짜/시간
         * @param isCurrentUserReservation 현재 사용자의 예약 여부
         */
        public ReservationResponse(int resvId, Object checkIn, Object checkOut, boolean isCurrentUserReservation) {
            this.resvId = resvId;
            this.checkIn = checkIn.toString();
            this.checkOut = checkOut.toString();
            this.isCurrentUserReservation = isCurrentUserReservation;
        }

        // Getters
        /**
         * @return 예약 ID
         */
        public int getResvId() {
            return resvId;
        }

        /**
         * @return 체크인 날짜/시간 문자열
         */
        public String getCheckIn() {
            return checkIn;
        }

        /**
         * @return 체크아웃 날짜/시간 문자열
         */
        public String getCheckOut() {
            return checkOut;
        }

        /**
         * @return 현재 사용자의 예약인지 여부
         */
        public boolean isCurrentUserReservation() {
            return isCurrentUserReservation;
        }
    }
}
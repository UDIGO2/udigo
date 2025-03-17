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

@RestController
@RequestMapping("/api/reservations")
public class ReservationApiController {

    @Autowired
    private ResvService resvService;

    @GetMapping("/acm/{acmId}")
    public ResponseEntity<List<ReservationResponse>> getReservationsByAcmId(@PathVariable("acmId") int acmId) {
        try {
            // 현재 로그인한 사용자 정보 가져오기
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            // final로 선언하여 람다에서 참조 가능하게 함
            final int currentUserCode;

            if (auth.getPrincipal() instanceof CustomUserDetails) {
                CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();
                currentUserCode = userDetails.getMemberCode();
            } else {
                currentUserCode = -1;
            }

            // 해당 숙소의 모든 예약 정보 가져오기
            List<ResvDTO> reservations = resvService.getReservationsByAcmId(acmId);

            // 응답 데이터 변환
            List<ReservationResponse> response = reservations.stream()
                    .map(resv -> {
                        boolean isCurrentUserReservation = (resv.getMemberCode() == currentUserCode);
                        return new ReservationResponse(
                                resv.getResvId(),
                                resv.getCheckIn(),
                                resv.getCheckOut(),
                                isCurrentUserReservation
                        );
                    })
                    .collect(Collectors.toList());

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    // 응답 데이터 클래스
    public static class ReservationResponse {
        private int resvId;
        private String checkIn;
        private String checkOut;
        private boolean isCurrentUserReservation;

        public ReservationResponse(int resvId, Object checkIn, Object checkOut, boolean isCurrentUserReservation) {
            this.resvId = resvId;
            this.checkIn = checkIn.toString();
            this.checkOut = checkOut.toString();
            this.isCurrentUserReservation = isCurrentUserReservation;
        }

        // Getters
        public int getResvId() {
            return resvId;
        }

        public String getCheckIn() {
            return checkIn;
        }

        public String getCheckOut() {
            return checkOut;
        }

        public boolean isCurrentUserReservation() {
            return isCurrentUserReservation;
        }
    }
}
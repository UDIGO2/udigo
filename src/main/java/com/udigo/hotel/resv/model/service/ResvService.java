package com.udigo.hotel.resv.model.service;

import com.udigo.hotel.resv.model.dto.ResvDTO;
import com.udigo.hotel.resv.model.dao.ResvMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ResvService {

    @Autowired
    private ResvMapper resvMapper;

    // 모든 예약 조회
    public List<ResvDTO> getAllReservations() {
        return resvMapper.findAll();
    }

    // 회원 코드별 현재 예약 조회 (체크아웃 날짜가 현재 이후인 예약)
    public List<ResvDTO> getCurrentReservationsByMemberCode(int memberCode) {
        return resvMapper.findCurrentByMemberCode(memberCode, LocalDateTime.now());
    }

    // 회원 코드별 이전 예약 조회 (체크아웃 날짜가 현재 이전인 예약)
    public List<ResvDTO> getPastReservationsByMemberCode(int memberCode) {
        return resvMapper.findPastByMemberCode(memberCode, LocalDateTime.now());
    }

    // 회원 코드별 취소 가능한 예약 조회 (체크인 날짜가 현재 이후인 예약)
    public List<ResvDTO> getCancelableReservationsByMemberCode(int memberCode) {
        return resvMapper.findCancelableByMemberCode(memberCode, LocalDateTime.now());
    }

    // 예약 취소
    public void cancelReservation(int resvId) {
        resvMapper.cancelReservation(resvId);
    }
}
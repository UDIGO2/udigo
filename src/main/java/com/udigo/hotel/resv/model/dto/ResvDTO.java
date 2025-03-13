package com.udigo.hotel.resv.model.dto;

import java.time.LocalDateTime;

public class ResvDTO {
    private int resvId;
    private int acmId;
    private int memberCode;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private int guestCount;
    private boolean isResv;
    private LocalDateTime createdAt;

    public ResvDTO() {
    }

    public ResvDTO(int resvId, int acmId, int memberCode, LocalDateTime checkIn, LocalDateTime checkOut, int guestCount, boolean isResv, LocalDateTime createdAt) {
        this.resvId = resvId;
        this.acmId = acmId;
        this.memberCode = memberCode;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.guestCount = guestCount;
        this.isResv = isResv;
        this.createdAt = createdAt;
    }

    public int getResvId() {
        return resvId;
    }

    public void setResvId(int resvId) {
        this.resvId = resvId;
    }

    public int getAcmId() {
        return acmId;
    }

    public void setAcmId(int acmId) {
        this.acmId = acmId;
    }

    public int getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(int memberCode) {
        this.memberCode = memberCode;
    }

    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDateTime checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDateTime getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDateTime checkOut) {
        this.checkOut = checkOut;
    }

    public int getGuestCount() {
        return guestCount;
    }

    public void setGuestCount(int guestCount) {
        this.guestCount = guestCount;
    }

    public boolean isResv() {
        return isResv;
    }

    public void setResv(boolean resv) {
        isResv = resv;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "ResvDTO{" +
                "resvId=" + resvId +
                ", acmId=" + acmId +
                ", memberCode=" + memberCode +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", guestCount=" + guestCount +
                ", isResv=" + isResv +
                ", createdAt=" + createdAt +
                '}';
    }
}
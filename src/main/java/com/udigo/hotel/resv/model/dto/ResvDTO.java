package com.udigo.hotel.resv.model.dto;

import java.time.LocalDateTime;

public class ResvDTO {
    private int resvId;
    private int acmId;
    private int memberCode;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private int guestCount;
    private int isResv;
    private LocalDateTime createdAt;
    private String acmName;
    private String acmPhoto1;
    private int acmPrice;
    private int payId;
    private int discount;  // 쿠폰 할인 금액

    public ResvDTO() {
    }

    public ResvDTO(int resvId, int acmId, int memberCode, LocalDateTime checkIn, LocalDateTime checkOut, int guestCount, int isResv, LocalDateTime createdAt, String acmName, String acmPhoto1, int acmPrice) {
        this.resvId = resvId;
        this.acmId = acmId;
        this.memberCode = memberCode;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.guestCount = guestCount;
        this.isResv = isResv;
        this.createdAt = createdAt;
        this.acmName = acmName;
        this.acmPhoto1 = acmPhoto1;
        this.acmPrice = acmPrice;
    }

//    public ResvDTO(int resvId, int acmId, int memberCode, LocalDateTime checkIn, LocalDateTime checkOut, int guestCount, boolean isResv, LocalDateTime createdAt) {
//        this.resvId = resvId;
//        this.acmId = acmId;
//        this.memberCode = memberCode;
//        this.checkIn = checkIn;
//        this.checkOut = checkOut;
//        this.guestCount = guestCount;
//        this.isResv = isResv;
//        this.createdAt = createdAt;
//    }


    public String getAcmName() {
        return acmName;
    }

    public void setAcmName(String acmName) {
        this.acmName = acmName;
    }

    public String getAcmPhoto1() {
        return acmPhoto1;
    }

    public void setAcmPhoto1(String acmPhoto1) {
        this.acmPhoto1 = acmPhoto1;
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

    public int isResv() {
        return isResv;
    }

    public void setResv(int resv) {
        isResv = resv;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public int getAcmPrice() {
        return acmPrice;
    }

    public void setAcmPrice(int acmPrice) {
        this.acmPrice = acmPrice;
    }

    public int getPayId() {
        return payId;
    }

    public void setPayId(int payId) {
        this.payId = payId;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
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
                ", acmName='" + acmName + '\'' +
                ", acmPhoto1='" + acmPhoto1 + '\'' +
                ", acmPrice=" + acmPrice +
                ", payId=" + payId +
                ", discount=" + discount +
                '}';
    }
}
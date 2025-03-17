package com.udigo.hotel.review.dto;

import java.time.LocalDateTime;

public class ReviewDTO {

    //다시 셋팅해야함

    private int reviewId;
    private int memberCode;
    private int acmId;
    private int acmPrice;
    private int resvId;
    private String content;
    private String acmName;
    private LocalDateTime writtenAt;
    private String rePhoto1;
    private String rePhoto2;
    private String rePhoto3;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private String acmPhoto1;
    private String acmPhoto2;
    private String acmPhoto3;

    public ReviewDTO() {
    }

    public ReviewDTO(int reviewId, int memberCode, int acmId, int acmPrice, int resvId, String content, String acmName, LocalDateTime writtenAt, String rePhoto1, String rePhoto2, String rePhoto3, LocalDateTime checkIn, LocalDateTime checkOut, String acmPhoto1, String acmPhoto2, String acmPhoto3) {
        this.reviewId = reviewId;
        this.memberCode = memberCode;
        this.acmId = acmId;
        this.acmPrice = acmPrice;
        this.resvId = resvId;
        this.content = content;
        this.acmName = acmName;
        this.writtenAt = writtenAt;
        this.rePhoto1 = rePhoto1;
        this.rePhoto2 = rePhoto2;
        this.rePhoto3 = rePhoto3;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.acmPhoto1 = acmPhoto1;
        this.acmPhoto2 = acmPhoto2;
        this.acmPhoto3 = acmPhoto3;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(int memberCode) {
        this.memberCode = memberCode;
    }

    public int getAcmId() {
        return acmId;
    }

    public void setAcmId(int acmId) {
        this.acmId = acmId;
    }

    public int getAcmPrice() {
        return acmPrice;
    }

    public void setAcmPrice(int acmPrice) {
        this.acmPrice = acmPrice;
    }

    public int getResvId() {
        return resvId;
    }

    public void setResvId(int resvId) {
        this.resvId = resvId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAcmName() {
        return acmName;
    }

    public void setAcmName(String acmName) {
        this.acmName = acmName;
    }

    public LocalDateTime getWrittenAt() {
        return writtenAt;
    }

    public void setWrittenAt(LocalDateTime writtenAt) {
        this.writtenAt = writtenAt;
    }

    public String getRePhoto1() {
        return rePhoto1;
    }

    public void setRePhoto1(String rePhoto1) {
        this.rePhoto1 = rePhoto1;
    }

    public String getRePhoto2() {
        return rePhoto2;
    }

    public void setRePhoto2(String rePhoto2) {
        this.rePhoto2 = rePhoto2;
    }

    public String getRePhoto3() {
        return rePhoto3;
    }

    public void setRePhoto3(String rePhoto3) {
        this.rePhoto3 = rePhoto3;
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

    public String getAcmPhoto1() {
        return acmPhoto1;
    }

    public void setAcmPhoto1(String acmPhoto1) {
        this.acmPhoto1 = acmPhoto1;
    }

    public String getAcmPhoto2() {
        return acmPhoto2;
    }

    public void setAcmPhoto2(String acmPhoto2) {
        this.acmPhoto2 = acmPhoto2;
    }

    public String getAcmPhoto3() {
        return acmPhoto3;
    }

    public void setAcmPhoto3(String acmPhoto3) {
        this.acmPhoto3 = acmPhoto3;
    }

    @Override
    public String toString() {
        return "ReviewDTO{" +
                "reviewId=" + reviewId +
                ", memberCode=" + memberCode +
                ", acmId=" + acmId +
                ", acmPrice=" + acmPrice +
                ", resvId=" + resvId +
                ", content='" + content + '\'' +
                ", acmName='" + acmName + '\'' +
                ", writtenAt=" + writtenAt +
                ", rePhoto1='" + rePhoto1 + '\'' +
                ", rePhoto2='" + rePhoto2 + '\'' +
                ", rePhoto3='" + rePhoto3 + '\'' +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", acmPhoto1='" + acmPhoto1 + '\'' +
                ", acmPhoto2='" + acmPhoto2 + '\'' +
                ", acmPhoto3='" + acmPhoto3 + '\'' +
                '}';
    }
}

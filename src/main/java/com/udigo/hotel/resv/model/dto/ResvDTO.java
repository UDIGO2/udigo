package com.udigo.hotel.resv.model.dto;

import java.time.LocalDateTime;

/**
 * 예약 정보를 담는 데이터 전송 객체(DTO)
 * 예약 기본 정보와 함께 연관된 숙소 정보, 결제 정보를 포함
 */
public class ResvDTO {
    /** 예약 ID */
    private int resvId;
    
    /** 숙소 ID (외래키) */
    private int acmId;
    
    /** 회원 코드 (예약자) */
    private int memberCode;
    
    /** 체크인 날짜/시간 */
    private LocalDateTime checkIn;
    
    /** 체크아웃 날짜/시간 */
    private LocalDateTime checkOut;
    
    /** 투숙객 수 */
    private int guestCount;
    
    /** 예약 상태 (1: 예약중, 0: 취소됨) */
    private int isResv;
    
    /** 예약 생성 시간 */
    private LocalDateTime createdAt;
    
    /** 숙소 이름 (조인으로 가져옴) */
    private String acmName;
    
    /** 숙소 대표 사진 URL (조인으로 가져옴) */
    private String acmPhoto1;
    
    /** 숙소 가격 (조인으로 가져옴) */
    private int acmPrice;
    
    /** 결제 ID (외래키) */
    private int payId;
    
    /** 쿠폰 할인 금액 (결제 정보에서 가져옴) */
    private int discount;

    /**
     * 기본 생성자
     */
    public ResvDTO() {
    }

    /**
     * 예약 정보 생성자 - 모든 필드 포함
     * 
     * @param resvId 예약 ID
     * @param acmId 숙소 ID
     * @param memberCode 회원 코드
     * @param checkIn 체크인 날짜/시간
     * @param checkOut 체크아웃 날짜/시간
     * @param guestCount 투숙객 수
     * @param isResv 예약 상태
     * @param createdAt 생성 시간
     * @param acmName 숙소 이름
     * @param acmPhoto1 숙소 사진
     * @param acmPrice 숙소 가격
     */
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

    /**
     * @return 숙소 이름
     */
    public String getAcmName() {
        return acmName;
    }

    /**
     * @param acmName 설정할 숙소 이름
     */
    public void setAcmName(String acmName) {
        this.acmName = acmName;
    }

    /**
     * @return 숙소 대표 사진 URL
     */
    public String getAcmPhoto1() {
        return acmPhoto1;
    }

    /**
     * @param acmPhoto1 설정할 숙소 사진 URL
     */
    public void setAcmPhoto1(String acmPhoto1) {
        this.acmPhoto1 = acmPhoto1;
    }

    /**
     * @return 예약 ID
     */
    public int getResvId() {
        return resvId;
    }

    /**
     * @param resvId 설정할 예약 ID
     */
    public void setResvId(int resvId) {
        this.resvId = resvId;
    }

    /**
     * @return 숙소 ID
     */
    public int getAcmId() {
        return acmId;
    }

    /**
     * @param acmId 설정할 숙소 ID
     */
    public void setAcmId(int acmId) {
        this.acmId = acmId;
    }

    /**
     * @return 회원 코드
     */
    public int getMemberCode() {
        return memberCode;
    }

    /**
     * @param memberCode 설정할 회원 코드
     */
    public void setMemberCode(int memberCode) {
        this.memberCode = memberCode;
    }

    /**
     * @return 체크인 날짜/시간
     */
    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    /**
     * @param checkIn 설정할 체크인 날짜/시간
     */
    public void setCheckIn(LocalDateTime checkIn) {
        this.checkIn = checkIn;
    }

    /**
     * @return 체크아웃 날짜/시간
     */
    public LocalDateTime getCheckOut() {
        return checkOut;
    }

    /**
     * @param checkOut 설정할 체크아웃 날짜/시간
     */
    public void setCheckOut(LocalDateTime checkOut) {
        this.checkOut = checkOut;
    }

    /**
     * @return 투숙객 수
     */
    public int getGuestCount() {
        return guestCount;
    }

    /**
     * @param guestCount 설정할 투숙객 수
     */
    public void setGuestCount(int guestCount) {
        this.guestCount = guestCount;
    }

    /**
     * @return 예약 상태 (1: 예약중, 0: 취소됨)
     */
    public int isResv() {
        return isResv;
    }

    /**
     * @param resv 설정할 예약 상태
     */
    public void setResv(int resv) {
        isResv = resv;
    }

    /**
     * @return 예약 생성 시간
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt 설정할 생성 시간
     */
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return 숙소 가격
     */
    public int getAcmPrice() {
        return acmPrice;
    }

    /**
     * @param acmPrice 설정할 숙소 가격
     */
    public void setAcmPrice(int acmPrice) {
        this.acmPrice = acmPrice;
    }

    /**
     * @return 결제 ID
     */
    public int getPayId() {
        return payId;
    }

    /**
     * @param payId 설정할 결제 ID
     */
    public void setPayId(int payId) {
        this.payId = payId;
    }

    /**
     * @return 할인 금액
     */
    public int getDiscount() {
        return discount;
    }

    /**
     * @param discount 설정할 할인 금액
     */
    public void setDiscount(int discount) {
        this.discount = discount;
    }

    /**
     * 예약 정보를 문자열로 변환
     * 디버깅 및 로깅 용도로 사용
     * 
     * @return 예약 정보를 포함한 문자열
     */
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
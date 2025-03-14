package com.udigo.hotel.acm.model.dto;

import java.time.LocalDateTime;

public class AcmDTO {

    private int acmId;
    private String acmName;
    private String acmAddress;
    private String acmLocation;
    private long acmPrice;
    private String acmInfo;
    private String acmPhone;
    private LocalDateTime acmDate;
    private int maxGuest;
    private int likedCount;
    private String acmPhoto1;
    private String acmPhoto2;
    private String acmPhoto3;
    private String acmPhoto4;
    private String acmPhoto5;

    // 체크인 및 체크아웃 날짜 추가
    private String checkInDate; // 체크인 날짜
    private String checkOutDate; // 체크아웃 날짜

    public AcmDTO() {
    }

    public AcmDTO(int acmId, String acmName, String acmAddress, String acmLocation, long acmPrice, String acmInfo, String acmPhone, LocalDateTime acmDate, int maxGuest, int likedCount, String acmPhoto1, String acmPhoto2, String acmPhoto3, String acmPhoto4, String acmPhoto5, String checkInDate, String checkOutDate) {
        this.acmId = acmId;
        this.acmName = acmName;
        this.acmAddress = acmAddress;
        this.acmLocation = acmLocation;
        this.acmPrice = acmPrice;
        this.acmInfo = acmInfo;
        this.acmPhone = acmPhone;
        this.acmDate = acmDate;
        this.maxGuest = maxGuest;
        this.likedCount = likedCount;
        this.acmPhoto1 = acmPhoto1;
        this.acmPhoto2 = acmPhoto2;
        this.acmPhoto3 = acmPhoto3;
        this.acmPhoto4 = acmPhoto4;
        this.acmPhoto5 = acmPhoto5;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public int getAcmId() {
        return acmId;
    }

    public void setAcmId(int acmId) {
        this.acmId = acmId;
    }

    public String getAcmName() {
        return acmName;
    }

    public void setAcmName(String acmName) {
        this.acmName = acmName;
    }

    public String getAcmAddress() {
        return acmAddress;
    }

    public void setAcmAddress(String acmAddress) {
        this.acmAddress = acmAddress;
    }

    public String getAcmLocation() {
        return acmLocation;
    }

    public void setAcmLocation(String acmLocation) {
        this.acmLocation = acmLocation;
    }

    public long getAcmPrice() {
        return acmPrice;
    }

    public void setAcmPrice(long acmPrice) {
        this.acmPrice = acmPrice;
    }

    public String getAcmInfo() {
        return acmInfo;
    }

    public void setAcmInfo(String acmInfo) {
        this.acmInfo = acmInfo;
    }

    public String getAcmPhone() {
        return acmPhone;
    }

    public void setAcmPhone(String acmPhone) {
        this.acmPhone = acmPhone;
    }

    public LocalDateTime getAcmDate() {
        return acmDate;
    }

    public void setAcmDate(LocalDateTime acmDate) {
        this.acmDate = acmDate;
    }

    public int getMaxGuest() {
        return maxGuest;
    }

    public void setMaxGuest(int maxGuest) {
        this.maxGuest = maxGuest;
    }

    public int getLikedCount() {
        return likedCount;
    }

    public void setLikedCount(int likedCount) {
        this.likedCount = likedCount;
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

    public String getAcmPhoto4() {
        return acmPhoto4;
    }

    public void setAcmPhoto4(String acmPhoto4) {
        this.acmPhoto4 = acmPhoto4;
    }

    public String getAcmPhoto5() {
        return acmPhoto5;
    }

    public void setAcmPhoto5(String acmPhoto5) {
        this.acmPhoto5 = acmPhoto5;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    @Override
    public String toString() {
        return "AcmDTO{" +
                "acmId=" + acmId +
                ", acmName='" + acmName + '\'' +
                ", acmAddress='" + acmAddress + '\'' +
                ", acmLocation='" + acmLocation + '\'' +
                ", acmPrice=" + acmPrice +
                ", acmInfo='" + acmInfo + '\'' +
                ", acmPhone='" + acmPhone + '\'' +
                ", acmDate=" + acmDate +
                ", maxGuest=" + maxGuest +
                ", likedCount=" + likedCount +
                ", acmPhoto1='" + acmPhoto1 + '\'' +
                ", acmPhoto2='" + acmPhoto2 + '\'' +
                ", acmPhoto3='" + acmPhoto3 + '\'' +
                ", acmPhoto4='" + acmPhoto4 + '\'' +
                ", acmPhoto5='" + acmPhoto5 + '\'' +
                ", checkInDate='" + checkInDate + '\'' +
                ", checkOutDate='" + checkOutDate + '\'' +
                '}';

    }
}

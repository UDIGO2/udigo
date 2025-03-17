package com.udigo.hotel.pay.model.dto;


import java.time.LocalDateTime;

//@Data
public class PayDTO {
    private int payId;
    private int memberCode;
    private int acmId;
    private String acmName;
    private int guestCount;
    private String checkIn;
    private String checkOut;
    private String payMethod;
    private String payStatus;
    private String payType;
    private LocalDateTime payDate;
    private int payPrice;
    private int discount;
    private String transactionId;
    private String payProvider;

    public PayDTO() {
    }

    public PayDTO(int payId, int memberCode, int acmId, String acmName, int guestCount, String checkIn, String checkOut, String payMethod, String payStatus, String payType, LocalDateTime payDate, int payPrice, int discount, String transactionId, String payProvider) {
        this.payId = payId;
        this.memberCode = memberCode;
        this.acmId = acmId;
        this.acmName = acmName;
        this.guestCount = guestCount;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.payMethod = payMethod;
        this.payStatus = payStatus;
        this.payType = payType;
        this.payDate = payDate;
        this.payPrice = payPrice;
        this.discount = discount;
        this.transactionId = transactionId;
        this.payProvider = payProvider;
    }

    public int getPayId() {
        return payId;
    }

    public void setPayId(int payId) {
        this.payId = payId;
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

    public String getAcmName() { return acmName; }

    public void setAcmName(String acmName) { this.acmName = acmName; }

    public int getGuestCount() { return guestCount; }

    public void setGuestCount(int guestCount) { this.guestCount = guestCount; }

    public String getCheckIn() { return checkIn; }

    public void setCheckIn(String checkIn) { this.checkIn = checkIn; }

    public String getCheckOut() { return checkOut; }

    public void setCheckOut(String checkOut) { this.checkOut = checkOut; }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public LocalDateTime getPayDate() {
        return payDate;
    }

    public void setPayDate(LocalDateTime payDate) {
        this.payDate = payDate;
    }

    public int getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(int payPrice) {
        this.payPrice = payPrice;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getPayProvider() {
        return payProvider;
    }

    public void setPayProvider(String payProvider) {
        this.payProvider = payProvider;
    }

    @Override
    public String toString() {
        return "PayDTO{" +
                "payId=" + payId +
                ", memberCode=" + memberCode +
                ", acmId=" + acmId +
                ", acmName='" + acmName + '\'' +
                ", guestCount=" + guestCount +
                ", checkIn='" + checkIn + '\'' +
                ", checkOut='" + checkOut + '\'' +
                ", payMethod='" + payMethod + '\'' +
                ", payStatus='" + payStatus + '\'' +
                ", payType='" + payType + '\'' +
                ", payDate=" + payDate +
                ", payPrice=" + payPrice +
                ", discount=" + discount +
                ", transactionId='" + transactionId + '\'' +
                ", payProvider='" + payProvider + '\'' +
                '}';
    }
}


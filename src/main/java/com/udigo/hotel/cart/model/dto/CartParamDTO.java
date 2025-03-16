package com.udigo.hotel.cart.model.dto;

public class CartParamDTO {
    private int memberCode;
    private int acmId;

    public CartParamDTO() {}

    public CartParamDTO(int memberCode, int acmId) {
        this.memberCode = memberCode;
        this.acmId = acmId;
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

    @Override
    public String toString() {
        return "CartParamDTO{" +
                ", memberCode=" + memberCode +
                ", acmId=" + acmId +
                '}';
    }
}

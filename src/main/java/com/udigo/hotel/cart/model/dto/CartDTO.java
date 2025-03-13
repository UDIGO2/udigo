package com.udigo.hotel.cart.model.dto;

import com.udigo.hotel.acm.model.dto.AcmDTO;
//import lombok.Data;

//@Data
public class CartDTO {
    private int cartCode;
    private int memberCode;
    private int acmId;

    private AcmDTO acm; // 숙소 상세정보

    public CartDTO() {
    }

    public CartDTO(int cartCode, int memberCode, int acmId, AcmDTO acm) {
        this.cartCode = cartCode;
        this.memberCode = memberCode;
        this.acmId = acmId;
        this.acm = acm;
    }

    public int getCartCode() {
        return cartCode;
    }

    public void setCartCode(int cartCode) {
        this.cartCode = cartCode;
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

    public AcmDTO getAcm() {
        return acm;
    }

    public void setAcm(AcmDTO acm) {
        this.acm = acm;
    }

    @Override
    public String toString() {
        return "CartDTO{" +
                "cartCode=" + cartCode +
                ", memberCode=" + memberCode +
                ", acmId=" + acmId +
                ", acm=" + acm +
                '}';
    }
}

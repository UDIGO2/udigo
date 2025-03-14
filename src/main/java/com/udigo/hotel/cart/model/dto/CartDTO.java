package com.udigo.hotel.cart.model.dto;

public class CartDTO {
    private int cartCode;
    private int memberCode;
    private int acmId;

    public CartDTO() {}

    public CartDTO(int cartCode, int memberCode, int acmId) {
        this.cartCode = cartCode;
        this.memberCode = memberCode;
        this.acmId = acmId;
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

    @Override
    public String toString() {
        return "CartDTO{" +
                "cartCode=" + cartCode +
                ", memberCode=" + memberCode +
                ", acmId=" + acmId +
                '}';
    }
}
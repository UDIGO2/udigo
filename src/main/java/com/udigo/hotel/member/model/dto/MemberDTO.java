package com.udigo.hotel.member.model.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

public class MemberDTO implements UserDetails {

    private int memberCode;
    private String memberId;
    private String memberName;
    private String email;
    private String password;
    private String phoneNo;
    private boolean couponUsed; // ✅ 쿠폰 사용 여부 추가
    private List<GrantedAuthority> authorities;
    private String role;
    private Timestamp joinDate;

    public MemberDTO() {}

    public MemberDTO(int memberCode, String memberId, String memberName, String email,
                     String password, String phoneNo, List<GrantedAuthority> authorities,
                     Timestamp joinDate, boolean couponUsed) {
        this.memberCode = memberCode;
        this.memberId = memberId;
        this.memberName = memberName;
        this.email = email;
        this.password = password;
        this.phoneNo = phoneNo;
        this.authorities = authorities;
        this.joinDate = joinDate;
        this.couponUsed = couponUsed;
    }

    // ✅ Getter & Setter
    public int getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(int memberCode) {
        this.memberCode = memberCode;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Timestamp getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Timestamp joinDate) {
        this.joinDate = joinDate;
    }

    public void setAuthorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getUsername() {
        return memberId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    public boolean getCouponUsed() {
        return couponUsed;
    }

    public void setCouponUsed(boolean couponUsed) {
        this.couponUsed = couponUsed;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "memberCode=" + memberCode +
                ", memberId='" + memberId + '\'' +
                ", memberName='" + memberName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", joinDate=" + joinDate +
                ", couponUsed=" + couponUsed +
                '}';
    }

}

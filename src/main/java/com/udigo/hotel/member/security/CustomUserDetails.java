package com.udigo.hotel.member.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {
    private int memberCode;
    private String email;
    private String password;
    private String role;
    private String memberName;
    private String memberId;  // 로그인 ID 필드

    // 생성자 추가 (필요한 정보 초기화)
    public CustomUserDetails(int memberCode, String email, String password, String role, String memberName, String memberId) {
        this.memberCode = memberCode;
        this.email = email;
        this.password = password;
        this.role = role != null ? role : "USER";  // 기본 역할이 없는 경우 "USER"로 설정
        this.memberName = memberName;
        this.memberId = memberId;
    }

    // `getUsername()`을 `memberId`로 변경 (Spring Security가 로그인 ID로 사용)
    @Override
    public String getUsername() {
        return memberId;  // `authentication.getName()`이 `memberId`를 반환하도록 설정
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + role));
    }

    @Override
    public String getPassword() {
        return password;
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

    public int getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(int memberCode) {
        this.memberCode = memberCode;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
}

package com.udigo.hotel.member.model.dto;

import com.udigo.hotel.auth.model.dto.MemberRoleDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class MemberDTO implements UserDetails, Serializable {

    private int memberCode;     // 회원 식별 코드
    private String memberId;    // 아이디
    private String memberName;  // 회원 이름
    private String password;    // 비밀번호
    private String phoneNo;     // 핸드폰 번호
    private String email;       // 이메일

    private List<MemberRoleDTO> memberRole; // 회원별 권한
    private Collection<GrantedAuthority> authorities; // Spring Security 권한 목록

    public MemberDTO() {
    }

    public MemberDTO(int memberCode, String memberId, String memberName, String password,
                     String phoneNo, String email, List<MemberRoleDTO> memberRole,
                     Collection<GrantedAuthority> authorities) {
        this.memberCode = memberCode;
        this.memberId = memberId;
        this.memberName = memberName;
        this.password = password;
        this.phoneNo = phoneNo;
        this.email = email;
        this.memberRole = memberRole;
        this.authorities = authorities;
    }

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

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return "";
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<MemberRoleDTO> getMemberRole() {
        return memberRole;
    }

    public void setMemberRole(List<MemberRoleDTO> memberRole) {
        this.memberRole = memberRole;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "memberCode=" + memberCode +
                ", memberId='" + memberId + '\'' +
                ", memberName='" + memberName + '\'' +
                ", password='" + password + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", email='" + email + '\'' +
                ", memberRole=" + memberRole +
                ", authorities=" + authorities +
                '}';
    }
}

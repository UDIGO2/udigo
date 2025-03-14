package com.udigo.hotel.auth.model.dto;

public class MemberRoleDTO {
    private int memberCode; // 회원 코드
    private int roleCode;   // 권한 코드
    private AuthorityDTO authority; // 권한 정보 (role_code + role_name)

    public MemberRoleDTO() {}

    public MemberRoleDTO(int memberCode, int roleCode, AuthorityDTO authority) {
        this.memberCode = memberCode;
        this.roleCode = roleCode;
        this.authority = authority;
    }

    public int getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(int memberCode) {
        this.memberCode = memberCode;
    }

    public int getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(int roleCode) {
        this.roleCode = roleCode;
    }

    public AuthorityDTO getAuthority() {
        return authority;
    }

    public void setAuthority(AuthorityDTO authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "MemberRoleDTO{" +
                "memberCode=" + memberCode +
                ", roleCode=" + roleCode +
                ", authority=" + authority +
                '}';
    }
}

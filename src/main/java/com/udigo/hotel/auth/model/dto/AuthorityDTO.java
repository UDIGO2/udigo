package com.udigo.hotel.auth.model.dto;

public class AuthorityDTO {
    private int roleCode;  // 권한 코드
    private String roleName; // 권한 이름

    public AuthorityDTO() {
    }

    public AuthorityDTO(int roleCode, String roleName) {
        this.roleCode = roleCode;
        this.roleName = roleName;
    }

    public int getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(int roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "AuthorityDTO{" +
                "roleCode=" + roleCode +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
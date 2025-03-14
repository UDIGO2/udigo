package com.udigo.hotel.member.model.dto;

public class MemberDTO {
    private int memberCode;  // 회원 코드
    private String memberId;  // 회원 ID
    private String memberName; // 사용자명
    private String email;  // 이메일
    private String password;  // 비밀번호
    private String phoneNo;  // 휴대폰 번호

    public MemberDTO() {
    }

    public MemberDTO(int memberCode, String memberId, String memberName, String email, String password, String phoneNo) {
        this.memberCode = memberCode;
        this.memberId = memberId;
        this.memberName = memberName; // 수정된 필드명 반영
        this.email = email;
        this.password = password;
        this.phoneNo = phoneNo;
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

    public String getMemberName() { // 메서드명 수정
        return memberName;
    }

    public void setMemberName(String memberName) { // 메서드명 수정
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

    @Override
    public String toString() {
        return "MemberDTO{" +
                "memberCode=" + memberCode +
                ", memberId='" + memberId + '\'' +
                ", memberName='" + memberName + '\'' + // 수정된 필드 반영
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                '}';
    }
}

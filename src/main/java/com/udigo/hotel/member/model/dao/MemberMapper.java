package com.udigo.hotel.member.model.dao;

import com.udigo.hotel.member.model.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MemberMapper {

    /** ✅ 회원 정보 저장 */
    void insertMember(MemberDTO memberDTO);

    /** ✅ member_id를 기반으로 회원 정보 조회 */
    MemberDTO findByMemberId(@Param("memberId") String memberId);

    /** ✅ 이메일 기반 회원 조회 */
    MemberDTO findByEmail(@Param("email") String email);

    /** ✅ 회원 정보 수정 */
    void updateMember(MemberDTO memberDTO);

    /** ✅ 이메일로 아이디 찾기 */
    String findIdByEmail(@Param("email") String email);

    /** ✅ 아이디와 이메일로 회원 조회 */
    MemberDTO findByMemberIdAndEmail(@Param("memberId") String memberId, @Param("email") String email);

    /** ✅ 회원 비밀번호 조회 */
    String getPasswordByMemberId(@Param("memberId") String memberId);

    /* 회원 탈퇴 처리 (member_id 무효화 및 상태 변경) */
    int updateWithdrawMember(@Param("memberId") String memberId);

    /* 임시 비밀번호 저장 */
    void updatePassword(@Param("memberId") String memberId, @Param("password") String password);

    /* 전체 회원 목록 조회 */
    List<MemberDTO> selectAllMembers();

    /* 쿠폰 사용 (coupon_used 값을 true로 변경) */
    void updateCouponUsed(@Param("memberId") String memberId, @Param("couponUsed") boolean couponUsed);

    /* 쿠폰 사용 여부 조회 */
    Integer getCouponStatus(@Param("memberId") String memberId);

    /* 특정 회원 정보 조회 */
    MemberDTO selectMemberById(@Param("memberId") String memberId);
}

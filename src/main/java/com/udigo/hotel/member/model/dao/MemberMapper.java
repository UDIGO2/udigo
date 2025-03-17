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
    MemberDTO findByMemberId(String memberId);

    MemberDTO findByEmail(String email);

    void updateMember(MemberDTO memberDTO);

    String findIdByEmail(String email);

    /** ✅ 아이디와 이메일로 회원 조회 */
    MemberDTO findByMemberIdAndEmail(@Param("memberId") String memberId, @Param("email") String email);

    /** ✅ 임시 비밀번호 저장 */
    void updatePassword(@Param("memberId") String memberId, @Param("password") String password);

    List<MemberDTO> selectAllMembers();

    MemberDTO selectMemberById(@Param("memberId") String memberId);


    /** ✅ 쿠폰 사용 (coupon_used 값을 1로 변경) */
    void updateCouponUsed(@Param("memberId") String memberId, @Param("couponUsed") boolean couponUsed);

    /** ✅ 쿠폰 사용 여부 조회 */
    Integer getCouponStatus(String memberId);

}



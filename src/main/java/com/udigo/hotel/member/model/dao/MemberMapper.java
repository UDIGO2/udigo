package com.udigo.hotel.member.model.dao;

import com.udigo.hotel.member.model.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemberMapper {

    /** 회원 정보 조회 (아이디 기준) */
    MemberDTO findByMemberId(@Param("memberId") String memberId);

    /** 아이디 중복 확인 */
    boolean existsByMemberId(@Param("memberId") String memberId);

    /** 이메일 중복 확인 */
    boolean existsByEmail(@Param("Email") String Email);

    /** 회원 정보 저장 (회원가입) */
    int insertMember(MemberDTO member);

    /** 회원 권한 저장 (기본 ROLE_USER) */
    int insertMemberRole(@Param("memberCode") int memberCode);

    /** 회원 정보 수정 */
    int updateMember(MemberDTO member);

    /** 회원 비밀번호 변경 */
    int updateMemberPassword(@Param("memberCode") int memberCode, @Param("password") String password);
}

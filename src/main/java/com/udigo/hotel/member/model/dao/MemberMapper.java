package com.udigo.hotel.member.model.dao;

import com.udigo.hotel.member.model.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    /** ✅ 회원 정보 저장 */
    void insertMember(MemberDTO memberDTO);

    /** ✅ member_id를 기반으로 회원 정보 조회 */
    MemberDTO findByMemberId(String memberId);
}

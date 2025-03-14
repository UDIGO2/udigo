package com.udigo.hotel.auth.model.dao;

import com.udigo.hotel.auth.model.dto.AuthorityDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AuthMapper {

    /** ✅ 특정 회원의 권한 목록 조회 */
    @Select("SELECT r.role_code, r.role_name FROM tbl_roles r " +
            "JOIN tbl_member_roles mr ON r.role_code = mr.role_code " +
            "WHERE mr.member_code = #{memberCode}")
    List<AuthorityDTO> findAuthorityByMemberCode(int memberCode);
}

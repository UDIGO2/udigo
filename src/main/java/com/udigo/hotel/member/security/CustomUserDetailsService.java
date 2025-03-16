package com.udigo.hotel.member.security;

import com.udigo.hotel.member.model.dto.MemberDTO;
import com.udigo.hotel.member.model.dao.MemberMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberMapper memberMapper;

    // 생성자 주입 방식으로 변경
    public CustomUserDetailsService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MemberDTO member = memberMapper.findByMemberId(username);
        if (member == null) {
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다: " + username);
        }

        CustomUserDetails userDetails = new CustomUserDetails();
        userDetails.setMemberCode(member.getMemberCode());
        userDetails.setMemberId(member.getMemberId());
        userDetails.setPassword(member.getPassword());
        userDetails.setMemberName(member.getMemberName());

        // member_code가 1인 경우 ADMIN, 그 외는 USER로 설정
        String role = member.getMemberCode() == 1 ? "ADMIN" : "USER";
        userDetails.setRole(role);

        return userDetails;
    }
}
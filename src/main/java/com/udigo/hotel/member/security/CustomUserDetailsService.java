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

    // ✅ 생성자 주입 방식
    public CustomUserDetailsService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // ✅ DB에서 회원 정보 조회
        MemberDTO member = memberMapper.findByMemberId(username);
        if (member == null) {
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다: " + username);
        }

        // ✅ role 기본값을 "USER"로 설정하고, member_code가 1이면 "ADMIN"
        String role = member.getMemberCode() == 1 ? "ADMIN" : "USER";

        // ✅ `CustomUserDetails` 생성자를 이용하여 객체 생성
        return new CustomUserDetails(
                member.getMemberCode(),
                member.getEmail(),
                member.getPassword(),
                role,
                member.getMemberName(),
                member.getMemberId()
        );

    }

}

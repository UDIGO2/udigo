package com.udigo.hotel.auth.model.service;

import com.udigo.hotel.auth.model.dao.AuthMapper;
import com.udigo.hotel.auth.model.dto.AuthorityDTO;
import com.udigo.hotel.member.model.dao.MemberMapper;
import com.udigo.hotel.member.model.dto.MemberDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthService implements UserDetailsService {

    private final MemberMapper memberMapper;
    private final AuthMapper authMapper;

    public AuthService(MemberMapper memberMapper, AuthMapper authMapper) {
        this.memberMapper = memberMapper;
        this.authMapper = authMapper;
    }

    /** ✅ 회원 정보 조회 및 인증 */
    @Override
    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {

        // 🔹 회원 정보 조회
        MemberDTO member = memberMapper.findByMemberId(memberId);

        if (member == null) {
            throw new UsernameNotFoundException("회원 정보가 존재하지 않습니다: " + memberId);
        }

        // 🔹 회원 권한 조회
        List<AuthorityDTO> authorities = authMapper.findAuthorityByMemberCode(member.getMemberCode());

        // 🔹 Spring Security에서 사용할 GrantedAuthority 변환
        List<GrantedAuthority> grantedAuthorities = authorities.stream()
                .map(auth -> new SimpleGrantedAuthority(auth.getRoleName()))
                .collect(Collectors.toList());

        // 🔹 회원 객체에 권한 정보 설정
        member.setAuthorities(grantedAuthorities);

        return member;
    }


}

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

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthService implements UserDetailsService {

    private final MemberMapper memberMapper;
    private final AuthMapper authMapper;

    public AuthService(MemberMapper memberMapper, AuthMapper authMapper) {
        this.memberMapper = memberMapper;
        this.authMapper = authMapper;       // 회원의 권한(role)정보를 조희
    }

    /* 회원 정보 조회 및 인증 */
    @Override
    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {

        // 회원 정보 조회
        MemberDTO member = memberMapper.findByMemberId(memberId);

        if (member == null) {
            throw new UsernameNotFoundException("회원 정보가 존재하지 않습니다: " + memberId);
        }

        // 회원 권한 조회
        List<AuthorityDTO> authorities = authMapper.findAuthorityByMemberCode(member.getMemberCode());

        // Spring Security에서 사용할 GrantedAuthority 변환
        List<GrantedAuthority> grantedAuthorities = authorities.stream()
                .map(auth -> new SimpleGrantedAuthority(auth.getRoleName()))
                .collect(Collectors.toList());

        // 회원 객체에 권한 정보 설정
        member.setAuthorities(grantedAuthorities);

        return member;
    }

    /* 아이디 중복 확인 (30일 제한 적용)  */
    public boolean isMemberIdDuplicate(String memberId) {
        MemberDTO member = memberMapper.findByMemberId(memberId);

        // 회원이 존재하지 않으면 중복 아님 (가입 가능)
        if (member == null) {
            return false;
        }

        // 탈퇴한 회원인지 확인 (WITHDRAWN 상태이면서 deleted_at이 30일 이내)
        if ("WITHDRAWN".equals(member.getStatus()) && member.getDeletedAt() != null) {
            LocalDateTime thirtyDaysAgo = LocalDateTime.now().minusDays(30);
            if (member.getDeletedAt().isAfter(thirtyDaysAgo)) {
                return true; // 30일 이내 탈퇴한 회원 → 중복 처리 (가입 불가)
            }
        }

        return true; // 활성화된 회원이면 중복 처리 (가입 불가)

    }

    /* 이메일 중복 확인 (30일 제한 적용) */
    public boolean isEmailDuplicate(String email) {
        MemberDTO member = memberMapper.findByEmail(email);

        if (member == null) {
            return false; // 사용 가능
        }

        // 탈퇴 회원이고 30일 이내라면 중복 처리 (가입 불가)
        if ("WITHDRAWN".equals(member.getStatus()) && member.getDeletedAt() != null) {
            LocalDateTime thirtyDaysAgo = LocalDateTime.now().minusDays(30);
            return member.getDeletedAt().isAfter(thirtyDaysAgo);
        }

        return true; // 기존 회원이 존재하면 중복 처리 (가입 불가)
    }


}

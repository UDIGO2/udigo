package com.udigo.hotel.member.model.service;

import com.udigo.hotel.member.model.dao.MemberMapper;
import com.udigo.hotel.member.model.dto.MemberDTO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberService {

    private final MemberMapper memberMapper;
    private final PasswordEncoder passwordEncoder;

    public MemberService(MemberMapper memberMapper, PasswordEncoder passwordEncoder) {
        this.memberMapper = memberMapper;
        this.passwordEncoder = passwordEncoder;
    }

    /** 아이디 중복 확인 */
    public boolean checkDuplicateId(String memberId) {
        return memberMapper.existsByMemberId(memberId);
    }

    /** 이메일 중복 확인 */
    public boolean checkDuplicateEmail(String email) {
        return memberMapper.existsByEmail(email);
    }

    /** 회원가입 처리 */
    public void signup(MemberDTO member, String confirmPassword) {
        // 비밀번호 확인
        if (!member.getPassword().equals(confirmPassword)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        // 아이디 중복 검사
        if (checkDuplicateId(member.getMemberId())) {
            throw new IllegalArgumentException("이미 사용 중인 아이디입니다.");
        }

        // 이메일 중복 검사
        if (checkDuplicateEmail(member.getEmail())) {
            throw new IllegalArgumentException("이미 사용 중인 이메일입니다.");
        }

        // 비밀번호 암호화
        member.setPassword(passwordEncoder.encode(member.getPassword()));

        // 회원 정보 저장
        memberMapper.insertMember(member);
        memberMapper.insertMemberRole(member.getMemberCode());
    }

    /** 회원 정보 수정 */
    public void update(MemberDTO member) {
        memberMapper.updateMember(member);
    }

    /** 회원 비밀번호 변경 */
    public void updatePassword(MemberDTO member, String newPassword) {
        String encodedPassword = passwordEncoder.encode(newPassword);
        memberMapper.updateMemberPassword(member.getMemberCode(), encodedPassword);
    }
}

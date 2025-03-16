package com.udigo.hotel.member.model.service;

import com.udigo.hotel.auth.model.service.EmailService;
import com.udigo.hotel.member.model.dao.MemberMapper;
import com.udigo.hotel.member.model.dto.MemberDTO;
import jakarta.mail.MessagingException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class MemberService {

    private final MemberMapper memberMapper;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;

    public MemberService(MemberMapper memberMapper, PasswordEncoder passwordEncoder, EmailService emailService) {
        this.memberMapper = memberMapper;
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
    }

    /** ✅ 회원가입 */
    public void signup(MemberDTO memberDTO) {
        if (memberDTO.getPassword() == null || memberDTO.getPassword().trim().isEmpty()) {
            throw new IllegalArgumentException("비밀번호를 입력해야 합니다.");
        }

        System.out.println("🔍 회원가입 데이터 (DB 저장 전): " + memberDTO.toString());

        // 비밀번호 암호화 후 저장
        String encodedPassword = passwordEncoder.encode(memberDTO.getPassword());
        memberDTO.setPassword(encodedPassword);
        System.out.println("🔐 비밀번호 암호화 완료");

        try {
            memberMapper.insertMember(memberDTO);
            System.out.println("✅ 회원 정보 DB 저장 완료: " + memberDTO.getMemberId());
        } catch (Exception e) {
            System.err.println("❌ 회원 정보 저장 실패: " + e.getMessage());
            throw new RuntimeException("회원가입 실패: " + e.getMessage());
        }
    }

    /** ✅ 이메일로 회원 조회 */
    public MemberDTO findByEmail(String email) {
        return memberMapper.findByEmail(email);
    }


    /** ✅ 아이디로 회원 조회 */
    public MemberDTO findByMemberId(String memberId) {
        return memberMapper.findByMemberId(memberId);
    }

    /** ✅ 회원 정보 수정 */
    @Transactional
    public void updateMember(MemberDTO memberDTO) {
        memberMapper.updateMember(memberDTO);
    }

    /** ✅ 이메일로 아이디 찾기 */
    public String findIdByEmail(String email) {
        return memberMapper.findIdByEmail(email);
    }

    /** ✅ 비밀번호 찾기 (임시 비밀번호 생성 후 저장) */
    @Transactional
    public String findPassword(String memberId, String email) {
        MemberDTO member = memberMapper.findByMemberIdAndEmail(memberId, email);

        if (member == null) {
            System.out.println("❌ 존재하지 않는 회원 정보: memberId = " + memberId + ", email = " + email);
            return null; // ✅ 컨트롤러에서 처리
        }

        // ✅ 13자리 임시 비밀번호 생성 (UUID 활용)
        String tempPassword = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 13);
        String encodedPassword = passwordEncoder.encode(tempPassword); // 암호화

        // ✅ DB에 임시 비밀번호 저장
        memberMapper.updatePassword(memberId, encodedPassword);
        System.out.println("🔐 임시 비밀번호 저장 완료: " + memberId);

        // ✅ 이메일 전송
        String subject = "[UDIGO] 임시 비밀번호 안내";
        String emailContent = "<h2>임시 비밀번호 안내</h2>" +
                "<p>안녕하세요, " + member.getMemberName() + "님.</p>" +
                "<p>요청하신 임시 비밀번호는 <strong>" + tempPassword + "</strong> 입니다.</p>" +
                "<p>로그인 후 반드시 새 비밀번호로 변경해주세요.</p>";

        try {
            emailService.sendEmail(email, subject, emailContent);
            System.out.println("📧 이메일 전송 완료: " + email);
        } catch (Exception e) {
            System.err.println("❌ 이메일 전송 실패: " + e.getMessage());
            throw new RuntimeException("이메일 전송 실패: " + e.getMessage());
        }

        return "임시 비밀번호가 이메일로 전송되었습니다.";
    }

    /** ✅ 비밀번호 변경 */
    @Transactional
    public void changePassword(String memberId, String newPassword) {
        if (newPassword == null || newPassword.trim().isEmpty()) {
            throw new IllegalArgumentException("새로운 비밀번호를 입력해야 합니다.");
        }

        String encodedPassword = passwordEncoder.encode(newPassword);
        try {
            memberMapper.updatePassword(memberId, encodedPassword);
            System.out.println("🔐 비밀번호 변경 완료: " + memberId);
        } catch (Exception e) {
            System.err.println("❌ 비밀번호 변경 실패: " + e.getMessage());
            throw new RuntimeException("비밀번호 변경 실패: " + e.getMessage());
        }
    }
}

package com.udigo.hotel.member.model.service;

import com.udigo.hotel.auth.model.service.EmailService;
import com.udigo.hotel.member.model.dao.MemberMapper;
import com.udigo.hotel.member.model.dto.MemberDTO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class MemberService {

    private final MemberMapper memberMapper;
    private final PasswordEncoder passwordEncoder;  // 비밀번호 암호화 객체
    private final EmailService emailService;        // 이메일 전송 서비스

    public MemberService(MemberMapper memberMapper, PasswordEncoder passwordEncoder, EmailService emailService) {
        this.memberMapper = memberMapper;
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
    }

    /* 회원가입 */
    public void signup(MemberDTO memberDTO) {
        if (memberDTO.getPassword() == null || memberDTO.getPassword().trim().isEmpty()) {
            throw new IllegalArgumentException("비밀번호를 입력해야 합니다.");
        }

        System.out.println("회원가입 데이터 (DB 저장 전): " + memberDTO.toString());

        // 비밀번호 암호화 후 저장
        String encodedPassword = passwordEncoder.encode(memberDTO.getPassword());
        memberDTO.setPassword(encodedPassword);
        System.out.println("비밀번호 암호화 완료");

        try {
            memberMapper.insertMember(memberDTO);
            System.out.println("회원 정보 DB 저장 완료: " + memberDTO.getMemberId());
        } catch (Exception e) {
            System.err.println("회원 정보 저장 실패: " + e.getMessage());
            throw new RuntimeException("회원가입 실패: " + e.getMessage());
        }
    }

    /* 이메일로 회원 조회 */
    public MemberDTO findByEmail(String email) {
        return memberMapper.findByEmail(email);
    }

    /* 아이디로 회원 조회 */
    public MemberDTO findByMemberId(String memberId) {
        MemberDTO member = memberMapper.findByMemberId(memberId);
        if (member == null) {
            System.out.println(" 회원 정보를 찾을 수 없습니다.");
        } else {
            System.out.println(" 조회된 회원 정보: " + member);
            System.out.println(" 이메일 값 확인: " + member.getEmail());
        }
        return member;
    }

    /* 회원 정보 수정 */
    @Transactional      // 트랜잭션이 필요한 메서드 (수정 중 오류 발생 시 롤백)
    public void updateMember(MemberDTO memberDTO) {
        memberMapper.updateMember(memberDTO);
    }

    /* 이메일로 아이디 찾기 */
    public String findIdByEmail(String email) {
        return memberMapper.findIdByEmail(email);
    }

    /* 비밀번호 찾기 (임시 비밀번호 생성 후 저장) */
    @Transactional
    public String findPassword(String memberId, String email) {
        MemberDTO member = memberMapper.findByMemberIdAndEmail(memberId, email);

        if (member == null) {
            System.out.println(" 존재하지 않는 회원 정보: memberId = " + memberId + ", email = " + email);
            return null;
        }

        /* 13자리 임시 비밀번호 생성
         * `UUID.randomUUID().toString()`을 사용하여 랜덤한 문자열을 생성하는 클래스
         * 보안상 강력한 난수값을 만들 때 사용됨 (임시 비밀번호 생성 시 활용)
         * */
        String tempPassword = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 13);
        String encodedPassword = passwordEncoder.encode(tempPassword);

        //  DB에 임시 비밀번호 저장
        memberMapper.updatePassword(memberId, encodedPassword);
        System.out.println(" 임시 비밀번호 저장 완료: " + memberId);

        //  이메일 전송
        String subject = "[UDIGO] 임시 비밀번호 안내";
        String emailContent = "<h2>임시 비밀번호 안내</h2>" +
                "<p>안녕하세요, " + member.getMemberName() + "님.</p>" +
                "<p>요청하신 임시 비밀번호는 <strong>" + tempPassword + "</strong> 입니다.</p>" +
                "<p>로그인 후 반드시 새 비밀번호로 변경해주세요.</p>";
        try {
            emailService.sendEmail(email, subject, emailContent);
            System.out.println(" 이메일 전송 완료: " + email);
        } catch (Exception e) {
            System.err.println(" 이메일 전송 실패: " + e.getMessage());
            throw new RuntimeException("이메일 전송 실패: " + e.getMessage());
        }

        return "임시 비밀번호가 이메일로 전송되었습니다.";
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

    /* 전체 회원 목록 가져오기 */
    public List<MemberDTO> getAllMembers() {
        return memberMapper.selectAllMembers();
    }

    public MemberDTO getMemberById(String memberId) {
        return memberMapper.selectMemberById(memberId);
    }

    /* 쿠폰 사용 처리 */
    @Transactional
    public void useCoupon(String memberId) {
        MemberDTO member = memberMapper.findByMemberId(memberId);

        if (member == null) {
            throw new RuntimeException("존재하지 않는 회원입니다.");
        }

        if (member.getCouponUsed()) {
            throw new RuntimeException("이미 사용된 쿠폰입니다.");
        }

        memberMapper.updateCouponUsed(memberId, true);
        System.out.println(" 쿠폰 사용 완료: " + memberId);
    }

    /* 쿠폰 사용 여부 확인 */
    public boolean checkCouponStatus(String memberId) {
        Integer couponUsed = memberMapper.getCouponStatus(memberId);
        return couponUsed != null && couponUsed == 1;
    }

    /* 비밀번호 변경 */
    public void updatePassword(String memberId, String newPassword) {
        if (memberId == null || newPassword == null) {
            throw new IllegalArgumentException("memberId 또는 newPassword가 null입니다.");
        }
        memberMapper.updatePassword(memberId, newPassword);
    }

    /* 회원 ID로 비밀번호 가져오기 */
    public String getPasswordByMemberId(String memberId) {
        return memberMapper.getPasswordByMemberId(memberId);
    }

    /* 회원 탈퇴 기능 */
    @Transactional
    public boolean withdrawMember(String memberId) {
        int result = memberMapper.updateWithdrawMember(memberId);
        return result > 0; //  업데이트 성공 여부 반환
    }

}

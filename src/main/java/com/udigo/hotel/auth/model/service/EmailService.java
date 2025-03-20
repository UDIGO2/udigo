package com.udigo.hotel.auth.model.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender; // 이메일을 전송하는 객체 (메일 서버와 연결)

    @Value("${spring.mail.username}")
    private String fromEmail;  // 발신자 이메일 (application.yml에서 가져옴)

    @Autowired
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    /*
     * 이메일을 전송하는 메서드
     * @param toEmail 수신자 이메일 주소
     * @param subject 이메일 제목
     * @param text 이메일 본문 내용 (HTML 지원)
     * @throws MessagingException 이메일 전송 중 예외가 발생할 경우 처리
     */
    public void sendEmail(String toEmail, String subject, String text) throws MessagingException {
        System.out.println("발신자 이메일: " + fromEmail);
        System.out.println("수신자 이메일: " + toEmail);
        System.out.println("이메일 제목: " + subject);

        try {
            // 이메일 메시지 객체 생성 (MIME 형식)
            MimeMessage message = mailSender.createMimeMessage();

            // 메시지를 구성할 수 있도록 도와주는 Helper 객체 생성
            MimeMessageHelper helper = new MimeMessageHelper(message, false, "UTF-8");

            // 이메일 설정
            helper.setFrom(fromEmail); // 발신자 설정
            helper.setTo(toEmail); // 수신자 설정
            helper.setSubject(subject); // 제목 설정
            helper.setText(text, true); // 본문 내용 설정 (true: HTML 형식 지원)

            // 이메일 전송
            mailSender.send(message);
            System.out.println("이메일 전송 성공!");

        } catch (MessagingException e) {
            System.err.println("이메일 전송 오류: " + e.getMessage());
            throw new RuntimeException("이메일 전송 실패", e);
        }
    }
}

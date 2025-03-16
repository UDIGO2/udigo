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

    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;  // 발신자 이메일 (application.yml에서 가져옴)

    @Autowired
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(String toEmail, String subject, String text) throws MessagingException {
        System.out.println("📧 발신자 이메일: " + fromEmail);
        System.out.println("📩 수신자 이메일: " + toEmail);
        System.out.println("📜 이메일 제목: " + subject);

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, false, "UTF-8");

            helper.setFrom(fromEmail);
            helper.setTo(toEmail);
            helper.setSubject(subject);
            helper.setText(text, true);

            mailSender.send(message);
            System.out.println("✅ 이메일 전송 성공!");

        } catch (MessagingException e) {
            System.err.println("❌ 이메일 전송 오류: " + e.getMessage());
            throw new RuntimeException("이메일 전송 실패", e);
        }
    }
}

package com.example.captchamaster.util;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class EmailUtil {
    @Value("${spring.mail.username}")
    private String from;
    @Resource
    private String htmlContent;  // HTML模板内容
    @Resource
    private JavaMailSender mailSender;

    public EmailUtil() {
    }

    public void sendCode(String to, String code) {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, "utf-8");

        try {
            helper.setTo(to);
            helper.setFrom(from);
            // 邮件主题
            String subject = "这是一条验证码";
            helper.setSubject(subject);
            htmlContent = htmlContent.replace("CODE", code);
            helper.setText(htmlContent, true);
            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
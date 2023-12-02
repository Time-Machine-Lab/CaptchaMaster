package com.example.captchamaster.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

@Component
public class EmailUtil {
    @Value("${mail.host}")
    private String host;  // 邮箱服务器主机名

    @Value("${mail.port}")
    private int port;  // 邮箱服务器端口号

    @Value("${mail.username}")
    private String username;  // 发件人邮箱地址

    @Value("${mail.password}")
    private String password;  // 发件人邮箱密码

    @Value("${mail.subject}")
    private String subject;  // 邮件主题

    @Value("${mail.html-content}")
    private String htmlContent;  // HTML模板内容

    private Properties properties;

    public EmailUtil(){
        properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
    }

    public boolean sendCode(String email, String code){
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // 创建MimeMessage对象
            MimeMessage message = new MimeMessage(session);

            // 设置发件人
            message.setFrom(new InternetAddress(username));

            // 设置收件人
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));

            // 设置主题
            message.setSubject(subject);

            // 创建Multipart对象，用于组合文本和附件
            Multipart multipart = new MimeMultipart();

            htmlContent = htmlContent.replace("验证码", code);

            // 创建HTML正文部分
            BodyPart htmlBodyPart = new MimeBodyPart();
            htmlBodyPart.setContent(htmlContent, "text/html");

            // 将HTML正文部分添加到Multipart对象中
            multipart.addBodyPart(htmlBodyPart);

            // 将Multipart对象设置为整个邮件的内容
            message.setContent(multipart);

            // 发送邮件
            Transport.send(message);

            System.out.println("邮件发送成功");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return true;
    }
}

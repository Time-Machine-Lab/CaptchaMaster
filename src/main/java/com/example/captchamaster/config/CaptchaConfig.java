package com.example.captchamaster.config;

import com.example.captchamaster.common.captcha.CommonCaptchaHandler;
import com.example.captchamaster.common.captcha.EmailCaptcha;
import com.example.captchamaster.common.captcha.ImageCaptcha;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class CaptchaConfig {
    public static String ENCODE = "1234567890abcdefghijklmnopqrstuvwxwzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @Value("${captcha.mail.code-length}")
    private int codeLength;

    @Bean
    public CommonCaptchaHandler<Map<String, String>, String> emailCaptcha(){
        return new EmailCaptcha(codeLength);
    }

    @Bean
    public CommonCaptchaHandler<Map<String, String>, String> imageCaptcha(){
        return new ImageCaptcha(codeLength);
    }
}

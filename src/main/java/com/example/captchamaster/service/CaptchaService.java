package com.example.captchamaster.service;

import com.example.captchamaster.common.captcha.CommonCaptchaHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Date 2023/12/4
 * @Author xiaochun
 */
@Component
public class CaptchaService {
    @Resource
    private CommonCaptchaHandler<Map<String, String>, String> emailCaptcha;

    @Resource
    private CommonCaptchaHandler<Map<String, String>, String> imageCaptcha;
    public Map<String, String> sendEmailCode(String to){
        return emailCaptcha.CaptchaCode(to);
    }

    public Map<String, String> imageCode(){
        return imageCaptcha.CaptchaCode(null);
    }
}

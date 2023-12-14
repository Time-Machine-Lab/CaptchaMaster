package com.example.captchamaster.common.captcha;


import com.example.captchamaster.util.CodeUtil;
import com.example.captchamaster.util.EmailUtil;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

public class EmailCaptcha extends CommonCaptchaHandler<Map<String, String>, String>{
    @Resource
    private EmailUtil emailUtil;

    public EmailCaptcha() {
        this(6);
    }

    public EmailCaptcha(int codeLength) {
        this.codeLength = codeLength;
    }

    @Override
    public Map<String, String> CaptchaCode(String email) {
        String code = CodeUtil.code(this.codeLength);
        emailUtil.sendCode(email, code);
        return Map.of("email", email, "code", code);
    }
}

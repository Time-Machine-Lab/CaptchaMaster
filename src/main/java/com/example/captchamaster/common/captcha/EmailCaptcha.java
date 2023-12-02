package com.example.captchamaster.common.captcha;

import com.example.CaptchaMaster.util.CodeUtil;
import com.example.CaptchaMaster.util.EmailUtil;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

public class EmailCaptcha extends CommonCaptchaHandler<Map<String, String>, String>{
    @Resource
    EmailUtil emailUtil;

    public EmailCaptcha() {
        this.code = CodeUtil.code();
    }

    public EmailCaptcha(int n) {
        this.code = CodeUtil.code(n);
    }

    @Override
    public Map<String, String> CaptchaCode(String email) {
        Map<String, String> map = new HashMap<>();
        map.put(email, this.code);
        emailUtil.sendCode(email, this.code);
        return map;
    }

}

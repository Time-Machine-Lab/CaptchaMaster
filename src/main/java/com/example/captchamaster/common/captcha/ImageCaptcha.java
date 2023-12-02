package com.example.captchamaster.common.captcha;

import com.example.CaptchaMaster.util.CodeUtil;

import java.util.List;
import java.util.Map;

public class ImageCaptcha extends CommonCaptchaHandler<Map<String, String>, String>{
    public ImageCaptcha() {
        this.code = CodeUtil.code();
    }

    public ImageCaptcha(int n){
        this.code = CodeUtil.code(n);
    }

    @Override
    public Map<String, String> CaptchaCode(String msg) {

        return null;
    }
}

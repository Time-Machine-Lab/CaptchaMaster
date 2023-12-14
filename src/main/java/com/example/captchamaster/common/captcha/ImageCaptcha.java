package com.example.captchamaster.common.captcha;

import com.example.captchamaster.util.CodeUtil;
import com.example.captchamaster.util.ImageUtil;

import javax.annotation.Resource;
import java.util.Map;

public class ImageCaptcha extends CommonCaptchaHandler<Map<String, String>, String>{
    @Resource
    ImageUtil imageUtil;

    public ImageCaptcha() {
        this.codeLength = 5;
    }

    public ImageCaptcha(int codeLength){
        this.codeLength = codeLength;
    }

    @Override
    public Map<String, String> CaptchaCode(String msg) {
        String code = CodeUtil.code(this.codeLength);
        return Map.of("base64",imageUtil.CodeToBase64(code), "code",code);
    }
}

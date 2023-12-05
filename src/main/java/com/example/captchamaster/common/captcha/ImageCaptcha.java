package com.example.captchamaster.common.captcha;

import com.example.captchamaster.util.CodeUtil;
import com.example.captchamaster.util.ImageUtil;

import javax.annotation.Resource;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ImageCaptcha extends CommonCaptchaHandler<Map<String, String>, String>{
    @Resource
    ImageUtil imageUtil;
    public ImageCaptcha() {
        this.code = CodeUtil.code();
    }

    public ImageCaptcha(int n){
        this.code = CodeUtil.code(n);
    }

    @Override
    public Map<String, String> CaptchaCode(String msg) {
        Map<String, String> map = new HashMap<>();
        map.put(imageUtil.CodeToBase64(this.code), this.code);
        return map;
    }
}

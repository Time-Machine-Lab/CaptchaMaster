package com.example.captchamaster.util;

import com.example.CaptchaMaster.config.CaptchaConfig;

import java.util.Random;

public class CodeUtil {
    public static String code(){
        return code(6);
    }

    public static String code(int n){
        Random random = new Random();
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < n; i++) code.append(CaptchaConfig.ENCODE.charAt(random.nextInt(58)));
        return code.toString();
    }
}

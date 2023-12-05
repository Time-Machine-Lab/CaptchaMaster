package com.example.captchamaster.common.captcha;

public interface CaptchaHandler<Res,Param> {
    Res CaptchaCode(Param param);
}

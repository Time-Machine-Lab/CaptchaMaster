package com.example.captchamaster.common.captcha;

import com.example.CaptchaMaster.util.CodeUtil;

abstract public class CommonCaptchaHandler<Res,Param> implements CaptchaHandler<Res,Param> {
    protected String code;
}

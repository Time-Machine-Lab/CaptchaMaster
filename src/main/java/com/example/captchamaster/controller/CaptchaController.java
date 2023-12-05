package com.example.captchamaster.controller;

import com.example.captchamaster.common.Result;
import com.example.captchamaster.service.CaptchaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Date 2023/12/4
 * @Author xiaochun
 */
@RestController
@RequestMapping("/captcha")
public class CaptchaController {
    @Resource
    CaptchaService captchaService;

    @GetMapping("/email")
    public Result<Map<String, String>> email(String to){
        return Result.success(captchaService.sendEmailCode(to));
    }

    @GetMapping("/image")
    public Result<Map<String, String>> image(){
        return Result.success(captchaService.imageCode());
    }
}

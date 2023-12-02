package com.example.captchamaster.config;

/**
 * @Date 2023/12/1
 * @Author xiaochun
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "email")
public class EmailConfig {
    @Value("${email.username}")
    private String username;
    @Value("${email.password}")
    private String password;
    @Value("${email.port}")
    private String port;
    @Value("${email.subject}")
    private String subject;
    @Value("${email.host}")
    private String host;
    @Value("${email.htmlContent}")
    private String htmlContent;

    // 省略 getter 和 setter 方法

    // 如果有需要进行类型转换的属性，可以在这里定义对应的方法
}


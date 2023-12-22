package com.example.captchamaster.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description
 * @Author welsir
 * @Date 2023/11/24 20:43
 */
@Getter
@AllArgsConstructor
public enum StatusConstEnum {
    /**
     * 成功
     */
    SUCCESS(200, "成功"),

    /**
     * 系统异常
     */
    SYSTEM_ERROR(500, "系统异常"),

    SEND_EMIAL_CODE_FAILED(418, "验证码发送失败"),

    ;

    /**
     * 状态码
     */
    private final Integer code;

    /**
     * 描述
     */
    private final String desc;
}

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

    /**
     * OSS文件下载失败
     */
    OSS_FILE_UPLOAD_ERROR(501,"文件上传至OSS失败"),

    /**
     * 获取bucket错误
     */
    QUERY_BUCKET_ERROR(502,"bucket获取失败");

    /**
     * 状态码
     */
    private final Integer code;

    /**
     * 描述
     */
    private final String desc;
}

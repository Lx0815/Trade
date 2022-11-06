package com.d.tradeserver.web.common.response;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author: Ding
 * @date: 2022/7/18 14:36
 * @description:
 * @modify:
 */


public enum ResponseCode {

    SUCCESS("00000", "成功"),
    FAIL("B0001", "系统异常"),

    USERNAME_EXIST("A0111", "用户名已存在"),

    CAPTCHA_ERROR("A0131", "验证码输入错误"),

    USERNAME_PASSWORD_ERROR("A0210", "用户名密码错误"),

    NO_DATA("A0301", "数据不存在"),
    NOT_LOGIN("A0302", "用户未登录"),

    SYSTEM_ERROR("B0001", "系统执行出错"),

    MAPPER_EXCEPTION("B0002", "mapper 层异常"),

    SERVICE_EXCEPTION("B0003", "service 层异常"),

    CONTROLLER_EXCEPTION("B0004", "controller 层异常"),

    ADD_EXCEPTION("B0011", "添加异常"),

    DELETE_EXCEPTION("B0012", "删除异常"),

    UPDATE_EXCEPTION("B0013", "更新异常");


    private final String code;

    private final String description;

    ResponseCode(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @JsonValue
    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}

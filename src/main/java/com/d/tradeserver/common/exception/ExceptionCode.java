package com.d.tradeserver.common.exception;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author: Ding
 * @date: 2022/7/18 14:36
 * @description:
 * @modify:
 */


public enum ExceptionCode {
    ;


    private final Integer code;

    private final String description;

    ExceptionCode(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    @JsonValue
    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}

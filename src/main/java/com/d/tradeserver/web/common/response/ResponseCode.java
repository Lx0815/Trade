package com.d.tradeserver.common.web.response;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author: Ding
 * @date: 2022/7/18 14:36
 * @description:
 * @modify:
 */


public enum ResponseCode {

    SUCCESS(20000),

    FAIL(20001);

    private final int code;

    ResponseCode(int code) {
        this.code = code;
    }

    @JsonValue
    public int getCode() {
        return code;
    }
}

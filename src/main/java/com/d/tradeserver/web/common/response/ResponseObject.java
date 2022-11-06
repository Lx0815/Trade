package com.d.tradeserver.web.common.response;

/**
 * @author: Ding
 * @date: 2022/10/16 19:46
 * @description:
 * @modify:
 */


public class ResponseObject {

    private ResponseCode code;

    private Object data;

    private String message;

    public ResponseObject() {
    }

    public ResponseObject(ResponseCode code, Object data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public ResponseCode getCode() {
        return code;
    }

    public ResponseObject setCode(ResponseCode code) {
        this.code = code;
        return this;
    }

    public Object getData() {
        return data;
    }

    public ResponseObject setData(Object data) {
        this.data = data;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResponseObject setMessage(String message) {
        this.message = message;
        return this;
    }
}

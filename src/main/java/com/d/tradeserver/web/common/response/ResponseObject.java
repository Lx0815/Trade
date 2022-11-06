package com.d.tradeserver.common.web.response;

/**
 * @author: Ding
 * @date: 2022/10/16 19:46
 * @description:
 * @modify:
 */


public class ResponseObject {

    private ResponseCode code;

    private DTO dto;

    private String message;

    public ResponseObject() {
    }

    public ResponseObject(ResponseCode code, DTO dto, String message) {
        this.code = code;
        this.dto = dto;
        this.message = message;
    }

    public ResponseCode getCode() {
        return code;
    }

    public ResponseObject setCode(ResponseCode code) {
        this.code = code;
        return this;
    }

    public DTO getDto() {
        return dto;
    }

    public ResponseObject setDto(DTO dto) {
        this.dto = dto;
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

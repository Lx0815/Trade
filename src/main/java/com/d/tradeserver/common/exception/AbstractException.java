package com.d.tradeserver.common.exception;

import com.d.tradeserver.web.common.response.ResponseCode;

/**
 * @author: Ding
 * @date: 2022/10/29 12:29
 * @description:
 * @modify:
 */


public abstract class AbstractException extends RuntimeException implements BaseException {

    private ResponseCode code;


    public AbstractException(ResponseCode code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    @Override
    public ResponseCode getExceptionCode() {
        return code;
    }

    @Override
    public void setExceptionCode(ResponseCode code) {
        this.code = code;
    }
}

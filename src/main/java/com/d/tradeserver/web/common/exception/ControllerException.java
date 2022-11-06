package com.d.tradeserver.web.common.exception;

import com.d.tradeserver.common.exception.AbstractException;
import com.d.tradeserver.web.common.response.ResponseCode;


/**
 * @author: Ding
 * @date: 2022/10/29 14:34
 * @description:
 * @modify:
 */


public class ControllerException extends AbstractException {

    public ControllerException(ResponseCode code, Throwable cause) {
        this(code, cause.getMessage(), cause);
    }

    public ControllerException(ResponseCode code, String message) {
        this(code, message, null);
    }

    public ControllerException(ResponseCode code, String message, Throwable cause) {
        super(code, message, cause);
    }
}

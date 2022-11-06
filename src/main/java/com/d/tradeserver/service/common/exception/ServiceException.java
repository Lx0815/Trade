package com.d.tradeserver.service.common.exception;

import com.d.tradeserver.common.exception.AbstractException;
import com.d.tradeserver.web.common.response.ResponseCode;

/**
 * @author: Ding
 * @date: 2022/10/29 12:03
 * @description:
 * @modify:
 */


public class ServiceException extends AbstractException {

    public ServiceException(ResponseCode code, String message) {
        this(code, message, null);
    }

    public ServiceException(ResponseCode code, String message, Throwable cause) {
        super(code, message, cause);
    }

}

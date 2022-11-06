package com.d.tradeserver.mapper.common.exception;

import com.d.tradeserver.common.exception.AbstractException;
import com.d.tradeserver.web.common.response.ResponseCode;

/**
 * @author: Ding
 * @date: 2022/10/29 12:25
 * @description:
 * @modify:
 */


public class MapperException extends AbstractException {

    public MapperException(ResponseCode code, Throwable cause) {
        this(code, cause.getMessage(), cause);
    }

    public MapperException(ResponseCode code, String message, Throwable cause) {
        super(code, message, cause);
    }
}

package com.d.tradeserver.mapper.common.exception;

import com.d.tradeserver.common.exception.AbstractException;
import com.d.tradeserver.common.exception.BaseException;
import com.d.tradeserver.common.exception.ExceptionCode;

/**
 * @author: Ding
 * @date: 2022/10/29 12:25
 * @description:
 * @modify:
 */


public class DAOException extends AbstractException {

    public DAOException(ExceptionCode exceptionCode, Throwable cause) {
        this(exceptionCode, cause.getMessage(), cause);
    }
    public DAOException(ExceptionCode exceptionCode, String message, Throwable cause) {
        super(exceptionCode, message, cause);
    }
}

package com.d.tradeserver.web.common.exception;

import com.d.tradeserver.common.constant.Constants;
import com.d.tradeserver.common.exception.AbstractException;
import com.d.tradeserver.common.utils.ResponseUtils;
import com.d.tradeserver.mapper.common.exception.MapperException;
import com.d.tradeserver.service.common.exception.ServiceException;
import com.d.tradeserver.web.common.response.ResponseCode;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author: Ding
 * @date: 2022/10/29 14:48
 * @description:
 * @modify:
 */


@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(RuntimeException.class)
    public Object otherExceptionHandler(RuntimeException e) {
        return getDefaultResponse(new AbstractException(ResponseCode.SYSTEM_ERROR, e.getMessage(), e) {
        });
    }

    @ExceptionHandler({MapperException.class, ServiceException.class, ControllerException.class})
    private Object getDefaultResponse(AbstractException e) {
        String message = e.getMessage();
        logger.error(message);
        e.printStackTrace();
        if (StringUtils.isBlank(message)) {
            message = Constants.SERVER_EXCEPTION;
        }
        return ResponseUtils.createResponse(e.getExceptionCode(), Constants.EMPTY_ARRAY, message);
    }
}

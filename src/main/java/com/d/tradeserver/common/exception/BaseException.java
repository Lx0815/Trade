package com.d.tradeserver.common.exception;

import com.d.tradeserver.web.common.response.ResponseCode;

/**
 * @author: Ding
 * @date: 2022/7/18 14:36
 * @description:
 * @modify:
 */


public interface BaseException {

    ResponseCode getExceptionCode();

    void setExceptionCode(ResponseCode code);
}

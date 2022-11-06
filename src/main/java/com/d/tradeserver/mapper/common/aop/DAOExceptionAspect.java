package com.d.tradeserver.mapper.common.aop;

import com.d.tradeserver.mapper.common.exception.MapperException;
import com.d.tradeserver.web.common.response.ResponseCode;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author: Ding
 * @date: 2022/10/29 12:14
 * @description:
 * @modify:
 */


@Aspect
@Component
public class DAOExceptionAspect {

    @Pointcut("execution(* com.d.tradeserver.mapper..*.*(..))")
    public void allMapperMethod() {
    }

    @AfterThrowing(value = "allMapperMethod()", throwing = "throwable")
    public void throwDAOException(Throwable throwable) throws MapperException {
        throw new MapperException(ResponseCode.MAPPER_EXCEPTION, throwable);
    }
}

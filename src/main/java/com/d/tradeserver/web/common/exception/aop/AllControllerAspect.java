package com.d.tradeserver.web.common.aop;

import com.d.tradeserver.common.utils.MyPairUtils;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author: Ding
 * @date: 2022/10/28 10:26
 * @description:
 * @modify:
 */


@Aspect
@Component
public class AllControllerAspect {

    @Pointcut("execution(* com.d.tradeserver.web..*Controller.*(..))")
    public void allControllerMethod() {
    }

    @After("allControllerMethod()")
    public void afterAdvice() {
        MyPairUtils.putBack();
    }

}

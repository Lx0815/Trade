package com.d.tradeserver.web.common.interceptor;

import com.d.tradeserver.common.utils.ResponseUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: Ding
 * @date: 2022/10/27 16:52
 * @description:
 * @modify:
 */

public class ResponseObjectInterceptor implements HandlerInterceptor {

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        ResponseUtils.putBack();
    }
}

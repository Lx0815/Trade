package com.d.tradeserver.web.common.interceptor;

import com.d.tradeserver.common.constant.Constants;
import com.d.tradeserver.web.common.response.ResponseCode;
import com.d.tradeserver.web.common.response.ResponseObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * @description:
 * @author: Ding
 * @version: 1.0
 * @createTime: 2022-11-05 22:25:41
 * @modify:
 */

//@Component
public class LoginInterceptor implements HandlerInterceptor {

    private ObjectMapper objectMapper;
//    @Autowired
    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if (! ObjectUtils.isEmpty(session.getAttribute(Constants.SESSION_KEY_CURRENT_USER))) {
            return true;
        }
        response.setContentType("application/json");
        response.setStatus(200);
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        PrintWriter writer = response.getWriter();
        ResponseObject responseObject = new ResponseObject()
                .setCode(ResponseCode.NOT_LOGIN)
                        .setData(Constants.EMPTY_ARRAY)
                                .setMessage(Constants.NOT_LOGIN);
        writer.write(objectMapper.writeValueAsString(responseObject));
        return false;
    }
}
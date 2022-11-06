package com.d.tradeserver.web.common.annotation.annotationHandler;

import com.d.tradeserver.web.common.annotation.RequestParamObject;
import com.d.tradeserver.web.common.exception.ControllerException;
import com.d.tradeserver.web.common.response.ResponseCode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.Map;

@Component
public class RequestParamObjectResolver implements HandlerMethodArgumentResolver {

    private ObjectMapper objectMapper;
    @Autowired
    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(RequestParamObject.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        Object result;
        String[] values;
        Object value = null;
        String fieldName;
        Class<?> fieldType;
        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
        if (ObjectUtils.isEmpty(request)) {
            throw new ControllerException(ResponseCode.FAIL, "request 对象为 null");
        }
        Class<?> parameterType = parameter.getParameterType();
        Map<String, String[]> parameterMap = request.getParameterMap();

        if (ObjectUtils.isEmpty(parameterMap)) return null;
        Object instance = parameterType.newInstance();
        Field[] fields = parameterType.getDeclaredFields();
        AccessibleObject.setAccessible(fields, true);
        for (Field field : fields) {
            fieldName = field.getName();
            fieldType = field.getType();
            values = parameterMap.get(fieldName);
            if (ObjectUtils.isEmpty(values)) continue;
            if (values.length > 1) {
                value = objectMapper.readValue(objectMapper.writeValueAsString(values), fieldType);
            } else if (! ObjectUtils.nullSafeEquals("", values[0])) {
                value = objectMapper.readValue(objectMapper.writeValueAsString(values[0]), fieldType);
            } else {
                value = null;
            }
            ReflectionUtils.findMethod(parameterType, "set" + StringUtils.capitalize(fieldName), fieldType);
            field.set(instance, value);
        }
        return instance;
    }
}

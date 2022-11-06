package com.d.tradeserver.common.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface MultiParameterBody {

    /**
     * 与参数名称对应的 JSON 对象属性名
     */
    String value();


    /**
     * 是否为必要参数。默认为 true
     */
    boolean require() default true;

}

package com.d.tradeserver.web.common.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface MultiRequestBody {

    /**
     * 与参数名称对应的 JSON 对象属性名
     */
    String value() default "";


    /**
     * 是否为必要参数。默认为 true
     */
    boolean required() default true;


    /**
     * 当 value 的值或者参数名不匹配时，是否允许解析最外层属性得到该对象
     */
    boolean parseAllFields() default true;
}

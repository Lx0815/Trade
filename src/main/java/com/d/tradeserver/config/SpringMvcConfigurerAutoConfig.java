package com.d.tradeserver.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;

/**
 * @author: Ding
 * @date: 2022/10/27 23:59
 * @description:
 * @modify:
 */


@ConditionalOnClass(WebMvcConfig.class)
public class SpringMvcConfigurerAutoConfig {

    @Bean
    @ConditionalOnMissingClass
    public WebMvcConfig webMvcConfig() {
        return new WebMvcConfig();
    }

}

package com.d.tradeserver.config;

import com.d.tradeserver.web.common.annotation.annotationHandler.RequestParamObjectResolver;
import com.d.tradeserver.web.common.interceptor.ResponseObjectInterceptor;
import com.d.tradeserver.web.common.annotation.annotationHandler.MultiParameterBodyResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * @author: Ding
 * @date: 2022/10/27 23:56
 * @description:
 * @modify:
 */


public class WebMvcConfig implements WebMvcConfigurer {


    private MultiParameterBodyResolver multiParameterBodyResolver;
    @Autowired
    public void setMultiParameterBodyResolver(MultiParameterBodyResolver multiParameterBodyResolver) {
        this.multiParameterBodyResolver = multiParameterBodyResolver;
    }


    private RequestParamObjectResolver requestParamObjectResolver;
    @Autowired
    public void setRequestParamObjectResolver(RequestParamObjectResolver requestParamObjectResolver) {
        this.requestParamObjectResolver = requestParamObjectResolver;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:7979")
                .allowedMethods(GET.name(), HEAD.name(), POST.name(), PUT.name(), PATCH.name(),
                        DELETE.name(), OPTIONS.name(), TRACE.name())
                .allowCredentials(true)
                .maxAge(3600)
                .allowedHeaders("*");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ResponseObjectInterceptor()).addPathPatterns("/**");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(multiParameterBodyResolver);
        resolvers.add(requestParamObjectResolver);
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        MappingJackson2HttpMessageConverter JacksonConverter = new MappingJackson2HttpMessageConverter();
        ArrayList<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_JSON);
        JacksonConverter.setSupportedMediaTypes(mediaTypes);
        JacksonConverter.setDefaultCharset(StandardCharsets.UTF_8);
        converters.add(JacksonConverter);
    }

}

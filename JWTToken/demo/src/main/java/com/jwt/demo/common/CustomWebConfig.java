package com.jwt.demo.common;

import com.jwt.demo.config.JWTInterceptor;
import com.jwt.demo.dto.RequestMeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class CustomWebConfig extends WebMvcConfigurerAdapter
{
    @Autowired
    JWTInterceptor jwtInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor);
    }

    @Bean
    @RequestScope
    public RequestMeta getRequestMeta()
    {
        return new RequestMeta();
    }
    @Bean
    public JWTInterceptor jwtInterceptor()
    {
        return new JWTInterceptor(getRequestMeta());
    }


}

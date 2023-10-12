package com.jwt.demo.config;


import com.jwt.demo.dto.RequestMeta;
import com.jwt.demo.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JWTInterceptor extends HandlerInterceptorAdapter
{
    @Autowired
    JwtUtils jwtUtils;
    RequestMeta requestMeta;

    public JWTInterceptor(RequestMeta requestMeta)
    {
        this.requestMeta = requestMeta;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String auth = request.getHeader("Authorization");
        if(!(request.getRequestURI().contains("login")||request.getRequestURI().contains("signup")))
        {
            Claims claims= jwtUtils.verify(auth);
            requestMeta.setUserName(claims.get("name").toString());
            requestMeta.setUserId(Long.valueOf(claims.getIssuer()));
            requestMeta.setUserType(claims.get("type").toString());
            requestMeta.setEmailId(claims.get("emailId").toString());


        }
        return super.preHandle(request, response, handler);
    }
}

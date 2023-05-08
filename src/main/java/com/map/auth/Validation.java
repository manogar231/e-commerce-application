package com.map.auth;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Aspect
@Configuration
public class Validation {

    @Autowired
    ValidationImpl jwtAuthorizationImpl;

    @Autowired
    HttpServletRequest request;

    @Before("@annotation(authorizer) && args(..)")
    public void authorize(JoinPoint joinPoint, ValidationAnnotation authorizer) {
        if (request == null) {
            throw new RuntimeException("request should be HttpServletRequestType");
        }
        String authorizationHeader = request.getHeader("Authorization");
        if (!authorizer.required() && Objects.isNull(authorizationHeader)) {
            return;
        }
        String id = jwtAuthorizationImpl.authorize(authorizationHeader);
        request.setAttribute("id", id);
    }
}


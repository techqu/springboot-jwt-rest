package com.quguang.springbootjwtdemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quguang.springbootjwtdemo.common.ResultResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.lang.model.type.ErrorType;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by quguang on 2018/6/24
 */
public class JWTAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        String reason = "统一处理，原因："+authException.getMessage();
        response.getWriter().write(new ObjectMapper().writeValueAsString(ResultResponse.createResultResponse(String.valueOf(HttpServletResponse.SC_FORBIDDEN),reason)));
    }
}

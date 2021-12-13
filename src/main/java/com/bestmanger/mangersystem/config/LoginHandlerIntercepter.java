package com.bestmanger.mangersystem.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author liangrunyong
 * @create 2021-08-1810:02
 */
public class LoginHandlerIntercepter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登录成功之后，有了session
        Object object = request.getSession().getAttribute("account");//request获取session对象的方法
        if (object == null) {
            response.sendRedirect("/index.html");
            return false;
        } else {
            return true;
        }
    }
}

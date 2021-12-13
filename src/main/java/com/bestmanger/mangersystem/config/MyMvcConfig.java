package com.bestmanger.mangersystem.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author liangrunyong
 * @create 2021-07-3018:17
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("").setViewName("index");
        registry.addViewController("index.html").setViewName("index");
        registry.addViewController("/test").setViewName("test");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerIntercepter()).addPathPatterns("/**")
                .excludePathPatterns("/index.html", "/", "/test", "/api/**", "/images/**", "/lib/**", "/page/**", "/js/**", "/css/*", "/mangerLogin");//默认不拦截css和JavaScript，但拦截其它静态资源
        //拦截结果是自动回到登录页面而非报错
    }
}

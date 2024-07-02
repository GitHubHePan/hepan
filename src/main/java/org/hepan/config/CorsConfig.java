package org.hepan.config;


import org.hepan.handler.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Resource
    LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/auth/login")
                .order(1);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //支持所有接口
        registry.addMapping("/**")
                //是否发送Cookie
                .allowCredentials(true)
                //支持域
                .allowedOriginPatterns("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")
                .exposedHeaders("*");
    }
}
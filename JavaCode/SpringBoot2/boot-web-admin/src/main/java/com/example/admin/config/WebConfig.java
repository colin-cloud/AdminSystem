package com.example.admin.config;

import com.example.admin.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 小白学java
 * @version 3.0
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).
                addPathPatterns("/**"). // 静态资源也被拦截
                excludePathPatterns("/", "/login", "/index",
                "/css/**", "/fonts/**", "/images/**", "/js/**"); // 放行的请求
    }
}

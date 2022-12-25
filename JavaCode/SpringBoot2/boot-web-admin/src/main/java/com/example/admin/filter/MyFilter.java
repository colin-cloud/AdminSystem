package com.example.admin.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author 小白学java
 * @version 3.0
 */
@Slf4j
//@WebFilter(urlPatterns = {"/css/*", "images/*"})
public class MyFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("MyFilter初始化完成");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("MyFilter执行拦截");
    }

    @Override
    public void destroy() {
        log.info("MyFilter销毁");
    }
}

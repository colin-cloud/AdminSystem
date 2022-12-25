package com.example.admin.config;

import com.example.admin.filter.MyFilter;
import com.example.admin.servlet.MyServlet;
import com.example.listener.MyListener;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author 小白学java
 * @version 3.0
 */
@Configuration(proxyBeanMethods = true)
public class RegisterConfig {

    @Bean
    public ServletRegistrationBean myServlet() {
        MyServlet myServlet = new MyServlet();
        return new ServletRegistrationBean(myServlet, "/myServlet");
    }

    @Bean
    public FilterRegistrationBean myFilter() {
        MyFilter myFilter = new MyFilter();
        FilterRegistrationBean<MyFilter> filterBean = new FilterRegistrationBean<>(myFilter);
        filterBean.setUrlPatterns(Arrays.asList("/myServlet"));
        return filterBean;
    }

    @Bean
    public ServletListenerRegistrationBean myListener() {
        MyListener myListener = new MyListener();
        return new ServletListenerRegistrationBean(myListener);
    }
}

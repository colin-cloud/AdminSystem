package com.example.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author 小白学java
 * @version 3.0
 */
@Slf4j
//@WebListener
public class MyListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("监听器监听销毁过程");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //监听初始化过程
        log.info("监听器监听初始化过程");
    }
}

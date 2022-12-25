package com.company1.test;

import com.company1.config.SpringConfig;
import com.company1.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 小白学java
 * @version 3.0
 */
public class TestDemo {

    @Test
    public void testService() {
        ApplicationContext context = new ClassPathXmlApplicationContext("annotations.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }

    @Test
    public void testService1() {
        //完全注解开发
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }
}

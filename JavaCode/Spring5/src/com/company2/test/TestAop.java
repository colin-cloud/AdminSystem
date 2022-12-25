package com.company2.test;

import com.company2.aopanno.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 小白学java
 * @version 3.0
 */
public class TestAop {

    @Test
    public void testAopAnno() {
        ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
        User user = context.getBean("user", User.class);
        user.add();
    }
}

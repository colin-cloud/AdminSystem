package com.company.test;

import com.company.autowire.Emp;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 小白学java
 * @version 3.0
 */
public class TestAuto {

    @Test
    public void testAuto() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);
    }
}

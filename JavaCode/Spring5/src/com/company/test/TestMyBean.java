package com.company.test;

import com.company.collectiontype.Course;
import com.company.factorybean.MyBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 小白学java
 * @version 3.0
 */
public class TestMyBean {

    @Test
    public void testMyBean() {
        ApplicationContext context = new ClassPathXmlApplicationContext("mybean.xml");
        Course course1 = context.getBean("myBean", Course.class);
        Course course2 = context.getBean("myBean", Course.class);
        System.out.println(course1.hashCode());
        System.out.println(course2.hashCode());
    }
}

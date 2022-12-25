package com.company.test;

import com.company.bean.Employee;
import com.company.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 小白学java
 * @version 3.0
 */
public class TestBean {

    @Test
    public void testAdd() {
        //加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        //得到对象实例
        UserService userService = context.getBean("userService", UserService.class);
        //调用方法
        userService.add();
    }

    @Test
    public void testBean() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        Employee emp = context.getBean("emp", Employee.class);
        System.out.println(emp);
    }
}

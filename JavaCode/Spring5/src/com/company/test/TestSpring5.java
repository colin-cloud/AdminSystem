package com.company.test;

import com.company.Book;
import com.company.Orders;
import com.company.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.annotation.Order;

/**
 * @author 小白学java
 * @version 3.0
 */
public class TestSpring5 {

    @Test
    public void testAdd() {
        //1. 加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        //2. 获取配置创建的对象
        User user = context.getBean("user", User.class);
        //3. 调用方法
        user.add();
    }

    @Test
    public void testBook() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        Book book = context.getBean("book", Book.class);
        System.out.println(book);
        Book book1 = context.getBean("book1", Book.class);
        System.out.println(book1);
        Book book2 = context.getBean("book2", Book.class);
        System.out.println(book2);
    }

    @Test
    public void testOrders() {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
////        Orders orders = context.getBean("orders", Orders.class);
////        System.out.println(orders);
//
//        Orders orders1 = context.getBean("orders1", Orders.class);
//        System.out.println(orders1);
////        手动销毁
//        context.close();

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("mybeanpost.xml");
        Orders orders = context.getBean("orders", Orders.class);
        System.out.println(orders);
        context.close();
    }
}

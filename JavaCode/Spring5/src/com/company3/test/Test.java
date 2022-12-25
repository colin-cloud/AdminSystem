package com.company3.test;

import com.company3.entity.User;
import com.company3.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;


/**
 * @author 小白学java
 * @version 3.0
 */
public class Test {

    @org.junit.Test
    public void testAdd() {
        ApplicationContext context = new ClassPathXmlApplicationContext("mysql.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.add(2, "wangwu", "jia");
    }
    @org.junit.Test
    public void testAddList() {
        ApplicationContext context = new ClassPathXmlApplicationContext("mysql.xml");
        UserService userService = context.getBean("userService", UserService.class);
        List<Object[]> users = new ArrayList<>();
        users.add(new Object[]{1, "xiao", "liang"});
        users.add(new Object[]{2, "chen", "liang"});
        users.add(new Object[]{3, "xi", "liang"});
        userService.addList(users);
    }
    @org.junit.Test
    public void testUpdateList() {
        ApplicationContext context = new ClassPathXmlApplicationContext("mysql.xml");
        UserService userService = context.getBean("userService", UserService.class);
        List<Object[]> users = new ArrayList<>();
        users.add(new Object[]{"xiaoup", "sqlliang", 1});
        users.add(new Object[]{"chenup", "sqlliang", 2});
        users.add(new Object[]{"xiup", "sqlliang", 3});
        userService.updateList(users);
    }
    @org.junit.Test
    public void testUpdate() {
        ApplicationContext context = new ClassPathXmlApplicationContext("mysql.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.update(2, "xiaowang", "j");
    }

    @org.junit.Test
    public void testDelete() {
        ApplicationContext context = new ClassPathXmlApplicationContext("mysql.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.delete(2);
    }

    @org.junit.Test
    public void testDeleteList() {
        ApplicationContext context = new ClassPathXmlApplicationContext("mysql.xml");
        UserService userService = context.getBean("userService", UserService.class);
        List<Object[]> users = new ArrayList<>();
        users.add(new Object[]{1});
        users.add(new Object[]{2});
        users.add(new Object[]{3});
        userService.deleteList(users);
    }

    @org.junit.Test
    public void testQueryAll() {
        ApplicationContext context = new ClassPathXmlApplicationContext("mysql.xml");
        UserService userService = context.getBean("userService", UserService.class);
        int i = userService.queryAll();
        System.out.println(i);
    }

    @org.junit.Test
    public void testQueryUser() {
        ApplicationContext context = new ClassPathXmlApplicationContext("mysql.xml");
        UserService userService = context.getBean("userService", UserService.class);
        User user = userService.queryUser(1);
        System.out.println(user);
    }

    @org.junit.Test
    public void testQueryUsers() {
        ApplicationContext context = new ClassPathXmlApplicationContext("mysql.xml");
        UserService userService = context.getBean("userService", UserService.class);
        List<User> liang = userService.queryUsers("liang");
        System.out.println(liang);
    }
}

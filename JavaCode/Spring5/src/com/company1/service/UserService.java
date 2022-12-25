package com.company1.service;

import com.company1.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author 小白学java
 * @version 3.0
 */

//注解的方式创建对象
//value 值可以省略不写默认值是类首字母小写
@Component(value = "userService")
public class UserService {

//    @Autowired
//    @Qualifier(value = "userDaoImpl1")
//    private UserDao userDao;

    @Resource(name = "userDaoImpl1")
    private UserDao userDao;
    //实现普通属性的注入
    @Value(value = "小王")
    private String name;


    public void add() {
        System.out.println("service add()...");
        userDao.add();
        System.out.println(name);
    }
}

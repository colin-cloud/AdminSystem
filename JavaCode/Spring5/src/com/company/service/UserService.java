package com.company.service;

import com.company.dao.UserDao;
import com.company.impl.UserDaoImpl;

/**
 * @author 小白学java
 * @version 3.0
 */
public class UserService {

    private UserDao userDao;

    public void add() {
        System.out.println("Service add()....");
//        //原始方式
//        //创建UserDao对象
//        UserDao userDao = new UserDaoImpl();
//        userDao.update();
        userDao.update();
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}

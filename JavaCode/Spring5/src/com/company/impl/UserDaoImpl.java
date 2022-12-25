package com.company.impl;

import com.company.dao.UserDao;

/**
 * @author 小白学java
 * @version 3.0
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void update() {
        System.out.println("Dao update()...");
    }
}

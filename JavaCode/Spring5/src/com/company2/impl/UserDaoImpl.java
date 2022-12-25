package com.company2.impl;

import com.company2.dao.UserDao;

/**
 * @author 小白学java
 * @version 3.0
 */
public class UserDaoImpl implements UserDao {
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public String update(String id) {
        return id;
    }
}

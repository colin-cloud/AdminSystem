package com.company1.dao;

import org.springframework.stereotype.Repository;

/**
 * @author 小白学java
 * @version 3.0
 */

@Repository(value = "userDaoImpl1")
public class UserDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("add().....");
    }
}

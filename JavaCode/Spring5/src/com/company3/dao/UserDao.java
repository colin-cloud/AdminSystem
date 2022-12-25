package com.company3.dao;

import com.company3.entity.User;

import java.util.List;

/**
 * @author 小白学java
 * @version 3.0
 */
public interface UserDao {

    public void add(User user);

    public void addList(List<Object[]> users);

    public void delete(int id);

    public void deleteList(List<Object[]> users);

    public void update(User user);

    public void updateList(List<Object[]> users);

    public int queryAll();

    public User queryUser(int id);

    public List<User> queryUsers(String status);
}

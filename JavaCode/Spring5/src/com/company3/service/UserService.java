package com.company3.service;

import com.company3.dao.UserDao;
import com.company3.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 小白学java
 * @version 3.0
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public void add(int id, String name, String status) {
        User user = new User(id, name, status);
        userDao.add(user);
    }

    public void addList(List<Object[]> users) {
        userDao.addList(users);
    }

    public void delete(int id) {
        userDao.delete(id);
    }

    public void deleteList(List<Object[]> users) {
        userDao.deleteList(users);
    }

    public void update(int id, String name, String status) {
        User user = new User(id, name, status);
        userDao.update(user);
    }

    public void updateList(List<Object[]> users) {
        userDao.updateList(users);
    }

    public int queryAll() {
        return userDao.queryAll();
    }

    public User queryUser(int id) {
        return userDao.queryUser(id);
    }

    public List<User> queryUsers(String status) {
        return userDao.queryUsers(status);
    }
}

package com.colin.springboot.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.colin.springboot.entity.User;
import com.colin.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 小白学java
 * @version 3.0
 */

@Service
public class UserService extends ServiceImpl<UserMapper, User> {

    /**
     *
     */
    @Autowired
    private UserMapper userMapper;

    public int add(User user) {
        if (user.getId() == null) {
            return userMapper.add(user);
        } else {
            return userMapper.update(user);
        }
    }

    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }

    public Integer delete(Integer id) {
        return userMapper.delete(id);
    }

    public List<User> getUsersByPage(Integer pageNum, Integer pageSize, String username, String address) {
        return userMapper.getUsersByPage(pageNum, pageSize, username, address);
    }

    public Integer getTotal() {
        return userMapper.getTotal();
    }


    //mybatis-plus 实现方式
    public boolean saveUser(User user) {
        if (user.getId() == null) {
            return save(user);
        } else {
            return updateById(user);
        }
    }
}

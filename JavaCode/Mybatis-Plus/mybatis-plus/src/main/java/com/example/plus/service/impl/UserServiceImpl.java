package com.example.plus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.plus.bean.User;
import com.example.plus.mapper.UserMapper;
import com.example.plus.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author 小白学java
 * @version 3.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}

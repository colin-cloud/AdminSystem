package com.example.plus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.plus.bean.User;
import com.example.plus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 小白学java
 * @version 3.0
 */
@SpringBootTest
public class MybatisPluginTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void testPage() {
        Page<User> page = new Page<>(1, 3);
        Page<User> userPage = userMapper.selectPage(page, null);
        System.out.println(userPage);
    }

    @Test
    public void testPageVo() {
        Page<User> page = new Page(1, 3);
        Page<User> userPage = userMapper.selectPageVo(page, 20);
        System.out.println(userPage.getRecords());
    }
}

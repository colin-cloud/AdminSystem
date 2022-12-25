package com.example.plus;

import com.example.plus.bean.User;
import com.example.plus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 小白学java
 * @version 3.0
 */
@SpringBootTest
public class MybatisPlusServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testGetCount() {
        long count = userService.count();
        System.out.println(count);
    }

    @Test
    public void testSaveMul() {
        List<User> userList = new ArrayList<>();
        userList.add(new User(null, "李四", 11, "2243@qq.com", null));
        boolean saveBatch = userService.saveBatch(userList);
        System.out.println(saveBatch);
    }
}

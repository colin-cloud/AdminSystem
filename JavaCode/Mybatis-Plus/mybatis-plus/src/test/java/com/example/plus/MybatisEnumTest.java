package com.example.plus;

import com.example.plus.bean.User;
import com.example.plus.enums.SexEnum;
import com.example.plus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 小白学java
 * @version 3.0
 */
@SpringBootTest
public class MybatisEnumTest {

    @Autowired
    private UserMapper mapper;

    @Test
    public void test01() {
        User user = new User();
        user.setName("admin");
        user.setAge(33);
        user.setEmail("wang@qq.com");
        user.setSex(SexEnum.MALE);
        int insert = mapper.insert(user);
        System.out.println(insert);
    }
}

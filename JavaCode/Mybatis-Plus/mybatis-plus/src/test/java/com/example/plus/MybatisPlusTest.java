package com.example.plus;

import com.example.plus.bean.User;
import com.example.plus.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 小白学java
 * @version 3.0
 */
@SpringBootTest
@Slf4j
public class MybatisPlusTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectLists() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    @Test
    public void testInsert() {
        User user = new User(null, "张三", 18, "2422706963@qq.com", 0);
        int affects = userMapper.insert(user);
        System.out.println(affects);
    }

    @Test
    public void testDeleteById() {
        int i = userMapper.deleteById(1606598015527968770l);
        log.info("res={}", i);
    }

    @Test
    public void testDeleteByMap() {
        Map<String, Object> map = new HashMap();
        map.put("name", "张三");
        map.put("age", 23);
        int res = userMapper.deleteByMap(map);
        log.info("res={}", res);
    }

    @Test
    public void testDeleteBatchByIds() {
        List<Long> ids = Arrays.asList(1l, 2l, 3l);
        int batchIds = userMapper.deleteBatchIds(ids);
        log.info("res = {}", batchIds);
    }

    @Test
    public void testUpdate() {
        User user = new User(2l, "Marry", 11, "2222@qq.com", 0);
        int i = userMapper.updateById(user);
        System.out.println(i);
    }

    @Test
    public void testSelect() {
        Map<String, Object> map = userMapper.selectMapById(1l);
        System.out.println(map);
    }
}

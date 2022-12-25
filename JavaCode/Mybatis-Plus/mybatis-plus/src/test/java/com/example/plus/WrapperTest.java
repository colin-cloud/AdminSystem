package com.example.plus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.plus.bean.User;
import com.example.plus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * @author 小白学java
 * @version 3.0
 */
@SpringBootTest
public class WrapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void test01() {
        //查询用户名包含a，年龄在20到30之间，邮箱信息不为null的用户信息
        QueryWrapper<User> wrapper = new QueryWrapper();
        wrapper.like("name", "a")
                .between("age", 20, 30)
                .isNotNull("email");
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void testOrder() {
        //查询用户信息，按照年龄降序排序，若年龄相同，则按id升序排序
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("age")
                .orderByAsc("id");
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void testDelete() {
        //删除邮箱地址为null的用户信息
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.isNull("email");
        int delete = userMapper.delete(wrapper);
        System.out.println(delete);
    }

    @Test
    public void testUp() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        User user = new User(null, "张三", 18, "222@qq.com", null);
        wrapper.gt("age", 20)
                .like("name", "a")
                .or()
                .isNull("email");
        int update = userMapper.update(user, wrapper);
        System.out.println(update);
    }

    @Test
    public void testUp2() {
        //将用户名中包含有a并且(年龄大于20或者邮箱为null)的用户信息
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("name", "a")
                .and(i->i.gt("age", 20).or().isNull("email"));
        User user = new User(null, "张三", 18, "222@qq.com", null);
        int update = userMapper.update(user, wrapper);
        System.out.println(update);
    }

    @Test
    public void testSelect() {
        //查询用户的姓名，年龄和邮箱信息
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.select("name", "age", "email");
        List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
        System.out.println(maps);
    }

    @Test
    public void testSelectChild() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.inSql("id", "select * from user where id <= 100");
        List<User> users = userMapper.selectList(wrapper);
        System.out.println(users);
    }

    @Test
    public void testUpdateWrapper() {
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.like("name", "a")
                .and(i -> i.gt("age", 20).or().isNull("email"));
        userUpdateWrapper.set("name", "小黑").set("email", "abc@qq.com");
        int update = userMapper.update(null, userUpdateWrapper);
        System.out.println(update);
    }

    @Test
    public void testUpdateSelect() {
        String name = "";
        Integer ageBegin = 20;
        Integer ageEnd = 30;
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(name)) {
            //判断字符串是否不为空
            userQueryWrapper.like("name", name);
        }
        if (ageBegin != null) {
            userQueryWrapper.ge("age", ageBegin);
        }
        if (ageEnd != null) {
            userQueryWrapper.le("age", ageEnd);
        }
        List<User> users = userMapper.selectList(userQueryWrapper);
        System.out.println(users);
    }

    @Test
    public void testUpdateSelect2() {
        //同上
        String name = "";
        Integer ageBegin = 20;
        Integer ageEnd = 30;
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.like(StringUtils.isNotBlank(name), "name", name)
                .ge(ageBegin != null, "age", ageBegin)
                .le(ageEnd != null, "age", ageEnd);
    }
}

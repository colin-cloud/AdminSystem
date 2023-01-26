package com.colin.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.colin.springboot.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 小白学java
 * @version 3.0
 */

//@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from tb_user")
    List<User> getAllUsers();

    @Insert("insert into tb_user(username, password, sex, address)" +
            " values(#{username}, #{password}, #{sex}, #{address})")
    Integer add(User user);

    Integer update(User user);

    @Delete("delete from tb_user where id = #{id}")
    Integer delete(Integer id);

    @Select("select * from tb_user where username like #{username}" +
            " and address like #{address} limit #{pageNum}, #{pageSize}")
    List<User> getUsersByPage(Integer pageNum, Integer pageSize, String username, String address);

    @Select("select count(*) from tb_user")
    Integer getTotal();
}

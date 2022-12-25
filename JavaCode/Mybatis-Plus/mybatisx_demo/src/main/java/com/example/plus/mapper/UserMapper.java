package com.example.plus.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.example.plus.bean.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Entity com.example.plus.bean.User
 */
public interface UserMapper extends BaseMapper<User> {

    int insertSelective(User user);

    int deleteByIdAndName(@Param("id") Long id, @Param("name") String name);

    List<User> selectAllById(@Param("id") Long id);

    int updateAgeAndNameById(@Param("age") Integer age, @Param("name") String name, @Param("id") Long id);
}





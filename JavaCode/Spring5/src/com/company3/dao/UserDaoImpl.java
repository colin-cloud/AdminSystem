package com.company3.dao;

import com.company3.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

/**
 * @author 小白学java
 * @version 3.0
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void add(User user) {
        //update进行增删改
        String sql = "insert into t_user values(?, ?, ?)";
        jdbcTemplate.update(sql, user.getId(), user.getName(), user.getStatus());
    }

    @Override
    public void addList(List<Object[]> users) {
        String sql = "insert into t_user values(?, ?, ?)";
        int[] ints = jdbcTemplate.batchUpdate(sql, users);
        System.out.println(Arrays.toString(ints));
    }


    @Override
    public void delete(int id) {
        String sql = "delete from t_user where id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void deleteList(List<Object[]> users) {
        String sql = "delete from t_user where id=?";
        int[] ints = jdbcTemplate.batchUpdate(sql, users);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void update(User user) {
        String sql = "update t_user set name=?, status=? where id=?";
        jdbcTemplate.update(sql, user.getName(), user.getStatus(), user.getId());
    }

    @Override
    public void updateList(List<Object[]> users) {
        String sql = "update t_user set name=?, status=? where id=?";
        int[] ints = jdbcTemplate.batchUpdate(sql, users);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public int queryAll() {
        String sql = "select count(*) from t_user";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public User queryUser(int id) {
        String sql = "select * from t_user where id=?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
    }

    @Override
    public List<User> queryUsers(String status) {
        String sql = "select * from t_user where status=?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class), status);
    }
}

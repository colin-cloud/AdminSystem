package com.companyBank.impl;

import com.companyBank.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author 小白学java
 * @version 3.0
 */
@Repository
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void addMoney() {
        String sql = "update t_bank set money=money-? where username=?";
        jdbcTemplate.update(sql, 100, "lucy");
    }

    @Override
    public void exportMoney() {
        String sql = "update t_bank set money=money+? where username=?";
        jdbcTemplate.update(sql, 100, "mary");
    }
}

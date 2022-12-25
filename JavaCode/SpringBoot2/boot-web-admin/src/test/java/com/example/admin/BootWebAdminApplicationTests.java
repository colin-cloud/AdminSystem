package com.example.admin;

import com.example.admin.bean.City;
import com.example.admin.mapper.CityMapper;
import com.example.admin.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


@Slf4j
@SpringBootTest
class BootWebAdminApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    @Autowired
    CityMapper cityMapper;

    @Test
    void contextLoads() {
        Long aLong = jdbcTemplate.queryForObject("select count(*) from t_bank", Long.class);
        log.info("记录数{}", aLong);
        log.info("数据源类型{}", dataSource.getClass());
    }

    @Test
    void testCityMapper() {
        City city = cityMapper.selectById(1);
        System.out.println(city);
    }

}

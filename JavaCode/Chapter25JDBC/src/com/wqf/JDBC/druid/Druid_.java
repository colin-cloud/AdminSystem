package com.wqf.JDBC.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;

import java.sql.Connection;
import java.util.Properties;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Druid_ {

    @Test
    public void testDruid() throws Exception {
        //1. 加入Druid jar包
        //2. 加入配置文件druid.properties，将该文件拷贝到src目录下
        //3. 创建Properties对象，读取信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\druid.properties"));
        //4. 创建一个制定参数的数据库连接池d - ataSource
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            Connection connection = dataSource.getConnection();
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("时间差: " + (end - start));
    }
}

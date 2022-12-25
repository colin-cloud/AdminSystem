package com.wqf.JDBC.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author 小白学java
 * @version 1.0
 */
public class C3P0_ {

    @Test
    public void testC3P0() throws Exception {
        //方式1：相关参数，在程序中指定user，url，password等
        //1. 创建一个数据源对象 - 管理连接池
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        //2. 通过配置文件mysql.properties获取相关信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        //初始化属性
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");
        //给数据源comboPooledDataSource设置相关参数
        //注意：连接管理是由comboPooledDataSource来管理
        comboPooledDataSource.setDriverClass(driver);//设置驱动
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);
        //初始化数据源的连接数
        comboPooledDataSource.setInitialPoolSize(10);
        //设置最大连接数
        comboPooledDataSource.setMaxPoolSize(50);
        //进行连接 - 测试5000次连接
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            Connection connection = comboPooledDataSource.getConnection();
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("时间差: " + (end - start));
    }
    @Test
    public void testC3P02() throws Exception {
        //使用配置文件模板完成
        //1. 加入C3P0 jar包
        //2. 加入文件c3p0-config.xml，将该文件拷贝到src目录下
        ComboPooledDataSource mysql = new ComboPooledDataSource("mysql");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            Connection connection = mysql.getConnection();
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("时间差: " + (end - start));
    }
}

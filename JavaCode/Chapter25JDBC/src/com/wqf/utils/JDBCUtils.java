package com.wqf.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author 小白学java
 * @version 1.0
 */
public class JDBCUtils {
    //定义相关的属性
    private static String user;
    private static String password;
    private static String url;
    private static String driver;
    //在静态代码块中初始化属性
    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src\\mysql.properties"));
        } catch (IOException e) {
            //将编译异常转换成运行异常，然后再抛出
            throw new RuntimeException(e);
        }
        //初始化属性
        user = properties.getProperty("user");
        password = properties.getProperty("password");
        url = properties.getProperty("url");
        driver = properties.getProperty("driver");
    }
    //编写方法，进行数据库的注册和连接
    public static Connection connect() {
        Connection connection = null;
        //进行类的加载
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
    //编写方法，对相关资源进行释放
    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        //判断是否为空
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

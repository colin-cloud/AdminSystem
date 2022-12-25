package com.wqf.JDBC.practice;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Practice {

    public static void main(String[] args) throws Exception {

        //通过properties对象获取相应信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        //通过Class加载Driver类
        Class<?> aClass = Class.forName(driver);
        //连接数据库
        Connection connection = DriverManager.getConnection(url, user, password);
        String sql = "insert into news values (1, '1'), (2, '2'), (3, '3'), (4, '4'), (5, '5')";
        Statement statement = connection.createStatement();
        int i = statement.executeUpdate(sql);
        System.out.println(i > 0 ? "成功" : "失败");
        statement.close();
        connection.close();
    }
}

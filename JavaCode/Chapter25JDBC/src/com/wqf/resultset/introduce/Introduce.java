package com.wqf.resultset.introduce;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Introduce {

    public static void main(String[] args) throws  Exception {

        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

        Class<?> aClass = Class.forName(driver);

        Connection connect = DriverManager.getConnection(url, user, password);
        String sql = "select id, name, sex, borndate from actor";
        Statement statement = connect.createStatement();//用于执行静态sql语句并返回其生成的结果对象

        ResultSet resultSet = statement.executeQuery(sql);//返回结果集
        //使用while循环取出数据
        while (resultSet.next()) {
            int id = resultSet.getInt(1);//获取该行的第一列数据
            String name = resultSet.getString(2);
            String sex = resultSet.getString(3);
            String date = resultSet.getString(4);
            System.out.println(id + "\t" + name + "\t" + sex + "\t" + date);
        }
        resultSet.close();
        statement.close();
        connect.close();
    }
}

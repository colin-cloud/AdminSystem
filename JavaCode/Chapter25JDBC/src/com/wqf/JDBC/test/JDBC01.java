package com.wqf.JDBC.test;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author 小白学java
 * @version 1.0
 */
public class JDBC01 {

    public static void main(String[] args) throws SQLException {

        //1. 注册驱动 -  加载Driver类
        Driver driver = new Driver();
        //2. 获取连接 -  得到Connection
        //(1).jdbc:mysql:// 是规定好的协议，通过jdbc的方式连接mysql
        //(2).localhost表示主机，可以是ip地址
        //(3).3306表示mysql监听的窗口
        //(4).database02表示连接到哪个数据库
        //(5).mysql的连接本质就是socket连接
        String url = "jdbc:mysql://localhost:3306/database02";
        //将用户名和密码放到Properties对象
        Properties properties = new Properties();
        properties.setProperty("user", "root");//用户名
        properties.setProperty("password", "wqf0724MySQL");//密码
        //获取连接connect
        Connection connect = driver.connect(url, properties);
        //3. 执行增删改查 -  发送SQL语句给数据库执行
        String sql = "insert into actor values(null, '小王', '男', '2003-07-24', '100')";
        Statement statement = connect.createStatement();//用于执行静态sql语句并返回其生成的结果对象
        int updateRows = statement.executeUpdate(sql);//如果是dml语句，返回的是影响的行数
        System.out.println(updateRows > 0 ? "成功" : "失败");
        //4. 释放资源 -  关闭相关连接
        statement.close();
        connect.close();
    }
}

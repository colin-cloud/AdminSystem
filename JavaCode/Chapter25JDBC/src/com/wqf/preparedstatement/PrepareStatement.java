package com.wqf.preparedstatement;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

/**
 * @author 小白学java
 * @version 1.0
 */
public class PrepareStatement {

    public static void main(String[] args) throws Exception {

//        Scanner scanner = new Scanner(System.in);
//        System.out.print("请输入username: ");
//        String username1 = scanner.nextLine();
//        System.out.print("请输入密码: ");
//        String userPassword1 = scanner.nextLine();
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        //得到相关信息
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        //加载类
        Class<?> aClass = Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
//        String sql = "insert into admin values (?, ?)";
        String sql1 = "update admin set username = 'king' where username = 'tom'";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
//        preparedStatement.setString(1, username1);
//        preparedStatement.setString(2, userPassword1);
//        int rows = preparedStatement.executeUpdate();
        int i = preparedStatement1.executeUpdate();
        System.out.println(i > 0 ? "成功" : "失败");
//        System.out.println(rows > 0 ? "成功" : "失败");
    }
}

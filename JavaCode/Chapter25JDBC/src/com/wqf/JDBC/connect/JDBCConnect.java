package com.wqf.JDBC.connect;

import com.mysql.jdbc.Driver;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author 小白学java
 * @version 1.0
 */
public class JDBCConnect {

    public static void main(String[] args) {


    }
    @Test
    public void connect() throws Exception {
        //在方式4的基础上改进，增加配置文件，让连接mysql更加灵活
        //通过properties对象获取相关信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql:properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        //加载类
        Class<?> aClass = Class.forName(driver);
        Connection connect = DriverManager.getConnection(url, user, password);
        String sql = "insert into actor values(null, '小王', '男', '2003-07-24', '100')";
        Statement statement = connect.createStatement();//用于执行静态sql语句并返回其生成的结果对象
        int updateRows = statement.executeUpdate(sql);//如果是dml语句，返回的是影响的行数
        System.out.println(updateRows > 0 ? "成功" : "失败");
        statement.close();
        connect.close();
    }
}

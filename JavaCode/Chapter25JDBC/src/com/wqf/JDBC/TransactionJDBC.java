package com.wqf.JDBC;

import com.wqf.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author 小白学java
 * @version 1.0
 */
public class TransactionJDBC {

    public static void main(String[] args) {

        Connection connect = null;
        PreparedStatement preparedStatement = null;
        //执行的sql语句
        String sql = "update account1 set balance -= 100 where id = 1";
        String sql1 = "update account1 set balance += 100 where id = 2";
        try {
            connect = JDBCUtils.connect();
            //设置为不自动提交事务.开启事务
            connect.setAutoCommit(false);
            //执行相关语句
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.executeUpdate();
            int i = 1 / 0;
            preparedStatement = connect.prepareStatement(sql1);
            preparedStatement.executeUpdate();
            //语句正常进行，提交事务
            connect.commit();
        } catch (Exception e) {
            try {
                connect.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtils.close(null, preparedStatement, connect);
        }
    }
}

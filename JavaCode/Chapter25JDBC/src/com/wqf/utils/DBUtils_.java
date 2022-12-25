package com.wqf.utils;

import com.wqf.dao.utils.JDBCUtil_Druid;
import com.wqf.dao.domain.Actor;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author 小白学java
 * @version 1.0
 */
public class DBUtils_ {
    @Test
    public ArrayList<Actor> testSelectToArrList() {
        Connection connect = null;
        PreparedStatement preparedStatement = null;
        ArrayList<Actor> actors = new ArrayList<Actor>();
        //执行的sql语句
        String sql = "select * from actor";
        try {
            connect = JDBCUtil_Druid.getConnection();
            preparedStatement = connect.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String sex = resultSet.getString(3);
                Date bornDate = resultSet.getDate(4);
                String phone = resultSet.getString(5);
                actors.add(new Actor(id, name, sex, bornDate, phone));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtil_Druid.close(null, preparedStatement, connect);
        }
        return actors;
    }
}


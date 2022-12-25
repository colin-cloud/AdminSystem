package com.wqf.JDBC.batch;

import com.wqf.utils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Batch_ {

    @Test
    public void batchUse() {
        Connection connect = null;
        PreparedStatement preparedStatement = null;
        //执行的sql语句
        String sql = "insert into admin values (?, ?)";
        try {
            connect = JDBCUtils.connect();
            preparedStatement = connect.prepareStatement(sql);
            long start = System.currentTimeMillis();
            for (int i = 0; i < 5000; i++) {
                preparedStatement.setString(1, "jack" + i);
                preparedStatement.setString(2, "123");
                preparedStatement.addBatch();
                if ((i + 1) % 1000 == 0) {
                    preparedStatement.executeBatch();
                    preparedStatement.clearBatch();
                }
            }
            long end = System.currentTimeMillis();
            System.out.println("时间差为" + (end - start));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtils.close(null, preparedStatement, connect);
        }
    }
}

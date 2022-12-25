package com.wqf.JDBC.introduce;

import javax.sql.rowset.JdbcRowSet;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Test {

    public static void main(String[] args) {
        //完成对数据库的操作,使用接口类型完成统一
        JDBCInterface JDBC = new MyJDBC();
        JDBC.getConnection();
        JDBC.crud();
        JDBC.close();
    }
}

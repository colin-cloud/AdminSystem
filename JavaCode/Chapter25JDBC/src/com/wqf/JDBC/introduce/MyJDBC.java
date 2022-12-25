package com.wqf.JDBC.introduce;

/**
 * @author 小白学java
 * @version 1.0
 */
public class MyJDBC implements JDBCInterface {
    //数据库实现接口
    @Override
    public Object getConnection() {
        System.out.println("得到数据库的连接...");
        return null;
    }

    @Override
    public void crud() {
        System.out.println("进行crud操作...");
    }

    @Override
    public void close() {
        System.out.println("关闭数据库连接...");
    }
}

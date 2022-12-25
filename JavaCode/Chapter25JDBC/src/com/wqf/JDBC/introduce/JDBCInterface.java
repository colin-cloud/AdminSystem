package com.wqf.JDBC.introduce;

/**
 * @author 小白学java
 * @version 1.0
 */
public interface JDBCInterface {
    //实现连接操作
    public Object getConnection();
    //crud操作
    public void crud();
    //关闭连接
    public void close();
}

package com.wqf.interface_.advance;

public class MysqlDB implements DBInterface {
    @Override
    public void connect() {
        System.out.println("连接Mysql");
    }

    @Override
    public void close() {
        System.out.println("关闭连接");
    }
}

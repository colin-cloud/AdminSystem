package com.wqf.interface_.advance;

public class Interface03 {

    public static void main(String[] args) {

        MysqlDB mysqlDB = new MysqlDB();
        t(mysqlDB);
    }
    public static void t(DBInterface db) {
        db.connect();
        db.close();
    }
}

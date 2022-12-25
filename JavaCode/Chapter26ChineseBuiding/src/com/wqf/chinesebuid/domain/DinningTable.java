package com.wqf.chinesebuid.domain;

/**
 * @author 小白学java
 * @version 1.0
 * create table dinningTable (
 * id int primary key auto_increment,
 * `status` varchar(32) not null default '',
 * orderName varchar(32) not null default '',
 * orderTel varchar(32) not null default '')charset=utf8;
 */
public class DinningTable {
    private Integer id;
    private String status;
    private String orderName;
    private String orderTel;

    public DinningTable() {}
    public DinningTable(Integer id, String status, String orderName, String orderTel) {
        this.id = id;
        this.status = status;
        this.orderName = orderName;
        this.orderTel = orderTel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderTel() {
        return orderTel;
    }

    public void setOrderTel(String orderTel) {
        this.orderTel = orderTel;
    }

    @Override
    public String toString() {
        return id + "\t\t\t" +  status;
    }
}

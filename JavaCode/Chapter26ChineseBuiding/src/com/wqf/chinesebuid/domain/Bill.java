package com.wqf.chinesebuid.domain;

import java.util.Date;

/**
 * @author 小白学java
 * @version 1.0
 * create table bill (
 * id int primary key auto_increment,
 * billId varchar(32) not null default '',
 * menuId int not null default 0,
 * nums int not null default 0,
 * billDate date not null,
 * money double not null default 0,
 * `status` varchar(32) not null default '',
 * tableId int not null default 0)charset=utf8;
 */
public class Bill {
    private Integer id;
    private String billId;
    private Integer menuId;
    private Integer nums;
    private Date billDate;
    private Double money;
    private String status;
    private Integer tableId;

    public Bill() {
    }

    public Bill(Integer id, String billId,
                Integer menuId, Integer nums, Date billDate, Double money, String status, Integer tableId) {
        this.id = id;
        this.billId = billId;
        this.menuId = menuId;
        this.nums = nums;
        this.billDate = billDate;
        this.money = money;
        this.status = status;
        this.tableId = tableId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    @Override
    public String toString() {
        return id + "\t\t" + menuId + "\t\t\t" + nums + "\t\t\t" + money + "\t" +
                tableId + "\t\t" + billDate + "\t\t\t\t\t" + status;
    }
}

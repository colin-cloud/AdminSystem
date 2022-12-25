package com.wqf.chinesebuid.domain;

import java.util.Date;

/**
 * @author 小白学java
 * @version 3.0
 */
public class MultiTableBean {
    //和多张表进行映射
    private Integer id;
    private String billId;
    private Integer menuId;
    private Integer nums;
    private Date billDate;
    private Double money;
    private String status;
    private Integer tableId;
    private String name;//菜品名
    //定义的属性的名称应该和表的列名相同，底层是通过找到setXXX来设置属性的
    //可以不一致，使用sql语句的As来修改为相同

    public MultiTableBean() {
    }

    public MultiTableBean(Integer id, String billId,
                          Integer menuId, Integer nums, Date billDate, Double money, String status, Integer tableId, String name) {
        this.id = id;
        this.billId = billId;
        this.menuId = menuId;
        this.nums = nums;
        this.billDate = billDate;
        this.money = money;
        this.status = status;
        this.tableId = tableId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return id + "\t\t\t" + menuId + "\t\t\t" + nums + "\t\t\t" + money + "\t\t" +
                tableId + "\t\t\t" + billDate + "\t\t\t\t\t" + status + "\t\t" + name;
    }
}

package com.example.admin.bean;

/**
 * @author 小白学java
 * @version 3.0
 */
public class Bank {

    private Integer id;
    private String userName;
    private String money;

    public Bank(Integer id, String userName, String money) {
        this.id = id;
        this.userName = userName;
        this.money = money;
    }

    public Bank() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", money='" + money + '\'' +
                '}';
    }
}

package com.companyBank.account;

/**
 * @author 小白学java
 * @version 3.0
 */

public class Account {
    private String id;
    private String username;
    private Integer money;

    public Account(String id, String username, Integer money) {
        this.id = id;
        this.username = username;
        this.money = money;
    }
    public Account(){}

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", money=" + money +
                '}';
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Integer getMoney() {
        return money;
    }
}

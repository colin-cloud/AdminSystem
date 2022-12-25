package com.wqf.qqServer.qqcommon;

import java.io.Serializable;

/**
 * @author 小白学java
 * @version 1.0
 */
public class User implements Serializable {
    private String userId;//表示使用者id
    private String password;//密码

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }
    public User() {

    }
}

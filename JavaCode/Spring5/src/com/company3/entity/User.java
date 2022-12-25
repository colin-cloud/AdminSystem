package com.company3.entity;

/**
 * @author 小白学java
 * @version 3.0
 */
//对应数据库中的表对象
public class User {

    private Integer id;
    private String name;
    private String status;

    public User(Integer id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }
    public User() {}

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

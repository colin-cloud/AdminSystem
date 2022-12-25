package com.company.mvc.bean;

/**
 * @author 小白学java
 * @version 3.0
 */
public class User {

    private Integer age;
    private String sex;
    private String email;
    private String username;
    private String password;

    public User(Integer age, String sex, String email, String username, String password) {
        this.age = age;
        this.sex = sex;
        this.email = email;
        this.username = username;
        this.password = password;
    }
    public User() {}


    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

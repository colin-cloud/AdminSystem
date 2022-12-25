package com.wqf.chinesebuid.domain;

/**
 * @author 小白学java
 * @version 1.0
 * create table employee (
 * id int PRIMARY KEY auto_increment,
 * empId varchar(32) unique not null default '',
 * `password` char(32) not null default '',
 * name varchar(32) not null default '',
 * job varchar(32) not null default '')charset=utf8;
 */
public class Employee {
    //设置相关属性
    private Integer id;
    private String empId;
    private String password;
    private String name;
    private String job;
    //给定构造器
    public Employee() {}
    public Employee(Integer id, String empId, String password, String name, String job) {
        this.id = id;
        this.empId = empId;
        this.password = password;
        this.name = name;
        this.job = job;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", empId='" + empId + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}

package com.company.bean;

/**
 * @author 小白学java
 * @version 3.0
 */
public class Department {

    private Integer id;
    private String deptName;

    public Department(Integer id, String deptName) {
        this.id = id;
        this.deptName = deptName;
    }

    public Department() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}

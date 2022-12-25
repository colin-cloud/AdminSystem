package com.company.bean;

/**
 * @author 小白学java
 * @version 3.0
 */
public class Employee {

    private String name;
    private Department department;
    private String gender;

    public Department getDepartment() {
        return department;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department=" + department +
                ", gender='" + gender + '\'' +
                '}';
    }
}

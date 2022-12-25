package com.company.bean;

/**
 * @author 小白学java
 * @version 3.0
 */
public class Department {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                '}';
    }
}

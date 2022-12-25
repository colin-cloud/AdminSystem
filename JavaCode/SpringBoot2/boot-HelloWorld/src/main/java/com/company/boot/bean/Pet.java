package com.company.boot.bean;

/**
 * @author 小白学java
 * @version 3.0
 */
public class Pet {

    private String name;

    public Pet(String name) {
        this.name = name;
    }

    public Pet() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                '}';
    }
}

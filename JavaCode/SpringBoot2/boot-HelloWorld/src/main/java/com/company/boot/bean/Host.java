package com.company.boot.bean;

/**
 * @author 小白学java
 * @version 3.0
 */

public class Host {

    private String name;
    private Integer age;
    private Pet pet;

    public Host(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Host(String name, Integer age, Pet pet) {
        this.name = name;
        this.age = age;
        this.pet = pet;
    }

    public Host() {
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Host{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", pet=" + pet +
                '}';
    }
}

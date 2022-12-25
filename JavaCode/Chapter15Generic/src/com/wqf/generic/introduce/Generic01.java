package com.wqf.generic.introduce;

import java.util.ArrayList;

/**
 * @author 小白学java
 * @version 1.0
 */

public class Generic01 {

    public static void main(String[] args) {

        //1. 当我们ArrayList<Dog>表示存放的只能是Dog类型
        ArrayList<Dog> dogs = new ArrayList<Dog>();
        Dog dog = new Dog("大黄", 10);
        Cat cat = new Cat("小黄", 1);
        dogs.add(dog);
//        dogs.add(cat);
        for (Dog dog1 : dogs) {
            System.out.println(dog1.getName() + " " + dog1.getAge());
        }
    }
}
class Dog {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
class Cat {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

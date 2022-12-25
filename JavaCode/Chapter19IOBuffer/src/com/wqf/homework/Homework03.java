package com.wqf.homework;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Homework03 {

    public static void main(String[] args) throws IOException {

        Properties properties = new Properties();
        properties.load(new FileReader("src\\dog.properties"));
        Dog dog = new Dog(properties.getProperty("name"),
                Integer.parseInt(properties.getProperty("age")), properties.getProperty("color"));
        System.out.println(dog);
    }
}
class Dog implements Serializable {
    private String name;
    private int age;
    private String color;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
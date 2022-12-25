package com.wqf.collection.iterator_;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

/**
 * @author 小白学java
 * @version 1.0
 */
public class CollectExercise {

    public static void main(String[] args) {

        Dog dog = new Dog("小白", 1);
        Dog dog1 = new Dog("小黑", 2);
        Dog dog2 = new Dog("小红", 3);
        Collection list = new ArrayList();
        list.add(dog);
        list.add(dog1);
        list.add(dog2);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        for (Object obj : list) {
            System.out.println(obj);
        }
        Vector vector = new Vector();
    }
}

class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

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

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

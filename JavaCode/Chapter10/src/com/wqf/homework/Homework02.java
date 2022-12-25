package com.wqf.homework;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Homework02 {

    public static void main(String[] args) {

//        new Cat().shout();
//        new Dog().shout();
    }
}

abstract class Animal {
    public abstract void shout();
}
class Cat extends Animal {
    public void shout() {
        System.out.println("猫会叫");
    }
}
class Dog extends Animal {
    public void shout() {
        System.out.println("狗会叫");
    }
}
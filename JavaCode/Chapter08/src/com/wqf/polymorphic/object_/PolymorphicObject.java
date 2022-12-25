package com.wqf.polymorphic.object_;

public class PolymorphicObject {

    public static void main(String[] args) {
        //体验对象多态的特点
        //编译类型是Animal  运行类型时Dog
        Animal animal = new Dog();
        animal.cry();//运行到该行时，animal运行类型时Dog，所以是Dog的cry()

        animal = new Cat();
        animal.cry();

    }
}

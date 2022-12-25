package com.wqf.abstract_;

public class Abstract01 {
}
abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }
    //父类方法不确定性
    //==》将该方法抽象为抽象方法 --- 没有实现的方法 --- 没有方法体
    //当一个类中存在抽象方法时，需将类声明为抽象类
    //一般来说，抽象类会被继承，由其子类来实现该方法
//    public void eat() {
//        System.out.println("这是一个动物，但是不知道吃什么");
//    }
    public abstract void eat();
}

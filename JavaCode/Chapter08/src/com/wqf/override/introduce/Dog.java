package com.wqf.override.introduce;

public class Dog extends Animal {
    //1. Dog是Animal的子类
    //2. Dog的cry方法和Animal的cry方法定义形式一样
    //3. Dog的cry方法重写了Animal的cry方法
    public void cry() {
        System.out.println("小狗汪汪叫...");
    }
}

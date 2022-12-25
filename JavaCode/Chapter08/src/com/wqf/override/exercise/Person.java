package com.wqf.override.exercise;

public class Person {
    //属性
    private String name;
    private int age;

    //构造器
    public Person(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }
    //设置姓名
    public void setName(String name) {
        //可以设置访问权限
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    //设置年龄
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        //可以设置访问权限
        return this.age;
    }
    //放回自我介绍方法
    public String showMyselfInfo() {
        return "我是 " + this.name + " 年龄 " + this.age;
    }
}

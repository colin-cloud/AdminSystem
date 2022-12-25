package com.wqf.extend.improve;
//父类，是Pupil和Graduate的父类
public class Student {
    public String name;
    private int age;
    private double score;

    public void setAge(int age) {
        this.age = age;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void showInfo() {
        System.out.println("学生" + name + " 年龄" + age + " 分数" + score);
    }
}

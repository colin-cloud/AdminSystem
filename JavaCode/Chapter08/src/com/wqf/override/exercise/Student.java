package com.wqf.override.exercise;

public class Student extends Person {
    //增加的属性
    private String id;
    private double score;
    //构造器
    public Student(String name, int age, String id, double score) {
        super(name, age);
        this.setId(id);
        this.setScore(score);
    }
    //设置id
    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        //可以设置访问权限
        return this.id;
    }
    //设置分数
    public void setScore(double score) {
        this.score = score;
    }
    public double getScore() {
        //可以设置访问权限
        return this.score;
    }
    //返回自我介绍的方法
    public String showMyselfInfo() {
        return super.showMyselfInfo() + " id为 " + this.id + " 分数为 " + this.score;
    }
}

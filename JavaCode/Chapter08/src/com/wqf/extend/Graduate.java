package com.wqf.extend;
//模拟大学生的考试情况
public class Graduate {
    public String name;
    public int age;
    private double score;

    //封装
    //除testing方法外，其他基本一致
    public void setScore(double score) {
        this.score = score;
    }
    public void testing() {//和小学生不一样
        System.out.println("大学生" + name + "正在考试");
    }
    public void showInfo() {
        System.out.println("学生" + name + " 年龄" + age + " 分数" + score);
    }
}

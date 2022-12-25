package com.wqf.static_.usestatic;

public class StaticMethod {

    public static void main(String[] args) {

        Student student = new Student("tom");
        student.payFee(2000);
        Student.showFee();
        Student student1 = new Student("smith");
        student1.payFee(3000);
        Student.showFee();
    }
}
class Student {

    private String name;
    //定义一个静态变量，来累计学生学费
    private static double fee = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(String name) {
        this.setName(name);
    }
    public void payFee(double fee) {
        Student.fee += fee;
        System.out.println(getName() + "交了" + fee + "元");
    }
    public static void showFee() {
        System.out.println("总学费有:" + Student.fee);
    }
}

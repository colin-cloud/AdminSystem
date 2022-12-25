package com.wqf.extend.improve;


//让Pupil继承student
public class Pupil extends Student {
    public void testing() {
        //要是用name需要使用继承关系
        System.out.println("小学生" + name +  "正在考试");
    }
}

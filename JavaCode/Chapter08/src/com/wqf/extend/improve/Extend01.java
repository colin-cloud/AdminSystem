package com.wqf.extend.improve;

import com.wqf.extend.Graduate;
import com.wqf.extend.Pupil;

public class Extend01 {

    public static void main(String[] args) {
        com.wqf.extend.Graduate graduate = new Graduate();
        graduate.setScore(50);
        graduate.name = "wang";
        graduate.age = 18;
        graduate.testing();
        graduate.showInfo();

        com.wqf.extend.Pupil pupil = new Pupil();//与大学生代码基本一致
        pupil.name = "小学生";
        pupil.age = 10;
        pupil.setScore(40);
        pupil.testing();
        pupil.showInfo();
    }
}

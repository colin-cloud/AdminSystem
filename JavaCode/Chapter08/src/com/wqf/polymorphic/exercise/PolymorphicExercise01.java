package com.wqf.polymorphic.exercise;

import com.wqf.extend.detail.Sub;

public class PolymorphicExercise01 {

    public static void main(String[] args) {
        Sub1 s = new Sub1();
        System.out.println(s.count);
        s.display();
        Base1 b = s;
        System.out.println(b == s);//两个对象的比较是比较地址
        System.out.println(b.count);
        b.display();
    }
}
class Base1 {
    int count = 10;
    public void display() {
        System.out.println(this.count);
    }
}
class Sub1 extends Base1 {
    int count = 20;
    public void display() {
        System.out.println(this.count);
    }
}

package com.wqf.polymorphic.detail;

public class PolymorphicDetail02 {

    public static void main(String[] args) {
        //属性没有重写之说！属性的值看编译类型
        Base base = new Sub();
        System.out.println(base.count);
        Sub sub = new Sub();
        System.out.println(sub.count);
    }
}


class Base {
    //父类
    int count = 10;
}
class Sub extends Base {
    int count = 20;
}
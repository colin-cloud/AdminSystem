package com.wqf.super_;

public class B extends A {
//    访问父类的属性，但不能访问父类的private属性：super.属性名
    public void hi() {
        System.out.println(super.n1 + " " + super.n2 + " " + super.n3);
    }
    public void ok() {
        super.test1();//直接找父类
        this.test1();//先找本类
        test1();//与this相同查找方式
        System.out.println();
        super.test2();
        this.test2();
        test2();
        System.out.println();
        super.test3();
        this.test3();
        test3();
    }
    public B() {
        super();
    }
}

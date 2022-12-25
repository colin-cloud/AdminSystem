package com.wqf.modifier;

public class B {

    public void say() {
        A a = new A();
        //在同一个包下，了以访问 public，protected和默认, 不能访问私有的属性
        System.out.println(a.n1 + a.n2 + a.n3);
    }
}

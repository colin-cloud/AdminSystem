package com.wqf.codeblock.detail;

public class CodeBlockDetail02 {

    public static void main(String[] args) {

        BBB bbb = new BBB();

    }
}

class AAA {

    {
        System.out.println("AAA 的普通代码块被执行...");
    }
    public AAA() {
        System.out.println("AAA() 构造器被调用....");
    }
}

class BBB extends AAA {
    {
        System.out.println("BBB 的普通代码块被调用...");
    }

    public BBB() {
        //(1)super();
        //(2)普通代码块
        System.out.println("BBB 的构造器被调用");
    }
}

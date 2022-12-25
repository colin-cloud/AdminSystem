package com.wqf.codeblock.detail;

public class CodeBlockDetail01 {

    public static void main(String[] args) {

        A a = new A();//(1) getN1 (2)static 代码块 (3)getN2 (4)普通代码块 (5)构造器
    }
}

class A {
    public A() {
        System.out.println("A 的构造器被调用...");
    }
    private static int n1 = getN1();
    private int n2 = getN2();
    {
        System.out.println("A 的普通代码块被执行..");
    }
    public int getN2() {
        System.out.println("getN2 被调用..");
        return 200;
    }

    static {
        System.out.println("A 的静态代码块被调用...");
    }
    public static int getN1() {
        System.out.println("getN1 方法被调用...");
        return 100;
    }

}

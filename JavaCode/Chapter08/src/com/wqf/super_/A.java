package com.wqf.super_;

public class A {
    public int n1 = 100;
    protected int n2 = 200;
    int n3 = 300;
    private int n4 = 400;//私有

    //要想访问n4要用公共的方法
    public int getN4() {
        return this.n4;
    }

    public void test1() {
        System.out.println("test1");
    }

    protected void test2() {
        System.out.println("test2");
    }

    void test3() {
        System.out.println("test3");
    }

    private void test4() {
        System.out.println("test4");
    }

    //访问私有的方法
    public void call() {
        test4();
    }
}

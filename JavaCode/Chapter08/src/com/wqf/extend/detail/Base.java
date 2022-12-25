package com.wqf.extend.detail;

public class Base extends TopBase{
    //父类
    public int n1 = 100;
    protected int n2 = 200;
    int n3 = 300;
    private int n4 = 400;//私有
    //要想访问n4要用公共的方法
    public int getN4() {
        return this.n4;
    }
    public Base() {//无参构造器
        System.out.println("父类的base()构造器被调用...");
    }
    //3.detail
    public Base(String name, int age) {
        //有参构造器
        //super();
        System.out.println("父类Base(String name, int age)有参构造器被调用...");
    }
    public Base(String name) {
        //有参构造器
        System.out.println("父类Base(String name)有参构造器被调用...");
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

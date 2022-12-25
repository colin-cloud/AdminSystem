package com.wqf.codeblock.detail;

public class CodeBlockDetail03 {

    public static void main(String[] args) {

        //类加载 - 对象的创建
        //先加载A02 后B02
        //静态成员的初始化跟类加载相关的
        //执行完相应的静态成员的初始化和静态代码块后才进行对象的创建
        B02 b02 = new B02();
    }
}
class A02 {
    private static int n1 = getVal01();
    static {
        System.out.println("A02 的一个静态代码块");
    }
    {
        System.out.println("A02 的第一个普通代码块");
    }
    public int n3 = getVal02();
    public static int getVal01() {
        System.out.println("getVal01");
        return 10;
    }
    public int getVal02() {
        System.out.println("getVal02");
        return 10;
    }
    public A02() {
        System.out.println("A02的构造器");
    }
}
class B02 extends A02 {
    private static int n3 = getVal03();
    static {
        System.out.println("B02 的一个静态代码块");
    }
    public int n4 = getVal04();
    {
        System.out.println("B02 的第一个普通代码块");
    }
    public static int getVal03() {
        System.out.println("getVal03");
        return 10;
    }
    public int getVal04() {
        System.out.println("getVal04");
        return 10;
    }
    public B02() {
        //super()
        //普通代码块
        System.out.println("B02的构造器");
    }

}
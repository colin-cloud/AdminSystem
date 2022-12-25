package com.wqf.static_.detail;

public class StaticDetail {

    public static void main(String[] args) {

        D d = new D();
        d.say();
    }
}
class D {
    private int n = 100;
    private static int n1 = 200;
    public void say() {
        hi();
        hello();
        System.out.println(n);
        System.out.println(n1);
    }
    public static void hi() {
        //this.n;//error
    }
    public static void hello() {
        System.out.println(D.n1);
        //this.n1;//error
        hi();
        //say();//error
    }
}

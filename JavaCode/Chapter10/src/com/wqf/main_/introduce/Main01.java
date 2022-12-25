package com.wqf.main_.introduce;

public class Main01 {

    private  int n = 0;
    private  static String name = "小王";

    public static void hi() {
        System.out.println("hi~");
    }
    public static void main(String[] args) {

        System.out.println(name);
        hi();
        //n;//error
        //say();//error
        Main01 main01 = new Main01();
        main01.say();
        int num = main01.n;
    }
    public void say() {
        System.out.println("hello");
    }

    public int getN() {
        return n;
    }
}

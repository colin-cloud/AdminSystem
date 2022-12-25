package com.wqf.thread.exercise;

import java.util.Scanner;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Exercise01 {

    public static void main(String[] args) {

        B b = new B();
        Thread thread1 = new Thread(b);
        thread1.start();
    }
}
class A implements Runnable {
    private static boolean loop = true;

    @Override
    public void run() {
        while (loop) {
            System.out.println((int)(Math.random() * 101));
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void setLoop(boolean loop) {
        A.loop = loop;
    }
}
class B extends A {

    @Override
    public void run() {
        A a = new A();
        Thread thread = new Thread(a);
        thread.setDaemon(true);
        thread.start();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入");
        String str = scanner.next();
        if (str.compareTo("Q") == 0) {
            A.setLoop(false);
        }
    }
}
package com.wqf.thread.exercise;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Exercise02 {

    public static void main(String[] args) {

        Card card = new Card();
        Thread thread = new Thread(card);
        Thread thread1 = new Thread(card);
        thread.start();
        thread1.start();
    }
}
class Card implements Runnable {
    private int balance = 10000;

    @Override
    public void run() {
        fn();
    }
    public synchronized void fn() {
        while (true) {
            if (balance < 1000) {
                break;
            }
            System.out.print(Thread.currentThread().getName() + "取出1000块,还剩余");
            balance -= 1000;
            System.out.println(balance);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

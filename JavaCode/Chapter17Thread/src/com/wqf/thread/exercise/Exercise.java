package com.wqf.thread.exercise;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Exercise {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new Demo());
        for (int i = 0; i < 10; i++) {
            System.out.println("hi~~");
            Thread.sleep(1000);
            if (i == 4) {
                thread.start();
                thread.join();
            }
        }
    }
}
class Demo implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("hello~");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

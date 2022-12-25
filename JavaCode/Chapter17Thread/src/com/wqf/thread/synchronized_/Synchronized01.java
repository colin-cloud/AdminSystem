package com.wqf.thread.synchronized_;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Synchronized01 {

    public static void main(String[] args) {

        Window window = new Window();
        Thread thread = new Thread(window);
        thread.setName("1");
        Thread thread1 = new Thread(window);
        thread.setName("2");
        Thread thread2 = new Thread(window);
        thread.setName("3");
        thread.start();
        thread1.start();
        thread2.start();
    }
}
class Window implements Runnable {

    private int tickets = 100;
    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (tickets == 0) {
                    break;
                }
                tickets--;
                System.out.println(Thread.currentThread().getName() + "售票一张，还剩余" + tickets);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("售票完毕~~~");
    }
}
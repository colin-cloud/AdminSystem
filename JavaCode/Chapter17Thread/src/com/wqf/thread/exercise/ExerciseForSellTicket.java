package com.wqf.thread.exercise;

/**
 * @author 小白学java
 * @version 1.0
 */
public class ExerciseForSellTicket {

    public static void main(String[] args) {

        Window window = new Window();
        Thread thread = new Thread(window);
        Thread thread1 = new Thread(window);
        Thread thread2 = new Thread(window);
        thread.start();
        thread1.start();
        thread2.start();
    }
}
class Window implements Runnable {

    private int tickets = 100;
    @Override
    public void run() {
        do {
            tickets--;
            System.out.println("售票一张，还剩余" + tickets);
        } while (tickets > 0);
        System.out.println("售票完毕~~~");
    }
}
//class Window extends Thread {
//    private int tickets = 100;
//    @Override
//    public void run() {
//        tickets--;
//        System.out.println("售票一张，还剩余" + tickets);
//        if (tickets == 0) {
//            System.out.println("售票完毕~~");
//        }
//    }
//}

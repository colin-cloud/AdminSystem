package com.wqf.thread.use;


/**
 * @author 小白学java
 * @version 1.0
 */public class ThreadUse {

    public static void main(String[] args) throws InterruptedException {

        //创建一个Cat对象，当线程使用
        Cat cat = new Cat();
        cat.start();//启动线程
        //说明：当main线程启动一个子线程 Thread-0，主线程不会阻塞，会继续执行
        //cat.run();//run方法就是一个普通方法，没有真正启动一个线程，就会把run方法执行完毕，才向下执行
        //start方法中有一个start0方法，该方法是本地方法，由JVM调用，真正实现多线程效果的是start0而不是run
        System.out.println(Thread.currentThread().getName());//main
        for (int i = 0; i < 80; i++) {
            System.out.println("主线程" + i);
            Thread.sleep(1000);
        }
    }
}
//1. 当一个类继承了Thread类，该类就可以做线程使用
//2. 我们会重写run方法，在这里写上自己的业务代码
//3. run的来源：Thread类实现了Runnable接口的run方法

/**
 *     public void run() {
 *         if (target != null) {
 *             target.run();
 *         }
 *     }
 */
class Cat extends Thread {
    public void run() {//重写run方法，写上自己的业务逻辑
//        super.run();
        int times = 0;
        do {
            //该线程每隔1s，在控制台输出“喵喵~~”
            System.out.println("喵喵~~" + Thread.currentThread().getName());
            //让该线程休眠1s
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            times++;
        } while (times != 80);
    }
}


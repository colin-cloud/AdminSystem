package com.wqf.thread.use;

/**
 * @author 小白学java
 * @version 1.0
 */


//演示实现Runnable接口来实现多线程
public class ThreadUse02 {

    public static void main(String[] args) {

        Dog dog = new Dog();
//        dog.start();这里不能调用start方法
        //创建一个Thread对象，把dog对象(实现了Runnable)放入Thread
        Thread thread = new Thread(dog);//底层使用了设计模式(代理模式)
        thread.start();
    }
}
class Dog implements Runnable {

    @Override
    public void run() {
        int times = 0;
        do {
            System.out.println("小狗汪汪叫~" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            times++;
        } while (times != 10);
    }
}


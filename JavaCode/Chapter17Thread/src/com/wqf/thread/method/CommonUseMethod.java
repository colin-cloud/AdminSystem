package com.wqf.thread.method;

/**
 * @author 小白学java
 * @version 1.0
 */
public class CommonUseMethod {

    public static void main(String[] args) throws InterruptedException {

        Demo demo = new Demo();
        demo.setName("小王");//设置线程名称
        demo.setPriority(Thread.MIN_PRIORITY);//更改线程优先级
        demo.setDaemon(true);//设置demo为守护线程
        demo.start();//启动子线程

        //主线程打印 5 个hi，然后中断子线程休眠
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println("hi~~" + i);
        }
        System.out.println(demo.getName() + "线程的优先级为" + demo.getPriority());
        demo.interrupt();//中断子线程的休眠
        System.out.println(demo.getName());//获取线程名称
        Demo demoAnother = new Demo();
        demoAnother.start();
        for (int i = 0; i < 20; i++) {
            Thread.sleep(5000);
            System.out.println("吃了" + i + "个包子");
            if (i == 5) {
                //demoAnother.join();//相当于让demo线程先执行完毕
                Thread.yield();//礼让，不一定成功
            }
        }
    }
}
class Demo extends Thread {
    @Override
    public void run() {
        while (true) {
            for (int i = 1; i <= 10; i++) {
                //Thread.currentThread().getName() 获取当前线程名称
                System.out.println(Thread.currentThread().getName() + "吃包子" + i);
            }
            try {
                System.out.println(Thread.currentThread().getName() + "休眠中~~");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                //当线程执行到一个interrupt方法时，就会catch一个异常，可以加入自己的业务代码
                //InterruptedException e 捕获interrupt异常，中断 休眠
                System.out.println(Thread.currentThread().getName() + "被interrupt了");
            }
        }
    }
}
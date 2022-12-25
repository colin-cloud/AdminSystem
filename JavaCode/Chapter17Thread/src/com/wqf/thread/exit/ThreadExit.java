package com.wqf.thread.exit;

/**
 * @author 小白学java
 * @version 1.0
 */
public class ThreadExit {

    public static void main(String[] args) {

        T t = new T();
        t.start();
        //如果希望在main方法终止run方法，必须修改loop
        //让t退出run方法，从而终止t线程->通知方式
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.setLoop(false);
    }
}
class T extends Thread {
    //设置一个控制变量
    private boolean loop = true;
    @Override
    public void run() {
        while (loop) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("run()运行中...");
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}

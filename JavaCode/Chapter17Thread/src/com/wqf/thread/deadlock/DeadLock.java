package com.wqf.thread.deadlock;

/**
 * @author 小白学java
 * @version 1.0
 */
public class DeadLock {

    public static void main(String[] args) {


    }
}
class DeadLockDemo extends Thread {
    static Object object1 = new Object();
    static Object object2 = new Object();
    boolean flag;

    public DeadLockDemo(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag) {
            synchronized (object1) {
                System.out.println(Thread.currentThread().getName() + "得到了object1对象锁");
                synchronized (object2) {
                    System.out.println(Thread.currentThread().getName() + "得到了object2对象锁");
                }
            }
        } else {//如果有两个线程A和B，A持有object1对象锁，B持有了object2对象锁，那么A和B都会处于Blocked状态，即陷入死锁
            synchronized (object2) {
                System.out.println(Thread.currentThread().getName() + "得到了object2对象锁");
                synchronized (object1) {
                    System.out.println(Thread.currentThread().getName() + "得到了object1对象锁");
                }
            }
        }
    }
}

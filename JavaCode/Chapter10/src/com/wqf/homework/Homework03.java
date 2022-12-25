package com.wqf.homework;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Homework03 {

    public static void main(String[] args) {

        CellPhone.testWork(new Calculate() {
            @Override
            public void work() {
                System.out.println("工作");
            }
        });
    }
}

interface Calculate {
    public abstract void work();
}
class CellPhone {
    public static void testWork(Calculate calculate) {
        calculate.work();
    }
}
package com.wqf.innerclass_;

public class InnerClassExercise01 {

    public static void main(String[] args) {

        f1(new AA() {
            public void show() {
                System.out.println("这是一个方法");
            }
        });
    }
    public static void f1(AA aa) {
        aa.show();
    }
}
interface AA {
    public void show();
}
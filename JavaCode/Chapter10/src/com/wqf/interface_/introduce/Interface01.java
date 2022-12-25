package com.wqf.interface_.introduce;

public class Interface01 {

    public static void main(String[] args) {

        //创建手机
        Phone phone = new Phone();
        //创建电脑
        Computer computer = new Computer();
        //调用方法
        computer.work(phone);
    }
}

package com.wqf.interface_.introduce;

//Phone类实现Usb接口
//Phone类需要实现Usb接口声明的方法
public class Phone implements UsbInterface {

    @Override
    public void start() {
        System.out.println("手机开始工作...");
    }

    @Override
    public void stop() {
        System.out.println("手机停止工作...");
    }
}

package com.wqf.interface_.introduce;

public class Computer {
    //编写一个方法,计算机工作
    public void work(UsbInterface usbInterface) {
        //通过接口调用方法
        usbInterface.start();
        usbInterface.stop();
    }
}

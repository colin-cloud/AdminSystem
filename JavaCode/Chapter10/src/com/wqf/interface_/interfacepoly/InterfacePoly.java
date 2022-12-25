package com.wqf.interface_.interfacepoly;

public class InterfacePoly {

    public static void main(String[] args) {

        Usb[] usbs = new Usb[2];
        usbs[0] = new MyPhone();
        usbs[1] = new Camera();
        for (Usb usb : usbs) {
            usb.start();
            usb.stop();
        }
    }
}

interface Usb {
    public void start();
    public void stop();
}
class MyPhone implements Usb {
    public void start(){
        System.out.println("手机接入...");
        call();
    }
    public void stop() {
        System.out.println("手机拔出...");
    }
    public void call() {
        System.out.println("正在通话中...");
    }
}
class Camera implements Usb {
    public void start(){
        System.out.println("相机接入...");
    }
    public void stop() {
        System.out.println("相机拔出...");
    }
}

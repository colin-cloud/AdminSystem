package com.wqf.UDPsocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author 小白学java
 * @version 1.0
 */
public class UDPSender {

    public static void main(String[] args) throws IOException {

        //创建DatagramSocket对象，准备发送数据,发送端也可以转换成接收端，所以应该制定一个端口
        DatagramSocket datagramSocket = new DatagramSocket(9998);
        //将数据封装到DatagramPacket对象中
        byte[] data = "hello,明天吃火锅".getBytes();
        DatagramPacket datagramPacket = new DatagramPacket
                (data, 0, data.length, InetAddress.getByName("192.168.1.7"), 9999);
        datagramSocket.send(datagramPacket);
        byte[] buf = new byte[64 * 1024];
        DatagramPacket datagramPacket1 = new DatagramPacket(buf, buf.length);
        datagramSocket.receive(datagramPacket1);
        int length = datagramPacket1.getLength();
        byte[] data1 = datagramPacket1.getData();
        String s = new String(data1, 0, length);
        System.out.println(s);
        datagramSocket.close();
    }
}

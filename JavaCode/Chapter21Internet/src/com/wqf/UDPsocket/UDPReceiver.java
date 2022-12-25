package com.wqf.UDPsocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

/**
 * @author 小白学java
 * @version 1.0
 */
public class UDPReceiver {

    public static void main(String[] args) throws IOException {

        //创建一个DatagramSocket对象
        DatagramSocket datagramSocket = new DatagramSocket(9999);
        //构建一个DatagramPacket对象接收数据
        byte[] buf = new byte[64 * 1024];
        DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
        //调用接收方法，准备接收数据 通过网络传输的DatagramPacket的对象填充到datagramPacket对象中
        //当有数据包发送到本机的9999端口，方法就会接收到数据；反之，则会阻塞
        datagramSocket.receive(datagramPacket);
        //把DatagramPacket对象进行拆包，并显示
        int length = datagramPacket.getLength();//实际接收到的数据字节长度
        byte[] data = datagramPacket.getData();//接收到的数据
        String s = new String(data, 0, length);
        System.out.println(s);
        //发送数据给接收端
        String str = "好的，明天见";
        DatagramPacket datagramPacket1 = new DatagramPacket
                (str.getBytes(), 0, str.getBytes().length, InetAddress.getByName("192.168.1.7"), 9998);
        datagramSocket.send(datagramPacket1);
        //关闭socket
        datagramSocket.close();
    }
}

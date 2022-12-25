package com.wqf.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Client {
    public static void main(String[] args) throws IOException {
        //1. 连接服务端(ip, 端口)
        //连接本机的9999端口,如果连接成功就返回Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        //2. 连接上后，生成Socket，通过socket.getOutputStream()得到与socket相关联的输出流
        OutputStream outputStream = socket.getOutputStream();
        //3. 通过输出流，写入数据到数据通道
        outputStream.write("hello,server".getBytes());
        //4. 关闭流对象和socket，必须关闭
        outputStream.close();
        socket.close();
        System.out.println("客户端退出...");
    }
}

package com.wqf.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Client02 {

    public static void main(String[] args) throws IOException {

        //1. 连接服务端
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        // 2. 创建输出流对象
        OutputStream outputStream = socket.getOutputStream();
        //3. 输出信息
        outputStream.write("hello,server".getBytes());
        socket.shutdownOutput();
        //4. 得到信息
        InputStream inputStream = socket.getInputStream();
        byte[] buff = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buff)) != -1) {
            System.out.println(new String(buff, 0, readLen));
        }
        //关闭相关流
        outputStream.close();
        inputStream.close();
        socket.close();
        System.out.println("客户端退出...");
    }
}

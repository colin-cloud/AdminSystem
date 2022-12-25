package com.wqf.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Sever {
    public static void main(String[] args) throws IOException {
        //1. 在本机的9999端口监听，等待连接
        //要求：本机没有其他服务在监听9999端口
        //ServerSocket可以通过accept方法返回多个Socket(多个客户端连接服务器的并发)
        ServerSocket serverSocket = new ServerSocket(9999);
        //2. 当没有客户端连接9999端口时，程序会阻塞，等待连接
        //如果有客户端连接，就会返回一个Socket对象，程序继续
        Socket socket = serverSocket.accept();
        //3. 通过socket.getInputStream()读取客户端写入的数据，显示
        InputStream inputStream = socket.getInputStream();
        byte[] buffer = new byte[1024];
        int readLength = 0;
        while ((readLength = inputStream.read(buffer)) != -1) {
            System.out.println(new String(buffer, 0, readLength));
        }
        //4. 关闭流
        inputStream.close();
        socket.close();
        serverSocket.close();
    }

}

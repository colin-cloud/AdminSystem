package com.wqf.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Server02 {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, readLen));
        }
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,client".getBytes());
        socket.shutdownOutput();
        inputStream.close();
        outputStream.close();
        socket.close();
        serverSocket.close();
    }
}

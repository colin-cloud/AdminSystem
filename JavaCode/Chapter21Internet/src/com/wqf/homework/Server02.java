package com.wqf.homework;

import java.io.*;
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
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        //接收输入信息
        String fileName = "D:\\JAVA入门\\JavaCode\\Chapter16TankGame\\坦克大战.wav";
        FileInputStream fileInputStream = new FileInputStream(fileName);
        String musicFile = bufferedReader.readLine();
        OutputStream outputStream = socket.getOutputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        if (musicFile.equals("坦克大战")) {
            byte[] data = new byte[1024];
            int readLen = 0;
            while ((readLen = fileInputStream.read(data)) != -1) {
                //边度编写
                bufferedOutputStream.write(data);
            }
        } else {
            //不进行操作
            outputStream.write("你说啥呢".getBytes());
            outputStream.close();
        }
        bufferedOutputStream.close();
        fileInputStream.close();
        bufferedReader.close();
        socket.close();
        serverSocket.close();
    }
}

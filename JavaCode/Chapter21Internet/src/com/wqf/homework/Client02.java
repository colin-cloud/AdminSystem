package com.wqf.homework;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Client02 {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket(InetAddress.getByName("192.168.1.7"), 9999);
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        //写入数据
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个音乐文件名:>");
        String musicFile = scanner.next();
        bufferedWriter.write(musicFile);
        bufferedWriter.newLine();
        bufferedWriter.flush();

        //接收文件
        InputStream inputStream = socket.getInputStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        FileOutputStream fileOutputStream = new FileOutputStream("src\\坦克大战.wav");
        byte[] data = new byte[1024];
        int readLen = 0;
        while ((readLen = bufferedInputStream.read(data)) != -1) {
            fileOutputStream.write(data);
        }
        fileOutputStream.close();
        bufferedInputStream.close();
        bufferedWriter.close();
        socket.close();
    }
}

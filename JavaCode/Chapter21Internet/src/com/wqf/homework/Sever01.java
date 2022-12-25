package com.wqf.homework;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Sever01 {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(9999);
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String readData = "";
        readData = bufferedReader.readLine();
        System.out.println(readData);
        OutputStream outputStream = accept.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("我是nova");
        bufferedWriter.newLine();
        bufferedWriter.flush();
        readData = bufferedReader.readLine();
        System.out.println(readData);
        bufferedWriter.write("编写java程序");
        bufferedWriter.newLine();
        bufferedWriter.flush();

        bufferedWriter.close();
        bufferedReader.close();
        accept.close();
        serverSocket.close();
    }
}

package com.wqf.homework;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Client01 {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        bufferedWriter.write("name");
        bufferedWriter.newLine();
        bufferedWriter.flush();
        System.out.println(bufferedReader.readLine());
        bufferedWriter.write("hobby");
        bufferedWriter.newLine();
        bufferedWriter.flush();
        System.out.println(bufferedReader.readLine());
        bufferedReader.close();
        bufferedWriter.close();
        socket.close();
    }
}

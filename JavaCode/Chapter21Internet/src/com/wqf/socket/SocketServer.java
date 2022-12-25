package com.wqf.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 小白学java
 * @version 1.0
 */
public class SocketServer {

    public static void main(String[] args) throws IOException {
        //1. 在本机的8888端口监听，等待连接
        //要求：本机没有其他服务在监听8888端口
        //ServerSocket可以通过accept方法返回多个Socket(多个客户端连接服务器的并发)
        ServerSocket serverSocket = new ServerSocket(8888);
        //2. 当没有客户端连接8888端口时，程序会阻塞，等待连接
        //如果有客户端连接，就会返回一个Socket对象，程序继续
        Socket socket = serverSocket.accept();
        //3. 通过socket.getInputStream()读取客户端写入的数据，显示，得到输出流输出信息
        InputStream inputStream = socket.getInputStream();
        //将图片拷贝到相应的路径
        String destPath = "src\\xiao.webp";
        //得到一个文件输出流
        FileOutputStream fileOutputStream = new FileOutputStream(destPath);
        //拷贝图片
        byte[] bytes = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(bytes)) != -1) {
            fileOutputStream.write(bytes);
        }
        //刷新才能写入成功，否则还在程序中
        fileOutputStream.flush();
        //需求：向客户端输出数据
        //1. 得到一个字符输出流
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        //2. 输出数据
        bufferedWriter.write("收到图片");
        //3. 以新的一行作为结束标记
        bufferedWriter.newLine();
        //4. 关闭相应的流
        bufferedWriter.close();
        fileOutputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}

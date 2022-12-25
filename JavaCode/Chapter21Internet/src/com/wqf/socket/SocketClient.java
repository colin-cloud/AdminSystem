package com.wqf.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author 小白学java
 * @version 1.0
 */
public class SocketClient {

    public static void main(String[] args) throws IOException {
        //1. 连接服务端(ip, 端口)
        //连接本机的8888端口,如果连接成功就返回Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        //2. 连接上后，生成Socket，通过socket.getOutputStream()得到与socket相关联的输出流，得到输入流
        OutputStream outputStream = socket.getOutputStream();
        //从相应的路径的文件中读取图片
        String filePath = "C:\\Users\\wwww\\Pictures\\Saved Pictures\\xiao.webp";
        //得到一个文件输入流
        FileInputStream fileInputStream = new FileInputStream(filePath);
        //读取图片
        byte[] bytes = new byte[1024];
        int readLen = 0;
        while ((readLen = fileInputStream.read(bytes)) != -1) {
            //3. 通过输出流，写入数据到数据通道
            outputStream.write(bytes);
        }
        //输出标识
        socket.shutdownOutput();
        //通过socket对象得到一个字节输入流
        InputStream inputStream = socket.getInputStream();
        //转换成字符输入流
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        //以readLine方法读取相应的数据，标识相应的服务端的输出结束
        System.out.println(bufferedReader.readLine());
        //4. 关闭流对象和socket，必须关闭，建议后创建的流先关闭
        bufferedReader.close();
        fileInputStream.close();
        outputStream.close();
        socket.close();
    }
}

package com.wqf.qqClientcommon.service;

import com.wqf.qqServer.qqcommon.Message;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * @author 小白学java
 * @version 1.0
 */
public class ClientConServerThread extends Thread {
    //定义一个Socket对象
    private Socket socket;
    //构造器
    public ClientConServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while (true) {
            //一直读取服务端传过来的信息
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                //如果没有信息传入，则线程会阻塞
                Message message = (Message) objectInputStream.readObject();
                //如果从服务端读取到返回用户列表的信息
                if (message.getMesType().equals(message.MESSAGE_RETURN_ONLINE_LIST)) {
                    //返回的信息中内容是用户的UID，以空格相间
                    String[] onlineUserList = message.getContent().split(" ");
                    //遍历数组打印信息
                    System.out.println("=======在线用户列表如下========");
                    for (String uid : onlineUserList) {
                        System.out.println("用户 : " + uid);
                    }
                } else if (message.getMesType().equals(message.MESSAGE_EXIT)){
                    //退出系统信息
                    //退出循环,关闭资源
                    socket.close();
                    break;
                } else if (message.getMesType().equals(message.MESSAGE_ORDINARY)) {
                    //显示信息的内容
                    System.out.println("\n" + message.getSender() + ": " + message.getContent()
                            + " 时间 :" + message.getSendTime());
                } else if (message.getMesType().equals(message.MESSAGE_COMMON_ALL)) {
                    //群发消息的内容
                    System.out.println("\n" + message.getSender() + "向所有人发出消息: " + message.getContent()
                            + "\t时间 :" + message.getSendTime());
                } else if (message.getMesType().equals(message.MESSAGE_FILE_SEND)) {
                    System.out.println("\n用户:" + message.getSender()
                            + " 向用户:" + message.getReceiver() + "传输了一个文件...");
                    //读取文件
                    byte[] bytes = message.getBytes();
                    BufferedOutputStream bufferedOutputStream = null;
                    FileOutputStream fileOutputStream = null;
                    fileOutputStream = new FileOutputStream(message.getFilePathDest());
                    bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                    //输出文件
                    bufferedOutputStream.write(bytes);
                    bufferedOutputStream.close();
                } else if (message.getMesType().equals(message.MESSAGE_SYSTEM)) {
                    //系统推送消息
                    System.out.println("\n" + message.getSender() + "推送消息: "
                            + message.getContent() + "\t时间: " + message.getSendTime());
                } else if (message.getMesType().equals(message.MESSAGE_OFFLINE)) {
                    System.out.println("\n用户: " + message.getSender() + "在你离线时发送消息: " + message.getContent());
                } else if (message.getMesType().equals(message.MESSAGE_OFFLINE_FILE)) {
                    System.out.println("\n有人" + " 向用户:" + message.getReceiver() + "传输了一个文件...");
                    //读取文件
                    byte[] bytes = message.getBytes();
                    BufferedOutputStream bufferedOutputStream = null;
                    FileOutputStream fileOutputStream = null;
                    fileOutputStream = new FileOutputStream(message.getFilePathDest());
                    bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                    //输出文件
                    bufferedOutputStream.write(bytes);
                    bufferedOutputStream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
}

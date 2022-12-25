package com.wqf.qqClientcommon.service;

import com.wqf.qqServer.qqcommon.Message;
import com.wqf.qqServer.qqcommon.User;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

import java.util.Date;

/**
 * @author 小白学java
 * @version 1.0
 */
public class ClientService {
    //定义一个User对象
    private User user = new User();
    //定义一个Socket对象
    private Socket socket;
    //判断登录是否成功
    public boolean isLogin(String userId, String password) {
        boolean bool = false;
        //将用户信息进行封装
        user.setUserId(userId);
        user.setPassword(password);
        //与服务端进行对接
        try {
            socket = new Socket(InetAddress.getByName("192.168.1.5"), 9999);
            //传输User对象
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(user);
            //接收来自服务端的Message对象
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            Message message = (Message) objectInputStream.readObject();
            //判断接收回来的Message对象是否符合要求
            if (message.getMesType().equals(message.MESSAGE_LOGIN_SUCCEED)) {
                bool = true;
                //写一个类启动Socket线程,socket要一直从服务端中读取信息和写信息
                //登陆成功,创建线程
                ClientConServerThread clientConServerThread = new ClientConServerThread(socket);
                clientConServerThread.start();
                //向hashmap中添加socket对象
                ManageSocketThread.addThread(userId, clientConServerThread);
            } else {
                //登陆失败, 关闭socket等相关资源
                //关闭了socket就关闭了由它创建的流
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (bool) {
            Message message = new Message();
            message.setMesType(message.MESSAGE_OFFLINE);
            message.setSender(user.getUserId());

            Message message1 = new Message();
            message1.setMesType(message1.MESSAGE_OFFLINE_FILE);
            message1.setReceiver(user.getUserId());
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                objectOutputStream.writeObject(message);
                ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(socket.getOutputStream());
                objectOutputStream1.writeObject(message1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bool;
    }
    //向服务端发送接收用户列表的信息
    public void sendMesToGetList() {
        //先定义发送的消息
        Message message = new Message();
        message.setMesType(message.MESSAGE_GET_ONLINE_LIST);
        message.setSender(user.getUserId());
        //得到输出流
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            //输出信息
            objectOutputStream.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //向服务端发送信息表示退出客户端
    public void sendMesToExit() {
        //得到一个信息,设置相关信息
        Message message = new Message();
        message.setSender(user.getUserId());
        message.setMesType(message.MESSAGE_EXIT);
        try {
            //得到输出流
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(message);
            System.exit(0);//结束进程
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //向另一个客户端发送信息
    public void sendMesToUser(String userName, String content) {
        //定义一个信息
        Message message = new Message();
        message.setSender(user.getUserId());
        message.setReceiver(userName);
        message.setContent(content);
        message.setMesType(message.MESSAGE_ORDINARY);
        message.setSendTime(new Date().toString());
        try {
            //发送信息
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //向所有人发送消息
    public void sendMesToAllPeople(String content) {
        //定义信息对象
        Message message = new Message();
        message.setMesType(message.MESSAGE_COMMON_ALL);
        message.setContent(content);
        message.setSender(user.getUserId());
        message.setReceiver("所有人");
        message.setSendTime(new Date().toString());
        //发送给服务端
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //向另一个客户端发送文件
    public void sendFileToUser(String filePathMine, String filePathAnother, String UID) {
        //定义一个信息
        Message message = new Message();
        message.setSender(user.getUserId());
        message.setReceiver(UID);
        message.setMesType(message.MESSAGE_FILE_SEND);
        message.setSendTime(new Date().toString());
        message.setFilePathDest(filePathAnother);
        message.setFilePathSrc(filePathMine);
        //从文件路径中读取文件
        //定义一个byte数组读取文件信息
//        byte[] bytes = new byte[1024];
//        byte[] bytes1 = null;
//        byte[] data = null;
//        int readLen = 0;
//        int saveReadLen = readLen;
//        int saveArrLen = 0;
//        boolean bool = true;
        //定义一个数组接纳文件信息
        byte[] data = new byte[(int) new File(filePathMine).length()];
        BufferedInputStream bufferedInputStream = null;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePathMine);
            bufferedInputStream = new BufferedInputStream(fileInputStream);
//            while ((readLen = bufferedInputStream.read(bytes)) != -1) {
//                if (bool) {
//                    bytes1 = Arrays.copyOf(bytes, readLen);
//                } else {
//                    for (int i = 0; i < readLen; i++) {
//                        bytes1[saveArrLen + i] = bytes[i];
//                    }
//                }
//                if (readLen == 1024) {
//                    saveArrLen = bytes1.length;
//                    bytes1 = Arrays.copyOf(bytes1, bytes1.length + 1024);
//                }
//                bool = false;
//                saveReadLen = readLen;
//            }
//            if (saveReadLen == 1024) {
//                data = bytes1;
//            } else {
//                data = Arrays.copyOf(bytes1, bytes1.length + saveReadLen - 1024);
//            }
            fileInputStream.read(data);
            message.setBytes(data);
            //读取完毕
            //传输信息
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

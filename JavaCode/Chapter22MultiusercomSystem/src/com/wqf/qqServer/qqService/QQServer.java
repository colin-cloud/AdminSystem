package com.wqf.qqServer.qqService;

import com.wqf.qqServer.qqcommon.Message;
import com.wqf.qqServer.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author 小白学java
 * @version 1.0
 */
public class QQServer extends Thread {
    //定义一个输入器
    Scanner scanner = new Scanner(System.in);
    //定义一个bool
    boolean bool = true;
    //定义一个ServerSocket对象
    private ServerSocket serverSocket;
    //创建一个集合，存放多个用户
    private static HashMap<String ,User> hashMap = new HashMap<>();
    //也可以使用ConcurrentHashMap，可以处理并发的集合，没有线程安全问题
    //private static ConcurrentHashMap<String ,User> hashMap = new HashMap<>();
    //HashMap没有处理线程安全，即没有做线程同步处理，在多线程情况下是不安全的

    static {
        //使用静态代码块对hashMap进行初始化，允许多个用户进行登录
        hashMap.put("100", new User("100", "123456"));
        hashMap.put("至尊宝", new User("至尊宝", "123456"));
        hashMap.put("紫霞仙子", new User("紫霞仙子", "123456"));
    }

    //判断用户合法性
    private boolean isLegalUser(String userId, String password) {
        //找不到该UID
        if (hashMap.get(userId) == null) {
            return false;
        }
        //密码不正确
        if (!hashMap.get(userId).getPassword().equals(password)) {
            return false;
        }
        return true;
    }
    public QQServer() {
        try {
            //创建serverSocket对象，监听9999窗口
            System.out.println("服务端在9999端口进行监听");
            serverSocket = new ServerSocket(9999);
            this.start();
//            if (!bool) {
//                this.c
//            }
            while (true) {
                //创建Socket对象
                Socket socket = serverSocket.accept();
                //通过socket对象读取User,如果没有User可以读取，就会阻塞在读取阶段
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                User user = (User) objectInputStream.readObject();
                //判断user的合法性
                //创建一个Message对象，记录信息
                Message message = new Message();
                //创建一个对象输出流
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                if (isLegalUser(user.getUserId(), user.getPassword())) {
                    //返回一个带有成功登录的信息
                    message.setMesType(message.MESSAGE_LOGIN_SUCCEED);
                    //输出该信息
                    objectOutputStream.writeObject(message);
                    //连接成功,启动该线程
                    //创建一个服务端连接成功客户端的类，将socket连接客户端在类中启动线程
                    //启动线程
                    ServerConClientThread serverConClientThread = new ServerConClientThread(user.getUserId(), socket);
                    serverConClientThread.start();
                    //把该线程对象放入一个集合中进行管理
                    //写一个类对线程进行封装
                    //向集合中添加线程
                    ManageSocketThread.addThread(user.getUserId(), serverConClientThread);
                } else {
                    //返回一个带有登陆失败的信息
                    System.out.println("用户" + user.getUserId() + "登陆失败");
                    message.setMesType(message.MESSAGE_LOGIN_FAIL);
                    //输出信息
                    objectOutputStream.writeObject(message);
                    //关闭局部资源
                    socket.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //如果退出了循环，就关闭资源
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMesAllClient(String content) {
        //得到线程集合
        Collection<ServerConClientThread> values = ManageSocketThread.getHashMap().values();
        //遍历线程集合
        for (ServerConClientThread thread : values) {
            //向客户端发送消息
            Message message = new Message();
            message.setSender("系统推送");
            message.setReceiver(thread.getUserId());
            message.setSendTime(new Date().toString());
            message.setContent(content);
            message.setMesType(message.MESSAGE_SYSTEM);
            //得到输出流
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(thread.getSocket().getOutputStream());
                objectOutputStream.writeObject(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //可以选择再写一个类继承Thread，开启相关线程，类似于群发文件
    @Override
    public void run() {
        while (bool) {
            System.out.print("请输入推送的消息: ");
            String content = scanner.next();
            if (content.equals("exit")) {
                bool = false;
                break;
            }
            sendMesAllClient(content);
        }
    }

    public static HashMap<String, User> getHashMap() {
        return hashMap;
    }
}

package com.wqf.qqServer.qqService;

import com.wqf.qqServer.qqcommon.Message;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

/**
 * @author 小白学java
 * @version 1.0
 */
public class ServerConClientThread extends Thread {
    //定义一个socket对象，确定要进行线程的对象
    private Socket socket;
    //定义一个String对象，确定用户名
    private String userId;
    private SendOfflineMessage offlineMessage = new SendOfflineMessage();
    private SendOfflineFile offlineFile = new SendOfflineFile();

    public ServerConClientThread(String userId, Socket socket) {
        this.socket = socket;
        this.userId = userId;
    }

    @Override
    public void run() {
        //要一直读取信息
        while (true) {
            try {
                //从客户端中读取信息
                System.out.println("服务端和客户端(用户)" + userId + "保持通讯...");
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) objectInputStream.readObject();
                //对信息进行操作
                //如果返回的信息的想要读取用户列表
                if (message.getMesType().equals(message.MESSAGE_GET_ONLINE_LIST)) {
                    System.out.println("用户 " + message.getSender() + "想要获取用户列表信息...");
                    //返回在线用户列表的信息
                    //定义一个信息存储者相应的内容
                    Message message1 = new Message();
                    message1.setMesType(message1.MESSAGE_RETURN_ONLINE_LIST);
                    //从hashmap中读取key
                    HashMap<String, ServerConClientThread> hashMap = ManageSocketThread.getHashMap();
                    Set<String> userIds = hashMap.keySet();
                    String str = "";
                    //将信息进行整合
                    for (String uid : userIds) {
                        str += uid + " ";
                    }
                    message1.setContent(str);
                    message1.setReceiver(message.getSender());
                    //发送信息
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                    objectOutputStream.writeObject(message1);
                } else if (message.getMesType().equals(message.MESSAGE_EXIT)){
                    //用户想要退出系统
                    //定义一个信息，回发给客户端
                    Message message1 = new Message();
                    message1.setReceiver(message.getSender());
                    message1.setMesType(message1.MESSAGE_EXIT);
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                    //发送信息
                    objectOutputStream.writeObject(message1);
                    //退出线程
                    System.out.println("客户端用户(用户)" + userId + "退出了系统...");
                    ManageSocketThread.removeSocket(userId);
                    socket.close();
                    break;
                } else if (message.getMesType().equals(message.MESSAGE_ORDINARY)) {
                    //读取的是普通信息,发送给接受者
                    String userId = message.getReceiver();
                    //判断接受者是否在线，如果不在线就等在线时在发送
                    if (ManageSocketThread.getThread(userId) != null) {
                        //用户在线
                        //从hashmap集合中找到该对象
                        ServerConClientThread thread = ManageSocketThread.getThread(userId);
                        //得到该对象的一个线程，从而得到socket
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream
                                (thread.getSocket().getOutputStream());
                        //发送该信息
                        objectOutputStream.writeObject(message);//如果离线，就将信息写到数据库形成离线留言
                    } else {
                        //用户不在线，将信息重新进行设置，利用服务端存储信息，等用户上线后在发送
                        message.setMesType(message.MESSAGE_OFFLINE);
                        SendOfflineMessage.addToMap(message, message.getReceiver());
                    }
                } else if (message.getMesType().equals(message.MESSAGE_COMMON_ALL)) {
                    //客户端要群发消息
                    //得到存放线程的集合
                    Collection<ServerConClientThread> values = ManageSocketThread.getHashMap().values();
                    for (ServerConClientThread thread : values) {
                        //如果是发送者本人，则跳过发送信息
                        if (thread.getUserId().equals(userId)) {
                            continue;
                        }
                        //向所有人发送信息
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream
                                (thread.socket.getOutputStream());
                        objectOutputStream.writeObject(message);
                    }
                } else if (message.getMesType().equals(message.MESSAGE_FILE_SEND)) {
                    //发送文件
                    if (ManageSocketThread.getThread(message.getReceiver()) != null) {
                        ServerConClientThread thread = ManageSocketThread.getHashMap().get(message.getReceiver());
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(thread.getSocket().getOutputStream());
                        objectOutputStream.writeObject(message);
                    } else {
                        message.setMesType(message.MESSAGE_OFFLINE_FILE);
                        SendOfflineFile.setFilePathDest(message.getFilePathDest());
                        SendOfflineFile.addFileToMap(message.getBytes(), message.getReceiver());
                    }
                } else if (message.getMesType().equals(message.MESSAGE_OFFLINE)) {
                    //处理离线信息
                    offlineMessage.start();
                } else if (message.getMesType().equals(message.MESSAGE_OFFLINE_FILE)) {
                    offlineFile.start();
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

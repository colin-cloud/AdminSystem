package com.wqf.qqServer.qqService;

import com.wqf.qqServer.qqcommon.Message;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Set;

/**
 * @author 小白学java
 * @version 1.0
 */
public class SendOfflineMessage extends Thread {
    //定义一个集合来存储离线信息
    private static HashMap<Message, String> hashMap = new HashMap<>();
    //定义一个socket
    private Socket socket;
    //向集合中添加对象
    public static void addToMap(Message message, String userId) {
        hashMap.put(message, userId);
    }
    //移除对应集合元素
    public static void removeMesFromMap(Message message) {
        hashMap.remove(message);
    }

    @Override
    public void run() {
        while (true) {
            if (hashMap.size() != 0) {
                //集合中有元素
                //取出集合中的key
                Set<Message> messages = hashMap.keySet();
                for (Message message : messages) {
                    setSocket(ManageSocketThread.getThread(hashMap.get(message)).getSocket());
                    if (socket != null) {
                        try {
                            //传输信息
                            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                            objectOutputStream.writeObject(message);
                            //删除信息
                            hashMap.remove(message);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                //集合中没有元素
                break;
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

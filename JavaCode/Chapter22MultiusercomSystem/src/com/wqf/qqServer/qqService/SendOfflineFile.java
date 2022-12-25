package com.wqf.qqServer.qqService;

import com.wqf.qqServer.qqcommon.Message;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Set;

/**
 * @author 小白学java
 * @version 1.0
 */
public class SendOfflineFile extends Thread {
    //定义一个集合来存储离线文件
    private static HashMap<byte[], String> map = new HashMap<>();
    private Socket socket;
    private static String filePathDest;
    //添加元素
    public static void addFileToMap(byte[] bytes, String userId) {
        map.put(bytes, userId);
    }

    @Override
    public void run() {
        while (true) {
            if (map.size() != 0) {
                //得到key集合
                Set<byte[]> bytes = map.keySet();
                for (byte[] bytes1 : bytes) {
                    setSocket(ManageSocketThread.getThread(map.get(bytes1)).getSocket());
                    if (socket != null) {
                        try {
                            Message message = new Message();
                            message.setMesType(message.MESSAGE_OFFLINE_FILE);
                            message.setBytes(bytes1);
                            message.setReceiver(map.get(bytes1));
                            message.setFilePathDest(filePathDest);
                            //传输信息
                            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                            objectOutputStream.writeObject(message);
                            //删除数组
                            map.remove(bytes1);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
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

    public static String getFilePathDest() {
        return filePathDest;
    }

    public static void setFilePathDest(String filePathDest) {
        SendOfflineFile.filePathDest = filePathDest;
    }
}

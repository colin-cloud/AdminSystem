package com.wqf.qqServer.qqService;

import java.util.HashMap;

/**
 * @author 小白学java
 * @version 1.0
 */
public class ManageSocketThread {
    //定义一个hashmap对服务端的socket线程进行管理
    private static HashMap<String, ServerConClientThread> hashMap = new HashMap<>();
    //向集合中添加对象
    public static void addThread(String userId, ServerConClientThread serverConClientThread) {
        hashMap.put(userId, serverConClientThread);
    }
    //从集合中得到线程对象
    public static ServerConClientThread getThread(String userId) {
        return hashMap.get(userId);
    }
    //得到集合
    public static HashMap<String, ServerConClientThread> getHashMap() {
        return hashMap;
    }
    //移除相应的socket
    public static void removeSocket(String userId) {
        hashMap.remove(userId);
    }
}

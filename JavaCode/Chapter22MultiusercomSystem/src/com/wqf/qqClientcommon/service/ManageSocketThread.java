package com.wqf.qqClientcommon.service;

import java.util.HashMap;

/**
 * @author 小白学java
 * @version 1.0
 */
public class ManageSocketThread {
    //管理多个Socket线程
    private static HashMap<String, ClientConServerThread> hashMap = new HashMap<>();
    //向hashmap中添加元素
    public static void addThread(String userId, ClientConServerThread clientConServerThread) {
        hashMap.put(userId, clientConServerThread);
    }
    //从hashmap中得到value
    public static ClientConServerThread getThread(String userId) {
        return hashMap.get(userId);
    }
}

package com.wqf.properties;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Properties;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Properties01 {

    public static void main(String[] args) {


    }
    @Test
    public void useMysqlProperties() throws IOException {

        //1. 创建Properties对象
        Properties properties = new Properties();
        //2. 加载指定配置文件
        properties.load(new FileReader("src\\mysql.properties"));
        //3. 把键值对显示在控制台
        properties.list(System.out);
        //4. 根据键来获取值
        String user = properties.getProperty("user");
        String pwd = properties.getProperty("pwd");
        System.out.println(user + " " + pwd);
        //使用properties来创建配置文件，修改配置文件内容
        //1. 创建.如果该文件没有key就创建，有则修改
        properties.setProperty("charset", "utf-8");
        properties.setProperty("user", "汤姆");
        properties.setProperty("pwd", "abc111");
        properties.store(new FileOutputStream("src\\mysql1.properties"), null);
        /**
         * setProperty的源码
         * public synchronized V put(K key, V value) {
         *         // Make sure the value is not null
         *         if (value == null) {
         *             throw new NullPointerException();
         *         }
         *
         *         // Makes sure the key is not already in the hashtable.
         *         Entry<?,?> tab[] = table;
         *         int hash = key.hashCode();
         *         int index = (hash & 0x7FFFFFFF) % tab.length;
         *         @SuppressWarnings("unchecked")
         *         Entry<K, V> entry = (Entry<K,V>)tab[index];
         *         for(; entry != null ; entry = entry.next) {
         *             if ((entry.hash == hash) && entry.key.equals(key)) {
         *                 V old = entry.value;
         *                 entry.value = value;
         *                 return old;
         *             }
         *         }
         *
         *         addEntry(hash, key, value, index);
         *         return null;
         *     }
         */
    }
}

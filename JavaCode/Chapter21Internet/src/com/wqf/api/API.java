package com.wqf.api;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author 小白学java
 * @version 1.0
 */
public class API {

    public static void main(String[] args) throws UnknownHostException {

        //获取本机的InetAddress对象
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);//LAPTOP-LRLN5JIP/192.168.1.7 主机名/IP地址
        //根据指定主机名获取InetAddress对象
        InetAddress localHost1 = InetAddress.getByName("LAPTOP-LRLN5JIP");
        System.out.println(localHost1);
        //根据域名返回一个InetAddress对象
        InetAddress inetAddress = InetAddress.getByName("www.baidu.com");
        System.out.println(inetAddress);
        //根据InetAddress对象获取对应地址
        String hostAddress = localHost1.getHostAddress();
        System.out.println(hostAddress);
        //根据InetAddress对象获取对应主机名/域名
        String hostName = inetAddress.getHostName();
        System.out.println(hostName);
    }
}

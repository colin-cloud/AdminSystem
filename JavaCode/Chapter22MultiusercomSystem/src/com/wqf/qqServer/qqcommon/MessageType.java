package com.wqf.qqServer.qqcommon;

/**
 * @author 小白学java
 * @version 1.0
 */
public interface MessageType {
    //1. 在接口中定义一些常量
    //2. 不同的常量值代表了不同的消息类型
    String MESSAGE_SYSTEM = "0";//系统推送消息
    String MESSAGE_LOGIN_SUCCEED = "1";//表示登录成功
    String MESSAGE_LOGIN_FAIL = "2";//表示登陆失败
    String MESSAGE_ORDINARY = "3";//返回普通信息
    String MESSAGE_GET_ONLINE_LIST = "4";//传输用户列表
    String MESSAGE_RETURN_ONLINE_LIST = "5";//返回用户列表信息
    String MESSAGE_EXIT = "6";//系统退出信息
    String MESSAGE_COMMON_ALL = "7";//群发消息
    String MESSAGE_FILE_SEND = "8";//发送文件
    String MESSAGE_OFFLINE = "9";//处理离线信息
    String MESSAGE_OFFLINE_FILE = "10";//处理离线文件
}

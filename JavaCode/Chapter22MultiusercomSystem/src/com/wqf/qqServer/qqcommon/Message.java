package com.wqf.qqServer.qqcommon;

import java.io.Serializable;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Message implements Serializable,MessageType {
    //通过网络传输的信息对象
    private String sender;//消息的发起者
    private String receiver;//消息的接受者
    private String content;//消息的内容
    private String sendTime;//消息发送时间
    private String mesType;//消息的内容类型
    private String filePathSrc;//文件路径
    private String filePathDest;//传入文件路径
    private byte[] bytes;//传输文件的数组

    public String getFilePathSrc() {
        return filePathSrc;
    }

    public void setFilePathSrc(String filePathSrc) {
        this.filePathSrc = filePathSrc;
    }

    public String getFilePathDest() {
        return filePathDest;
    }

    public void setFilePathDest(String filePathDest) {
        this.filePathDest = filePathDest;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getMesType() {
        return mesType;
    }

    public void setMesType(String mesType) {
        this.mesType = mesType;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

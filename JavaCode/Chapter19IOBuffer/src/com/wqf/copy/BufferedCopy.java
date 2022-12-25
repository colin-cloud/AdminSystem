package com.wqf.copy;

import java.io.*;

/**
 * @author 小白学java
 * @version 1.0
 */
public class BufferedCopy {

    public static void main(String[] args) throws Exception {

        //实现图片的拷贝
        String srcFilePath = "c:\\Users\\wwww\\Pictures\\Saved Pictures\\broliya.jpg";
        String destFilePath = "d:\\JAVA入门\\JavaCode\\Chapter19IOBuffer\\bigSister.jpg";
        //创建对象
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(srcFilePath));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destFilePath));
        //读取内容
        byte[] readData = new byte[1024];
        int readLen = 0;
        while ((readLen = bufferedInputStream.read(readData)) != -1) {
            bufferedOutputStream.write(readData, 0, readLen);
        }
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }
}

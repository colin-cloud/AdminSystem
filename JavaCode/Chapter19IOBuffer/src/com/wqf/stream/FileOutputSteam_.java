package com.wqf.stream;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 小白学java
 * @version 1.0
 */
public class FileOutputSteam_ {

    public static void main(String[] args) {


    }
    @Test
    public void writeFile() throws IOException {
        //将数据写入文件
        String filePath = "d:\\JAVA入门\\JavaCode\\Chapter19IOBuffer\\writeFile.txt";
        FileOutputStream fileOutputStream = null;
        try {
            //得到FileOutputStream对象,该创建方式是：当写入内容时，会覆盖原来的内容
//            fileOutputStream = new FileOutputStream(filePath);
            //该种方法不会覆盖原来内容，相当于字符串追加
            fileOutputStream = new FileOutputStream(filePath, true);
            //写入一个字节
//            fileOutputStream.write('w');
            //写入一个字符串
            String str = "hello, world!";
            //str.getBytes()字符串转成byte数组
//            fileOutputStream.write(str.getBytes());
            //指定偏移量写入字符串
            fileOutputStream.write(str.getBytes(), 0, 5);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            //关闭文件流
            fileOutputStream.close();
        }
    }
}

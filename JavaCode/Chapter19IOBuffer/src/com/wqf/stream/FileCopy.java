package com.wqf.stream;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 小白学java
 * @version 1.0
 */
public class FileCopy {

    public static void main(String[] args) {


    }
    @Test
    public void copyFile() throws IOException {
        //完成文件拷贝
        //1. 创建文件输入流，将文件读入到程序
        //2. 创建文件输出流，将文件写入到磁盘中
        //3. 在完成程序时，应该是读取部分数据就写入到指定文件，即使用循环
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        String srcFilePath = "c:\\Users\\wwww\\Pictures\\Saved Pictures\\mei.webp";
        String destFilePath = "d:\\JAVA入门\\JavaCode\\Chapter19IOBuffer\\mei1.webp";
        try {
            fileInputStream = new FileInputStream(srcFilePath);
            fileOutputStream = new FileOutputStream(destFilePath, true);
            byte[] buffer = new byte[1024];
            int readLength = 0;
            while ((readLength = fileInputStream.read(buffer)) != -1) {
                //只能使用该种方法，以防多读
                fileOutputStream.write(buffer, 0, readLength);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            fileInputStream.close();
            fileOutputStream.close();
        }
    }
}

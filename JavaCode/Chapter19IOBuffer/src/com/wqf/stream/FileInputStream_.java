package com.wqf.stream;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author 小白学java
 * @version 1.0
 */
public class FileInputStream_ {

    public static void main(String[] args) {

        //FileInputStream的使用

    }
    @Test
    public void readFile() throws IOException {
        String filePath = "d:\\JAVA入门\\JavaCode\\Chapter19IOBuffer\\hello.txt";
        FileInputStream fileInputStream = null;
        int read = 0;
        byte[] readData = new byte[8];
        int readLength = 0;
        try {
            //创建FileInputStream对象，用于读取文件
            fileInputStream = new FileInputStream(filePath);
            // 使用read()效率较低
            while ((read = fileInputStream.read()) != -1) {
                System.out.println((char)read);
            }
            // 使用read(byte[] buffer)
            while ((readLength = fileInputStream.read(readData)) != -1) {
                System.out.print(new String(readData, 0 , readLength));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流,释放资源
            fileInputStream.close();
        }
    }
}

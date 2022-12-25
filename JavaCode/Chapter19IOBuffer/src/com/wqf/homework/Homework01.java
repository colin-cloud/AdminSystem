package com.wqf.homework;

import java.io.*;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Homework01 {

    public static void main(String[] args) throws IOException {

        String filePath = "d:\\JAVA入门\\JavaCode\\Chapter19IOBuffer\\myTemp";
        File file = new File(filePath);
        if (!(file.exists())) {
            file.mkdirs();
        }
        File file1 = new File(filePath + "\\hello.txt");
        if (file1.exists()) {
            System.out.println("存在");
        } else {
            file1.createNewFile();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file1));
            bufferedOutputStream.write("hello,world".getBytes());
            bufferedOutputStream.close();
        }
    }
}

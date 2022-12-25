package com.wqf.stream;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Writer;
import java.util.Locale;

/**
 * @author 小白学java
 * @version 1.0
 */
public class FileReader_ {

    public static void main(String[] args) {


    }
    @Test
    public void charReadFile() throws IOException {

        //创建FileReader对象
        FileReader fileReader = null;
        char[] readData = new char[1024];
        //一次读取字符的个数
        int readLength = 0;
        //使用字符数组循环读取字符
        String filePath = "d:\\JAVA入门\\JavaCode\\Chapter19IOBuffer\\exercise.txt";
        try {
            fileReader = new FileReader(filePath);
            while ((readLength = fileReader.read(readData)) != -1) {
                System.out.print(new String(readData, 0, readLength));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            //关闭输入流
            fileReader.close();
        }
    }
}

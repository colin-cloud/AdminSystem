package com.wqf.file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author 小白学java
 * @version 1.0
 */
public class FileCreate {

    public static void main(String[] args) {


    }
    //方式1 new File(String pathname)
    @Test
    public void create01() {
        String filePath = "d:\\JAVA入门\\JavaCode\\Chapter19IOBuffer\\news1.txt";
        File file = new File(filePath);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //方式2 new File(File parent, String child)
    @Test
    public void create02() {
        File patentFile = new File("d:\\JAVA入门\\JavaCode\\Chapter19IOBuffer\\");
        String fileName = "news2.txt";
        //这里的file对象在java程序中，只有执行了file.createNewFile()才会真正在磁盘创建文件
        File file = new File(patentFile, fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //方式3 new File(String parent, String child)
    @Test
    public void create03() {
        String parentPath = "d:\\JAVA入门\\JavaCode\\Chapter19IOBuffer\\";
        String fileName = "news3.txt";
        File file = new File(parentPath, fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

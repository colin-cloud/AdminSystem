package com.wqf.file;

import java.io.File;

/**
 * @author 小白学java
 * @version 1.0
 */
public class FileInformation {

    public static void main(String[] args) {


    }
    //获取文件的信息
    public void getInformation() {
        //先创建文件对象
        File file = new File("d:\\JAVA入门\\JavaCode\\Chapter19IOBuffer\\news1.txt");
        //调用相应的方法得到对应信息
        System.out.println(file.getName());//得到文件名字
        System.out.println(file.getAbsoluteFile());//得到绝对路径
        System.out.println(file.getParent());//得到父级目录
        System.out.println(file.length());//得到文件的大小(字节)
        System.out.println(file.exists());//是否存在
        System.out.println(file.isFile());//是不是文件
        System.out.println(file.isDirectory());//是不是目录
    }
}

package com.wqf.seralizable;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @author 小白学java
 * @version 1.0
 */
public class ObjectStream_ {

    public static void main(String[] args) {


    }
    @Test
    public void isOrNotSerializableObject() throws Exception {

        //保存到文件的路径
        String filePath = "D:\\JAVA入门\\JavaCode\\Chapter19IOBuffer\\data.dat";
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
        //序列化数据到文件中
        objectOutputStream.writeInt(100);
        objectOutputStream.writeBoolean(true);
        objectOutputStream.writeChar('a');
        objectOutputStream.writeDouble(30.0);
        objectOutputStream.writeUTF("小王");
        objectOutputStream.writeObject(new Dog("小黄", 3));
        objectOutputStream.close();
        //反序列化到程序中
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath));
        //读取的顺序需要和保存数据一致
        int read = objectInputStream.readInt();
        boolean bool = objectInputStream.readBoolean();
        char ch = objectInputStream.readChar();
        double aDouble = objectInputStream.readDouble();
        String str = objectInputStream.readUTF();
        Object obj = objectInputStream.readObject();
        objectInputStream.close();
    }
}

class Dog implements Serializable {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

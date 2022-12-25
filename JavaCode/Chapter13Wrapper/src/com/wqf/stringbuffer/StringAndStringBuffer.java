package com.wqf.stringbuffer;

/**
 * @author 小白学java
 * @version 1.0
 */
public class StringAndStringBuffer {

    public static void main(String[] args) {

        //String -> StringBuffer
        String str = "hello, world";
        //使用构造器
        StringBuffer stringBuffer = new StringBuffer(str);
        //使用append方法
        StringBuffer stringBuffer1 = new StringBuffer();
        stringBuffer1 = stringBuffer1.append(str);
        //StringBuffer -> String
        StringBuffer stringBuffer2 = new StringBuffer("wqf");
        //使用StringBuffer提供的toString方法
        String str1 = stringBuffer2.toString();
        //使用构造器
        String str2 = new String(stringBuffer2);

    }
}

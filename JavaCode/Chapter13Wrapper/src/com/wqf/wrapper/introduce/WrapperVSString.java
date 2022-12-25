package com.wqf.wrapper.introduce;

/**
 * @author 小白学java
 * @version 1.0
 */
public class WrapperVSString {

    public static void main(String[] args) {

        //包装类(Integer)->String
        Integer i = 100;
        //转成字符串
        String str1 = i + "";
        String str2 = i.toString();
        String str3 = String.valueOf(i);
        //String -> 包装类(Integer)
        String str4 = "123";
        Integer i1 = Integer.parseInt(str4);//int parseInt(String str)方式，使用到了自动装箱
        Integer i2 = new Integer(str4);//构造器的方式
    }
}

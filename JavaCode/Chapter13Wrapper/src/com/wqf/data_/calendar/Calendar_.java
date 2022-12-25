package com.wqf.data_.calendar;

import java.util.Calendar;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Calendar_ {

    public static void main(String[] args) {

        //1. Calendar是一个抽象类，比呢且构造器时受保护的
        //2. 可以通过相应的方法来得到一个日历类对象
        //获取日历对象的某个日历字段
        Calendar instance = Calendar.getInstance();
        System.out.println(instance);
        System.out.println(instance.get(Calendar.YEAR));
        System.out.println(instance.get(Calendar.MONTH) + 1);
        System.out.println(instance.get(Calendar.DAY_OF_MONTH));
        System.out.println(instance.get(Calendar.HOUR_OF_DAY));
        System.out.println(instance.get(Calendar.MINUTE));
        System.out.println(instance.get(Calendar.SECOND));
        //Calendar没有格式化方法,需要自己组合输出
    }
}

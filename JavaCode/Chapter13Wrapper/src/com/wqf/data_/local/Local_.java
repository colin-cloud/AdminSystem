package com.wqf.data_.local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Local_ {

    public static void main(String[] args) {

        //第三代日期
        //1. 使用now()返回表示当前日期时间的对象
        LocalDateTime now = LocalDateTime.now();//获取年月日时分秒
        System.out.println(now);
        System.out.println(now.getYear());
        System.out.println(now.getMonth());
        System.out.println(now.getMonthValue());
        System.out.println(now.getDayOfMonth());
        System.out.println(now.getHour());
        System.out.println(now.getMinute());
        System.out.println(now.getSecond());
        LocalDate localDate = LocalDate.now();//获取年月日
        LocalTime localTime = LocalTime.now();//获取时分秒
        System.out.println(localDate);
        System.out.println(localTime);
        //使用DateTimeFormatter对象来进行格式化
        //创建一个对象
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH小时mm分钟ss秒");
        String format = dateTimeFormatter.format(now);
        System.out.println(format);
        //使用plus和minus方法可以对当前时间进行加和减
        LocalDateTime localDateTime = now.plusDays(890);
        System.out.println("890天后：" + dateTimeFormatter.format(localDateTime));
        LocalDateTime localDateTime1 = now.minusDays(800);
        System.out.println("800天前：" + dateTimeFormatter.format(localDateTime1));
    }
}

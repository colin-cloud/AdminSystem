package com.wqf.data_;

import java.time.Instant;
import java.util.Date;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Date_ {

    public static void main(String[] args) {

        //使用now方法返回一个Instant对象
        Instant now = Instant.now();
        System.out.println(now);
        Date date = Date.from(now);//通过静态方法from来转化成Date对象
        Instant instant = date.toInstant();//通过方法toInstant方法转换成Instant对象
    }
}

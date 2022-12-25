package com.wqf.enum_.exercise;

import java.lang.annotation.Documented;
import java.nio.charset.StandardCharsets;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Exercise01 {

    public static void main(String[] args) {

        Week[] weeks = Week.values();
        //增强for循环，从weeks中每次取出一个元素出来
        for (Week week : Week.values()) {
            System.out.println(week);
        }
    }
}
enum Week {
    MONDAY("星期一"),
    TUESDAY("星期二"),
    WEDNESDAY("星期三"),
    THURSDAY("星期四"),
    FRIDAY("星期五"),
    SATURDAY("星期六"),
    SUNDAY("星期天");
    private String name;
    Week(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

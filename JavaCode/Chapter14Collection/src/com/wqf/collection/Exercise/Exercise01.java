package com.wqf.collection.Exercise;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Exercise01 {

    public static void main(String[] args) {

        news news = new news(new StringBuffer("新冠确诊病例超千万，数百万印度教信徒"));
        news news1 = new news(new StringBuffer("小陈学java"));
        ArrayList arrayList = new ArrayList();
        arrayList.add(news);
        arrayList.add(news1);
        Collections.reverse(arrayList);
        for (Object obj : arrayList) {
            news news2 = (news) obj;
            StringBuffer str = null;
            try {
                str = news2.getTitle();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            if (str != null) {
                if (str.length() > 10) {
                    str.replace(10, str.length(), "...");
                }
                System.out.println(str);
            }
        }
    }
}
class news {
    private StringBuffer title;
    private String content;

    public news(StringBuffer title) {
        this.title = title;
    }

    public StringBuffer getTitle() {
        return title;
    }

    public void setTitle(StringBuffer title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

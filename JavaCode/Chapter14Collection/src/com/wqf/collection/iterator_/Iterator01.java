package com.wqf.collection.iterator_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Iterator01 {

    public static void main(String[] args) {

        Collection collection = new ArrayList();
        collection.add(new Book("三国演义", "罗贯中"));
        collection.add(new Book("小李飞刀", "古龙"));
        collection.add(new Book("红楼梦", "曹雪芹"));
//        System.out.println(collection);
        //遍历
        Iterator iterator = collection.iterator();
        while(iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
        System.out.println();
        for (Object obj : collection) {
            System.out.println(obj);
        }
//        //快捷键itit
//        while (iterator.hasNext()) {
//            Object next =  iterator.next();
//
//        }
//        //显示所有快捷键Ctrl + j
    }
}

class Book {
    private String name;
    private String author;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

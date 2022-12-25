package com.company.collectiontype;

import java.util.List;

/**
 * @author 小白学java
 * @version 3.0
 */
public class Book {
    private List<String> list;

    public void setList(List<String> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Book{" +
                "list=" + list +
                '}';
    }
}

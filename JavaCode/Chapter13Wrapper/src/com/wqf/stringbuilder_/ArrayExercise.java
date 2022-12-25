package com.wqf.stringbuilder_;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 小白学java
 * @version 1.0
 */
public class ArrayExercise {

    public static void main(String[] args) {

        Book[] books = new Book[5];
        books[0] = new Book("1", 1);
        books[1] = new Book("2", 2);
        books[2] = new Book("3", 3);
        books[3] = new Book("4", 4);
        books[4] = new Book("5", 5);
        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                if (o1.getPrice() - o2.getPrice() > 0) {
                    return -1;
                } else if (o1.getPrice() - o2.getPrice() < 0) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
//        Arrays.sort(books, new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                Book book1 = (Book) o1;
//                Book book2 = (Book) o2;
//                return (int)(book2.getPrice() - book1.getPrice());
//            }
//        });
        System.out.println(Arrays.toString(books));
//        for (int i = 0; i < books.length; i++) {
//            System.out.println(books[i].getName() + " " + books[i].getPrice());
//        }
    }
    public static void bubbleSort(Book[] books, Comparator comparator) {
        for (int i = 0; i < books.length - 1; i++) {
            for (int j = 0; j < books.length - 1 - i; j++) {
                if (comparator.compare(books[j].getPrice(), books[j + 1].getPrice()) > 0) {
                    Book book = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = book;
                }
            }
        }
    }
}

class Book {
    private String name;
    private double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

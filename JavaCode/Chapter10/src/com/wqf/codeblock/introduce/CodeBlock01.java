package com.wqf.codeblock.introduce;

public class CodeBlock01 {

    public static void main(String[] args) {

        Movie movie = new Movie("你好，李焕英", 1000);
    }
}
class Movie {
    private String name;
    private double price;
    private String director;

    public Movie(String name, double price, String director) {
        this.name = name;
        this.price = price;
        this.director = director;
    }

    public Movie(String name, double price) {
        this.name = name;
        this.price = price;
        System.out.println("构造器调用中...");
    }

    public Movie(String name) {
        this.name = name;
        System.out.println("构造器调用");
    }

    {
        System.out.println("电视荧幕打开...");
        System.out.println("广告开始...");
        System.out.println("电影正式开始...");
    }
}

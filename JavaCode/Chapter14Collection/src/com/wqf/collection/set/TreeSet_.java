package com.wqf.collection.set;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author 小白学java
 * @version 1.0
 */
public class TreeSet_ {

    public static void main(String[] args) {

        //1. 当使用无参构造器，创建TreeSet时仍然是无序的
        //2. 使用TreeSet提供的一个构造器，可以传入一个比较器(匿名内部类)，指定排序规则
        TreeSet treeSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String)o1).compareTo((String)o2);
            }
        });
        treeSet.add("jack");
        treeSet.add("java");
        treeSet.add("php");
        treeSet.add("c++");
        System.out.println(treeSet);
    }
}

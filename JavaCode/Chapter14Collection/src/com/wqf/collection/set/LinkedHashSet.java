package com.wqf.collection.set;


import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author 小白学java
 * @version 1.0
 */
public class LinkedHashSet {

    public static void main(String[] args) {

        java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet();
        linkedHashSet.add(new String("AA"));
        linkedHashSet.add(44);
        linkedHashSet.add(44);
        linkedHashSet.add(new Customer("刘", 1000));
        System.out.println(linkedHashSet);

        //第一次添加时，直接将数组table扩容到16，存放的节点类型是LinkedHashMap$Entry类型
        //数组是 HashMap$Node[] 存放的元素时 LinkedHashMap$Entry类型
            //继承关系是在内部类完成的
    //        static class Entry<K,V> extends HashMap.Node<K,V> {
    //            LinkedHashMap.Entry<K,V> before, after;
    //            Entry(int hash, K key, V value, HashMap.Node<K,V> next) {
    //                super(hash, key, value, next);
    //            }
    //        }
    }
}

class Customer {
    private String name;
    private int num;

    public Customer(String name, int num) {
        this.name = name;
        this.num = num;
    }
}

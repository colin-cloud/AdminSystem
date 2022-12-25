package com.wqf.collection.list_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author 小白学java
 * @version 1.0
 */
public class ListMethod {

    public static void main(String[] args) {

        List list = new ArrayList();
        list.add("张三");
        list.add("贾宝玉");
//        void add(int index, Object ele) : 在index位置插入ele元素
        list.add(1, "小王");
        System.out.println(list);
//        boolean addAll(int index, Collection eles) :从index位置开始将eles中的所有元素插入
        List list1 = new ArrayList();
        list1.add("ajc");
        list.addAll(1, list1);
//        Object get(int index):获取指定index位置元素
//        int indexOf(Object obj) :返回obj在集合中首次出现的位置
//        int lastIndexOf(Object obj):返回obj在集合中最后出现的位置
//        Object set(int index, Object ele) : 设置指定index位置的元素为ele，相当于替换
//        Object remove(int index):移除index位置的元素并返回该元素
//        List subList(int fromIndex, int toIndex):返回从fromIndex到roIndex位置的子集合

    }
}

package com.wqf.collection.method;

import java.util.ArrayList;

/**
 * @author 小白学java
 * @version 1.0
 */
public class CollectionMethod {

    public static void main(String[] args) {

        ArrayList arrayList = new ArrayList();
        //add:添加元素
        arrayList.add("jack");
        arrayList.add(10);
        arrayList.add(true);
        System.out.println(arrayList);
        //remove:删除元素
        //arrayList.remove(0);//删除第一个元素
        arrayList.remove("jack");
        System.out.println(arrayList);
        //contains:查找元素
        System.out.println(arrayList.contains("jack"));
        //size:获取元素个数
        System.out.println(arrayList.size());
        //idEmpty:判断是否为空
        System.out.println(arrayList.isEmpty());
        //clear:清空
        arrayList.clear();
        System.out.println(arrayList);
        //addAll:添加对个元素
        ArrayList arrayList1 = new ArrayList();
        arrayList1.add("smith");
        arrayList1.add("lisa");
        arrayList.addAll(arrayList1);
        System.out.println(arrayList);
        //containsAll:查找多个元素是否都存在
        System.out.println(arrayList.containsAll(arrayList1));
        //removeAll:删除多个元素
        arrayList.add("pink");
        arrayList.removeAll(arrayList1);
        System.out.println(arrayList);

    }
}

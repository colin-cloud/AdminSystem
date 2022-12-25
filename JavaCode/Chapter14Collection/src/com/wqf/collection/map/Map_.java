package com.wqf.collection.map;

import java.util.*;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Map_ {

    public static void main(String[] args) {

        Map map = new HashMap();
        map.put("No1", "小王");
        map.put("No2", "小陈");
//        map.put("No3", "小陈");
//        map.put("No4", "小陈");
//        map.put("No5", "小陈");
//        System.out.println(map);
//        HashMap hashMap = new HashMap();
//        hashMap.putAll(map);
//        System.out.println(hashMap);
        /*
            1. k-v最后是 HashMap$Node node = newNode(hash, key, value, null)
            2. k-v为了方便遍历，还会创建 EntrySet集合，该集合存放的元素类型是 Entry，二一个Entry
               对象就有k，v EntrySet<Entry<K, V>> 即: transient Set<Map.Entry<K, V>>entrySet
            3. entrySet 中定义的类型是Map.Entry，但是实际上存放的还是HashMap$Node，因为
               static class Node<K, V> implements Map.Entry<K, V>
            4. 当把 HashMap$Node 对象存放到entrySet就方便遍历 ：Map.Entry提供了方法
         */
        Set set = map.entrySet();
        System.out.println(set.getClass());
//        for (Object obj : set ) {
//            Map.Entry entry = (Map.Entry) obj;
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }
//        Set set = map.keySet();
//        //1. 增强for
//        for (Object obj : set) {
//            System.out.println(map.get(obj));
//        }
//        //2. 迭代器
//        Iterator iterator = set.iterator();
//        while (iterator.hasNext()) {
//            Object next =  iterator.next();
//            System.out.println(map.get(next));
//            System.out.println(next.getClass());
//        }
//        //3. 把所有的values取出,使用Collection的取出方法 - 只能取出value
//        Collection values = map.values();
//        //4. 通过EntrySet 来获取k-v
//        Set set1 = map.entrySet();
//        for(Object entry : set1 ) {
//            Map.Entry m = (Map.Entry) entry;
//            System.out.println(m.getKey() + " " + m.getValue());
//        }
//        while (iterator.hasNext()) {
//            Object next = iterator.next();
//            Map.Entry entry = (Map.Entry) next;
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }
    }
}

package com.wqf.generic.exercise;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Exercise01 {

    public static void main(String[] args) {

        HashMap<String, Student> objectObjectHashMap = new HashMap<>();
        Student student = new Student();
        Student student1 = new Student();
        Student student2 = new Student();
        objectObjectHashMap.put("小王", student);
        objectObjectHashMap.put("小陈", student1);
        objectObjectHashMap.put("小黄", student2);
        for (String str : objectObjectHashMap.keySet()) {
            System.out.println(str + objectObjectHashMap.get(str));
        }
        //先取出entrySet，再使用迭代器
        Set<Map.Entry<String, Student>> entries = objectObjectHashMap.entrySet();
        Iterator<Map.Entry<String, Student>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Student> next = iterator.next();
//            System.out.println(next);
            System.out.println(next.getKey() + next.getValue());
//            System.out.println(iterator.next().getKey() + " " + iterator.next().getValue());
        }
    }
}
class Student {

    @Override
    public String toString() {
        return "haha";
    }
}

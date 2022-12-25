package com.wqf.collection.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Exercise01 {

    public static void main(String[] args) {

        HashSet table = new HashSet();
        table.add(new Employee("小王",18));
        table.add(new Employee("小李",20));
        table.add(new Employee("小陈",22));
    }
}
class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
//class Employee {
//
//    private String name;
//    private int age;
//    public Employee next;
//    public Employee prev;
//
//    public Employee(String name, int age, HashSet table) {
//        this.name = name;
//        this.age = age;
//        judgeNA(table);
//    }
//    public boolean judgeNA(HashSet table) {
//        int n = 0;
//        for (Object obj2 : table) {
//            if (obj2 != null) {
//                n = -1;
//                break;
//            }
//        }
//        if (n == 0) {
//            System.out.println("可以添加");
//            return true;
//        }
//        //找到元素的索引
//        for (Object obj : table) {
//            if (obj != null) {
//                //遍历该链表，判断是否有相同属性
//                Employee obj1 = (Employee) obj;
//                while (obj1.next != null) {
//                    if (obj1.name.equals(this) && obj1.age == this.age) {
//                        System.out.println("无法添加");
//                        return false;
//                    }
//                }
//            }
//        }
//        System.out.println("添加成功");
//        return true;
//    }
//}

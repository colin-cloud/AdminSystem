package com.wqf.datastructure.hashtable;

import java.util.Arrays;

/**
 * @author 小白学java
 * @version 3.0
 */
public class HashTable {

    public static void main(String[] args) {

        HashTab hashTab = new HashTab();
        Employee employee = new Employee("小王", 1);
        Employee employee1 = new Employee("小陈", 2);
        Employee employee2 = new Employee("小夏", 3);
        Employee employee3 = new Employee("小美", 4);
        Employee employee4 = new Employee("小新", 5);
        hashTab.add(employee);
        hashTab.add(employee1);
        hashTab.add(employee2);
        hashTab.add(employee3);
        hashTab.add(employee4);
//        hashTab.delete(2);
//        hashTab.list();
        System.out.println( hashTab.search(2));

    }
}

class HashTab {
    //数组管理链表
    private static final int maxSize = 7;
    private EmpList[] table = new EmpList[maxSize];

    {
        for (int i = 0; i < maxSize; i++) {
            table[i] = new EmpList();
        }
    }

    public void add(Employee employee) {
        //根据hash函数来指定哪个链表来添加
        int index = hash(employee.getId());
        table[index].add(employee);
    }

    public Employee delete(int id) {
        int index = hash(id);
        return table[index].delete(id);
    }

    public void list() {
        for (int i = 0; i < maxSize; i++) {
            table[i].list();
        }
    }

    public Employee search(int id) {
        int index = hash(id);
        return table[index].search(id);
    }

    public int hash(int id) {
        return id % maxSize;
    }
}

class EmpList {
    //头指针
    private Employee head;

    public Employee getHead() {
        return head;
    }

    public void setHead(Employee head) {
        this.head = head;
    }

    public void add(Employee employee) {
        //进行尾插法
        Employee temp = head;
        if (head == null) {
            head = employee;
            return;
        }
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(employee);
    }

    public Employee delete(int id) {
        //根据id来删除对应的员工
        Employee temp = head;
        Employee delEmp = null;
        //链表为空
        if (head == null) {
            return null;
        }
        //删除头结点
        if (head.getId() == id) {
            head = head.getNext();
            return temp;
        }
        //循环遍历查找
        while (temp.getNext() != null) {
            delEmp = temp.getNext();
            if (delEmp.getId() == id) {
                temp.setNext(delEmp.getNext());
                return delEmp;
            }
            temp = temp.getNext();
        }
        //没有找到
        return null;
    }

    public Employee search(int id) {
        Employee temp = head;
        //链表为空
        if (head == null) {
            return null;
        }
        if (head.getId() == id) {
            return head;
        }
        while (temp.getNext() != null) {
            if (temp.getNext().getId() == id) {
                return temp.getNext();
            }
            temp = temp.getNext();
        }
        return null;
    }

    public void list() {
        //遍历链表
        Employee cur = head;
        while (cur != null) {
            System.out.println(cur);
            cur = cur.getNext();
        }
    }
}

class Employee {

    private String name;
    private int id;
    private Employee next;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getNext() {
        return next;
    }

    public void setNext(Employee next) {
        this.next = next;
    }

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id + '}';
    }
}
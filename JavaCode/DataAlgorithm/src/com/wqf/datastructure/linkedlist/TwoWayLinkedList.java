package com.wqf.datastructure.linkedlist;

/**
 * @author 小白学java
 * @version 3.0
 */
public class TwoWayLinkedList {

    public static void main(String[] args) {

        Person person = new Person("小王", 1);
        Person person1 = new Person("小陈", 2);
        Person person2 = new Person("小赵", 3);
        BothLinkedList list = new BothLinkedList();
        list.add(person1);
        list.add(person2);
        list.add(person);
        list.list();
    }
}

class BothLinkedList {
    public Person head = new Person();

    public void add(Person person) {
        //链表不为空，进行尾插
        Person temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.getNo() > person.getNo()) {
                break;
            } else if (temp.next.getNo() == person.getNo()) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("无法添加");
        } else {
            if (temp.next != null) {
                temp.next.pre = person;
            }
            person.next = temp.next;
            temp.next = person;
            person.pre = temp;
        }
    }

    public Person delete(Person person) {
        //如果链表为空，无法删除
        if (head.next == null) {
            System.out.println("链表空~");
            return null;
        }
        Person temp = head.next;
        while (temp != null && temp.getNo() != person.getNo()) {
            temp = temp.next;
        }
        //判断辅助变量是否为空
        if (temp == null) {
            System.out.println("没有这个人~");
        } else {
            temp.pre.next = temp.next;
            if (temp.next != null) {
                //删除最后一个结点,空指针异常
                temp.next.pre = temp.pre;
            }
        }
        return temp;
    }

    public void list() {
        if (head.next == null) {
            System.out.println("链表为空~");
            return;
        }
        Person temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

class Person {
    private String name;
    private int no;
    public Person pre;
    public Person next;

    public Person(String name, int no) {
        this.name = name;
        this.no = no;
    }

    public Person() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", no=" + no +
                '}';
    }
}

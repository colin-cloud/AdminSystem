package com.wqf.collection.linkedlist;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author 小白学java
 * @version 1.0
 */
public class LinkedList01 {

    public static void main(String[] args) {

//        Node node = new Node("jack");
//        Node node1 = new Node("jack1");
//        Node node2 = new Node("jack2");
//        Node node3 = new Node("jack3");
//        node.next = node1;
//        node1.next = node2;
//        node2.prev = node1;
//        node1.prev = node;
//        Node first = node;
//        Node last = node2;
//        while (true) {
//            if (first == null) {
//                break;
//            }
//            System.out.println(first);
//            first = first.next;
//        }
//        node3.next = node2;
//        node1.next = node3;
//        node2.prev = node3;
//        node3.prev = node1;
//        first = node;
//        while (true) {
//            if (first == null) {
//                break;
//            }
//            System.out.println(first);
//            first = first.next;
//        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        Iterator iterator = linkedList.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

class Node {
    public Object item;
    public Node next;
    public Node prev;
    public Node(Object item) {
        this.item = item;
    }
    @Override
    public String toString() {
        return item + " ";
    }
}

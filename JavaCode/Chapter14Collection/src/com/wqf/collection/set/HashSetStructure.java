package com.wqf.collection.set;

/**
 * @author 小白学java
 * @version 1.0
 */
public class HashSetStructure {

    public static void main(String[] args) {

        //模拟(HashMap底层结构)简单的数组 + 链表

        //1. 创建数组
        Node[] nodes = new Node[16];
        //2. 创建节点
        Node node = new Node("john", null);
        nodes[2] = node;
        Node jack = new Node("jack", null);
        node.next = jack;
        System.out.println(nodes);
    }
}

class Node {
    Object item;//存放数据
    Node next;//指向下一个节点

    public Node(Object item, Node next) {
        this.item = item;
        this.next = next;
    }
}

package com.wqf.datastructure.queue;

import java.util.Scanner;

/**
 * @author 小白学java
 * @version 3.0
 */
public class Queue {

    public static void main(String[] args) {

        char ch = ' ';
        ArrayQueue queue = new ArrayQueue(3);
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("a(添加数据)");
            System.out.println("e(退出程序)");
            System.out.println("d(显示队列)");
            System.out.println("g(取出数据)");
            System.out.println("请输入");
            ch = scanner.next().charAt(0);
            switch (ch) {
                case 'a' :
                    System.out.println("请输入添加的数字");
                    int num = scanner.nextInt();
                    queue.add(num);
                    break;
                case 'e' :
                    scanner.close();
                    loop =false;
                    break;
                case 'd' :
                    queue.display();
                    break;
                case 'g' :
                    try {
                        int i = queue.get();
                        System.out.println(i);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default :
                    break;
            }
        }
    }
}

class ArrayQueue {
    //队列最大数目
    public int maxSize;
    //指向头结点
    public int front;
    //指向尾结点的后面一个结点
    public int rear;
    //存放队列数据
    public int[] data;
    //构造器
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        data = new int[maxSize];
    }
    //判断队列满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }
    //判断队列空
    public boolean isEmpty() {
        return rear == front;
    }
    //添加数据
    public void add(int num) {
        //判断队列是否满
        if (isFull()) {
            System.out.println("队列满，无法添加数据");
            return;
        }
        data[rear] = num;
        rear = (rear + 1) % maxSize;
    }
    //取出数据
    public int get() {
        //判断队列是否空
        if (isEmpty()) {
            throw new RuntimeException();
        }
        int res = data[front];
        front = (front + 1) % maxSize;
        return res;
    }
    //得到队列的有效数据
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }
    //遍历整个队列
    public void display() {
        if (isEmpty()) {
            System.out.println("队列空");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.println(data[i % maxSize]);
        }
    }
}

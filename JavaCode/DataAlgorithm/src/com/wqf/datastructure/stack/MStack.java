package com.wqf.datastructure.stack;

/**
 * @author 小白学java
 * @version 3.0
 * 数组模拟栈操作
 */
public class MStack {

    public static void main(String[] args) {

        ArrayStack stack = new ArrayStack(2);
        stack.add(1);
        stack.add(2);
        System.out.println(stack.pop());
        stack.list();
    }
}

class ArrayStack {
    private int top = -1;
    //栈的最大大小
    private int maxSize;
    //数组模拟栈
    private int[] stack;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }
    //入栈
    public void add(int num) {
        //判断栈是否满
        if (top == maxSize - 1) {
            System.out.println("栈满，无法添加数据~");
            return;
        }
        top++;
        stack[top] = num;
    }
    //出栈
    public int pop() {
        //判断栈内是否有元素
        if (top == -1) {
//            System.out.println("栈空，无法取出数据~");
//            return -1;
            throw new RuntimeException("栈空，无法取出数据~");
        }
        int res = stack[top];
        top--;
        return res;
    }
    //遍历栈
    public void list() {
        //判断栈空
        if (top == -1) {
            System.out.println("栈空");
            return;
        }
        int temp = top;
        while (temp >= 0) {
            System.out.println(stack[temp]);
            temp--;
        }
    }
}
package com.wqf.datastructure.tree;

/**
 * @author 小白学java
 * @version 3.0
 */
public class ArrBinaryTree {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        SeqBinaryTree tree = new SeqBinaryTree(arr);
        tree.preOrderList();
    }
}

class SeqBinaryTree {
    //存放数据的数组
    private int[] arr;

    public SeqBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrderList() {
        preOrderList(0);
    }

    //前序遍历
    public void preOrderList(int index) {
        //判断数组为空的情况
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，无法遍历");
            return;
        }
        //判断索引正确性
        if (index < 0 || index > arr.length - 1) {
            return;
        }
        //数组不为空
        System.out.println(arr[index]);
        if (2 * index + 1 < arr.length) {
            //左子节点不为空
            preOrderList(2 * index + 1);
        }
        if (2 * index + 2 < arr.length) {
            preOrderList(2 * index + 2);
        }
    }
}



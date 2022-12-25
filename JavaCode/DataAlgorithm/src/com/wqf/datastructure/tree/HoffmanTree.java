package com.wqf.datastructure.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 小白学java
 * @version 3.0
 */
public class HoffmanTree {

    public static void main(String[] args) {

        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        ANode tree = getHoffmanTree(arr);
        tree.preOrderList();
    }

    public static ANode getHoffmanTree(int[] arr) {
        //先将数组中的数据构建成node对象并放到集合中
        List<ANode> nodes = new ArrayList<>();
        for (int value : arr) {
            nodes.add(new ANode(value));
        }
        //对集合进行排序-从小到大
        Collections.sort(nodes);
        //进行循环构建
        while (nodes.size() > 1) {
            //取出最小的两个结点
            ANode left = nodes.remove(0);
            ANode right = nodes.remove(0);
            //构建二叉树
            ANode aNode = new ANode(left.value + right.value);
            aNode.left = left;
            aNode.right = right;
            //将结点放入到集合当中
            nodes.add(aNode);
            //重新排序
            Collections.sort(nodes);
        }
        //循环结束后,集合中只剩下一个元素,就是根结点
        return nodes.remove(0);
    }
}

class ANode implements Comparable<ANode> {
    public int value;
    public ANode left;
    public ANode right;

    //前序遍历
    public void preOrderList() {
        System.out.println(this);
        if (left != null) {
            left.preOrderList();
        }
        if (right != null) {
            right.preOrderList();
        }
    }

    public ANode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ANode{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(ANode o) {
        return value - o.value;
    }
}

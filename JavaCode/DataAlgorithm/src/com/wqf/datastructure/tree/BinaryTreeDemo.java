//package com.wqf.datastructure.tree;
//
///**
// * @author 小白学java
// * @version 3.0
// */
//public class BinaryTreeDemo {
//
//    public static void main(String[] args) {
//
//        Node node = new Node(1);
//        Node node1 = new Node(2);
//        Node node2 = new Node(3);
//        Node node3 = new Node(4);
//        node.left = node1;
//        node.right = node2;
//        node2.right = node3;
//        BinaryTree binaryTree = new BinaryTree(node);
////        binaryTree.preOrderList();
////        System.out.println();
////        binaryTree.delete(4);
////        binaryTree.preOrderList();
//        binaryTree.delete(3);
//        binaryTree.preOrderList();
//    }
//}
//
//class BinaryTree {
//
//    public Node root;
//
//    public BinaryTree(Node root) {
//        this.root = root;
//    }
//
//    //前序遍历
//    public void preOrderList() {
//        if (root == null) {
//            return;
//        }
//        root.preOrderList();
//    }
//    //前序查找
//    public Node preSearch(int value) {
//        if (root == null) {
//            return null;
//        }
//        return root.preSearch(value);
//    }
//    //中序遍历
//    public void infixOrderList() {
//        if (root == null) {
//            return;
//        }
//        root.infixOrderList();
//    }
//    //中序查找
//    public Node infixSearch(int value) {
//        if (root == null) {
//            return null;
//        }
//        return root.infixSearch(value);
//    }
//    //后序遍历
//    public void postOrderList() {
//        if (root == null) {
//            return;
//        }
//        root.postOrderList();
//    }
//    //后序查找
//    public Node postSearch(int value) {
//        if (root == null) {
//            return null;
//        }
//        return root.postSearch(value);
//    }
//    //删除指定节点
//    public Node delete(int value) {
//        if (root == null) {
//            return null;
//        }
//        Node res = null;
//        if (root.value == value) {
//            res = root;
//            root = null;
//            return res;
//        }
//        return root.delete(value);
//    }
//}
//
//class Node {
//
//    public int value;
//    public Node left;
//    public Node right;
//
//    //前序遍历方法
//    public void preOrderList() {
//        System.out.println(this);
//        //递归向左子树进行遍历
//        if (left != null) {
//            left.preOrderList();
//        }
//        //递归向右子树进行遍历
//        if (right != null) {
//            right.preOrderList();
//        }
//    }
//    //前序查找
//    public Node preSearch(int value) {
//        if (value == this.value){
//            return this;
//        }
//        Node res = null;
//        if (left != null) {
//            res =  left.preSearch(value);
//        }
//        if (res != null) {
//            return res;
//        }
//        if (right != null) {
//            res = right.preSearch(value);
//        }
//        return res;
//    }
//    //中序遍历
//    public void infixOrderList() {
//        if (left != null) {
//            left.infixOrderList();
//        }
//        System.out.println(this);
//        if (right != null) {
//            right.infixOrderList();
//        }
//    }
//    //中序查找
//    public Node infixSearch(int value) {
//        Node res = null;
//        if (left != null) {
//            res = left.preSearch(value);
//        }
//        if (res != null) {
//            return res;
//        }
//        if (value == this.value){
//            return this;
//        }
//        if (right != null) {
//            res = right.preSearch(value);
//        }
//        return res;
//    }
//    //后序遍历
//    public void postOrderList() {
//        if (left != null) {
//            left.postOrderList();
//        }
//        if (right != null) {
//            right.postOrderList();
//        }
//        System.out.println(this);
//    }
//    //后序查找
//    public Node postSearch(int value) {
//        Node res = null;
//        if (left != null) {
//            res = left.preSearch(value);
//        }
//        if (res != null) {
//            return res;
//        }
//        if (right != null) {
//            res = right.preSearch(value);
//        }
//        if (res != null) {
//            return res;
//        }
//        if (value == this.value){
//            return this;
//        }
//        return null;
//    }
//    //判断结点是不是叶子结点
//    public int isLeafNode(Node node) {
//        if (node.left == null && node.right == null) {
//            //叶子结点
//            return 0;
//        } else if (node.left == null && node.right != null ||
//                node.right == null && node.left != null) {
//            //有一个节点的非叶子结点
//            return 1;
//        } else {
//            //有两个节点的非叶子结点
//            return 2;
//        }
//
//    }
//    //删除指定节点
//    public Node delete(int value) {
//        Node res = null;
//        //判断左子节点
//        if (left != null && left.value == value) {
//            res = left;
//            if (isLeafNode(left) == 0) {
//                //如果要删除的结点是叶子结点
//                //置为空
//                left = null;
//            } else if (isLeafNode(left) == 1) {
//                //判断哪个节点不为空
//                if (left.left == null) {
//                    //右子节点不为空
//                    this.left = left.right;
//                } else {
//                    //左子节点不为空
//                    this.left = left.left;
//                }
//            } else {
//                //有两个子节点
//                //将左子节点放入到删除结点上
//                Node left = this.left.left;
//                Node right = this.left.right;
//                this.left = left;
//                left.right = right;
//            }
//            return res;
//        }
//        //判断右子节点
//        if (right != null && right.value == value) {
//            res = right;
//            if (isLeafNode(right) == 0) {
//                //如果要删除的结点是叶子结点
//                //置为空
//                right = null;
//            } else if (isLeafNode(right) == 1) {
//                //判断哪个节点不为空
//                if (right.left == null) {
//                    //右子节点不为空
//                    this.right = right.right;
//                } else {
//                    //左子节点不为空
//                    this.right = right.left;
//                }
//            } else {
//                //有两个子节点
//                //将左子节点放入到删除结点上
//                Node left = this.right.left;
//                Node right = this.right.right;
//                this.left = left;
//                left.right = right;
//            }
//            return res;
//        }
//        if (left != null) {
//            res = left.delete(value);
//        }
//        if (res != null) {
//            return res;
//        }
//        if (right != null) {
//            res = right.delete(value);
//        }
//        return res;
//    }
//
//    public int getValue() {
//        return value;
//    }
//
//    public void setValue(int value) {
//        this.value = value;
//    }
//
//    public Node(int value) {
//        this.value = value;
//    }
//
//    @Override
//    public String toString() {
//        return "Node{" +
//                "value=" + value +
//                '}';
//    }
//}

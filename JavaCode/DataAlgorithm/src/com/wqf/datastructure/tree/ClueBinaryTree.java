package com.wqf.datastructure.tree;


/**
 * @author 小白学java
 * @version 3.0
 */
public class ClueBinaryTree {

    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(6);
        Node node4 = new Node(8);
        Node node5 = new Node(10);
        Node node6 = new Node(14);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;

        BinaryTree binaryTree = new BinaryTree(node1);
        binaryTree.threadedNode();
//        System.out.println(node5.right);
//        binaryTree.infixOrderList();
        binaryTree.threadedList();
    }
}

class BinaryTree {

    public Node root;
    //保存前驱结点
    public Node pre;

    public BinaryTree(Node root) {
        this.root = root;
    }

    public void threadedList() {
        Node node = root;
        while(node != null) {
            while (node.nodeLeftType == 0) {
                node = node.left;
            }
            System.out.println(node);
            while (node.nodeRightType == 1) {
                node = node.right;
                System.out.println(node);
            }
            node = node.right;
        }
    }

    public void threadedNode() {
        threadedNode(root);
    }

    public void threadedNode(Node node) {
        //判断当前节点是否为空
        if (node == null) {
            return;
        }
        //进行左子树线索化
        threadedNode(node.left);
        //进行中间节点线索化
        if (node.left == null) {
            node.left = pre;
            node.nodeLeftType = 1;
        }
        if (pre != null && pre.right == null) {
            pre.right = node;
            pre.nodeRightType = 1;
        }
        pre = node;
        //进行右子树线索化
        threadedNode(node.right);
    }

    //前序遍历
    public void preOrderList() {
        if (root == null) {
            return;
        }
        root.preOrderList();
    }

    //前序查找
    public Node preSearch(int value) {
        if (root == null) {
            return null;
        }
        return root.preSearch(value);
    }

    //中序遍历
    public void infixOrderList() {
        if (root == null) {
            return;
        }
        root.infixOrderList();
    }

    //中序查找
    public Node infixSearch(int value) {
        if (root == null) {
            return null;
        }
        return root.infixSearch(value);
    }

    //后序遍历
    public void postOrderList() {
        if (root == null) {
            return;
        }
        root.postOrderList();
    }

    //后序查找
    public Node postSearch(int value) {
        if (root == null) {
            return null;
        }
        return root.postSearch(value);
    }

    //删除指定节点
    public Node delete(int value) {
        if (root == null) {
            return null;
        }
        Node res = null;
        if (root.value == value) {
            res = root;
            root = null;
            return res;
        }
        return root.delete(value);
    }
}

class Node {

    public int value;
    public Node left;
    public Node right;
    //定义nodeType为1时表示线索化指针，为0时表示正常的左右指针
    public int nodeLeftType;
    public int nodeRightType;

    //前序遍历方法
    public void preOrderList() {
        System.out.println(this);
        //递归向左子树进行遍历
        if (left != null && nodeLeftType == 0) {
            left.preOrderList();
        }
        //递归向右子树进行遍历
        if (right != null && nodeRightType == 0) {
            right.preOrderList();
        }
    }

    //前序查找
    public Node preSearch(int value) {
        if (value == this.value) {
            return this;
        }
        Node res = null;
        if (left != null && nodeLeftType == 0) {
            res = left.preSearch(value);
        }
        if (res != null) {
            return res;
        }
        if (right != null && nodeRightType == 0) {
            res = right.preSearch(value);
        }
        return res;
    }

    //中序遍历
    public void infixOrderList() {
        if (left != null && nodeLeftType == 0) {
            left.infixOrderList();
        }
        System.out.println(this);
        if (right != null && nodeRightType == 0) {
            right.infixOrderList();
        }
    }

    //中序查找
    public Node infixSearch(int value) {
        Node res = null;
        if (left != null && nodeLeftType == 0) {
            res = left.preSearch(value);
        }
        if (res != null) {
            return res;
        }
        if (value == this.value) {
            return this;
        }
        if (right != null && nodeRightType == 0) {
            res = right.preSearch(value);
        }
        return res;
    }

    //后序遍历
    public void postOrderList() {
        if (left != null && nodeLeftType == 0) {
            left.postOrderList();
        }
        if (right != null && nodeRightType == 0) {
            right.postOrderList();
        }
        System.out.println(this);
    }

    //后序查找
    public Node postSearch(int value) {
        Node res = null;
        if (left != null && nodeLeftType == 0) {
            res = left.preSearch(value);
        }
        if (res != null) {
            return res;
        }
        if (right != null && nodeRightType == 0) {
            res = right.preSearch(value);
        }
        if (res != null) {
            return res;
        }
        if (value == this.value) {
            return this;
        }
        return null;
    }

    //判断结点是不是叶子结点
    public int isLeafNode(Node node) {
        if (node.left == null && node.right == null) {
            //叶子结点
            return 0;
        } else if (node.left == null && node.right != null ||
                node.right == null && node.left != null) {
            //有一个节点的非叶子结点
            return 1;
        } else {
            //有两个节点的非叶子结点
            return 2;
        }

    }

    //删除指定节点
    public Node delete(int value) {
        Node res = null;
        //判断左子节点
        if (left != null && left.value == value) {
            res = left;
            if (isLeafNode(left) == 0) {
                //如果要删除的结点是叶子结点
                //置为空
                left = null;
            } else if (isLeafNode(left) == 1) {
                //判断哪个节点不为空
                if (left.left == null) {
                    //右子节点不为空
                    this.left = left.right;
                } else {
                    //左子节点不为空
                    this.left = left.left;
                }
            } else {
                //有两个子节点
                //将左子节点放入到删除结点上
                Node left = this.left.left;
                Node right = this.left.right;
                this.left = left;
                left.right = right;
            }
            return res;
        }
        //判断右子节点
        if (right != null && right.value == value) {
            res = right;
            if (isLeafNode(right) == 0) {
                //如果要删除的结点是叶子结点
                //置为空
                right = null;
            } else if (isLeafNode(right) == 1) {
                //判断哪个节点不为空
                if (right.left == null) {
                    //右子节点不为空
                    this.right = right.right;
                } else {
                    //左子节点不为空
                    this.right = right.left;
                }
            } else {
                //有两个子节点
                //将左子节点放入到删除结点上
                Node left = this.right.left;
                Node right = this.right.right;
                this.left = left;
                left.right = right;
            }
            return res;
        }
        if (left != null) {
            res = left.delete(value);
        }
        if (res != null) {
            return res;
        }
        if (right != null) {
            res = right.delete(value);
        }
        return res;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}


package com.wqf.datastructure.tree;

import java.util.HashMap;

/**
 * @author 小白学java
 * @version 3.0
 */
public class BalancedBinaryTree {

    public AVLNode root;

    public static void main(String[] args) {

        int[] arr = {4, 3, 6, 5, 7, 8};
        BalancedBinaryTree binaryTree = new BalancedBinaryTree();
        for (int value : arr) {
            binaryTree.add(new AVLNode(value));
        }
    }


    //树的高度
    public int height() {
        if (root == null) {
            return 0;
        } else {
            return root.height();
        }
    }

    public int leftHeight() {
        if (root == null) {
            return 0;
        } else {
            return root.leftHeight();
        }
    }

    public int rightHeight() {
        if (root == null) {
            return 0;
        } else {
            return root.rightHeight();
        }
    }

    public void delete(int value) {
        //如果根结点为空
        if (root == null) {
            System.out.println("根结点为空,无法删除~");
            return;
        }
        //根结点不为空
        //找到要删除的结点和他的父结点
        AVLNode delPoint = search(value);
        AVLNode delPointParent = searchParent(value);
        //判断要删除的结点的情况
        if (delPoint == null) {
            System.out.println("要删除的结点不存在~");
            return;
        }
//        if (delPointParent == null) {
//            root = null;
//            return;
//        }
        //判断要删除的结点是否有子结点
        if (delPoint.right == null && delPoint.left == null) {
            //没有子结点
            if (delPointParent == null) {
                root = null;
            } else {
                if (delPointParent.left == delPoint) {
                    delPointParent.left = null;
                }
                if (delPointParent.right == delPoint) {
                    delPointParent.right = null;
                }
            }
        } else if (delPoint.right == null && delPoint.left != null) {
            //左子节点不为空
            if (delPointParent == null) {
                root = delPoint.left;
            } else {
                if (delPointParent.left == delPoint) {
                    delPointParent.left = delPoint.left;
                }
                if (delPointParent.right == delPoint) {
                    delPointParent.right = delPoint.left;
                }
            }
        } else if (delPoint.left == null && delPoint.right != null) {
            //右子结点不为空
            if (delPointParent == null) {
                root = delPoint.right;
            } else {
                if (delPointParent.left == delPoint) {
                    delPointParent.left = delPoint.right;
                }
                if (delPointParent.right == delPoint) {
                    delPointParent.right = delPoint.right;
                }
            }
        } else {
            //有两个结点
            //从右边找到最小值
            AVLNode cur = delPoint.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            AVLNode parent = searchParent(cur.value);
            delPoint.value = cur.value;
            if (parent.right == cur) {
                parent.right = null;
            }
            if (parent.left == cur) {
                parent.left = null;
            }
            //从左边找到最大值
//            NodalPoint cur = delPoint.left;
//            while (cur.right != null) {
//                cur = cur.right;
//            }
//            delPoint.value = cur.value;
//            NodalPoint parent = searchParent(cur.value);
//            if (parent.left == cur) {
//                parent.left = null;
//            }
//            if (parent.right == cur) {
//                parent.right = null;
//            }
        }
    }

    public AVLNode search(int value) {
        if (root == null) {
            return null;
        }
        return root.search(value);
    }

    public AVLNode searchParent(int value) {
        if (root == null) {
            return null;
        }
        return root.searchParent(value);
    }

    public void add(AVLNode point) {
        if (root == null) {
            root = point;
        } else {
            root.add(point);
        }
    }

    public void infixOrderList() {
        if (root != null) {
            root.infixOrderList();
        } else {
            System.out.println("树空, 无法遍历~");
        }
    }
}

class AVLNode {
    public int value;
    public AVLNode left;
    public AVLNode right;

    public AVLNode(int value) {
        this.value = value;
    }

    //以当前结点为根结点进行右旋转
    public void rightRotate() {
        //先创建一个新的结点
        AVLNode newNode = new AVLNode(value);
        //设置新的结点的右结点为当前结点的右子结点
        newNode.right = right;
        //设置新的结点的左子结点为当前结点的左子结点的左子结点
        newNode.left = left.right;
        //设置当前结点的值为左子结点
        value = left.value;
        //设置当前结点的左子结点为左子结点的右子结点
        left = left.left;
        //设置当前结点的右子结点为新的结点
        right = newNode;
    }
    //以当前结点为根结点进行左旋转
    public void leftRotate() {
        //先创建一个新的结点
        AVLNode newNode = new AVLNode(value);
        //设置新结点的左子结点为当前结点的左子结点
        newNode.left = left;
        //设置新结点的有子结点为当前节点的右子节点的左子结点
        newNode.right = right.left;
        //设置当前结点的值为右子节点的值
        value = right.value;
        //设置当前结点的左子结点为新的结点
        left = newNode;
        //设置当前结点的右子节点为右子节点的右子节点
        right = right.right;
    }

    //返回当前节点的树的高度
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }
    //返回左子树的高度
    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }
    //返回右子树的高度
    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }

    //查找对应结点的父结点
    public AVLNode searchParent(int value) {
        if (this.left != null && this.left.value == value || this.right != null && this.right.value == value) {
            return this;
        } else if (value > this.value && right != null) {
            return right.searchParent(value);
        } else if (value < this.value && left != null) {
            return left.searchParent(value);
        } else {
            return null;
        }
    }

    //查找对应的结点
    public AVLNode search(int value) {
        if (this.value == value) {
            return this;
        }
        if (value > this.value) {
            if (right != null) {
                return right.search(value);
            }
        }
        if (value < this.value) {
            if (left != null) {
                return left.search(value);
            }
        }
        return null;
    }

    //添加结点
    public void add(AVLNode point) {
        //判断node
        if (point == null) {
            return;
        }
        //node不为空
        if (point.value < value) {
            if (left == null) {
                left = point;
            } else {
                left.add(point);
            }
        } else {
            if (right == null) {
                right = point;
            } else {
                right.add(point);
            }
        }
        //判断左右子树的高度差
        if (rightHeight() - leftHeight() > 1) {
            if (right != null && right.leftHeight() > right.rightHeight()) {
                right.rightRotate();
            }
            leftRotate();
            return;
        }

        if (leftHeight() - rightHeight() > 1) {
            if (left != null && left.rightHeight() > left.leftHeight()) {
                left.leftRotate();
            }
            rightRotate();
        }
    }

    //中序遍历
    public void infixOrderList() {
        if (left != null) {
            left.infixOrderList();
        }
        System.out.println(this);
        if (right != null) {
            right.infixOrderList();
        }
    }

    @Override
    public String toString() {
        return "AVLNode{" +
                "value=" + value +
                '}';
    }
}

package com.wqf.datastructure.tree;

/**
 * @author 小白学java
 * @version 3.0
 */
public class BinarySortTree {

    public NodalPoint root;

    public static void main(String[] args) {

        BinarySortTree sortTree = new BinarySortTree();
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        for (int i : arr) {
            sortTree.add(new NodalPoint(i));
        }
        sortTree.delete(2);
        sortTree.delete(5);
        sortTree.delete(9);
        sortTree.delete(12);
        sortTree.delete(7);
        sortTree.delete(3);
        sortTree.delete(10);
        sortTree.delete(1);
        sortTree.infixOrderList();
    }

    public void delete(int value) {
        //如果根结点为空
        if (root == null) {
            System.out.println("根结点为空,无法删除~");
            return;
        }
        //根结点不为空
        //找到要删除的结点和他的父结点
        NodalPoint delPoint = search(value);
        NodalPoint delPointParent = searchParent(value);
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
            NodalPoint cur = delPoint.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            NodalPoint parent = searchParent(cur.value);
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

    public NodalPoint search(int value) {
        if (root == null) {
            return null;
        }
        return root.search(value);
    }

    public NodalPoint searchParent(int value) {
        if (root == null) {
            return null;
        }
        return root.searchParent(value);
    }

    public void add(NodalPoint point) {
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

class NodalPoint {
    public int value;
    public NodalPoint left;
    public NodalPoint right;

    public NodalPoint(int value) {
        this.value = value;
    }

    //查找对应结点的父结点
    public NodalPoint searchParent(int value) {
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
    public NodalPoint search(int value) {
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
    public void add(NodalPoint point) {
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
        return "NodalPoint{" +
                "value=" + value +
                '}';
    }
}
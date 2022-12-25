package com.company.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author 小白学java
 * @version 3.0
 */
public class LowestCommonAncestor {

    public static void main(String[] args) {

    }

//    private TreeNode res;
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        dfs(root, p, q);
//        return res;
//    }
//    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
//        if (root == null) {
//            return false;
//        }
//        boolean left = dfs(root.left, p, q);
//        boolean right = dfs(root.right, p, q);
//        if ((left && right) || (root.val == p.val) || (root.val == q.val) && (left || right)) {
//            res = root;
//        }
//        return left || right || (root.val == p.val) || (root.val == q.val);
//    }

    Map<Integer, TreeNode> parentNode = new HashMap<>();
    Set<Integer> values = new HashSet<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p != null) {
            TreeNode parent = parentNode.get(p.val);
            //添加当前值到哈希表中
            values.add(p.val);
            //更换到父结点
            p = parent;
        }
        while (q != null) {
            TreeNode parent = parentNode.get(q.val);
            //如果已经访问过了就返回结点
            if (values.contains(q.val)) {
                return q;
            }
            q = parent;
        }
        return null;
    }
    public void dfs(TreeNode root) {
        //保存每个结点的父结点
        if (root.left != null) {
            parentNode.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parentNode.put(root.right.val, root);
            dfs(root.right);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

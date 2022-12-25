import java.util.*;

public class KthSmallest { 
    public static void main(String[] args) { 
    }
    
    
    public List<Integer> list = new ArrayList();
    public int kthSmallest(TreeNode root, int k) {
        infixOrder(root);
        return list.get(k - 1);
    }
    public void infixOrder(TreeNode node) {
        if (node.left != null) {
            infixOrder(node.left);
        }
        list.add(node.val);
        if (node.right != null) {
           infixOrder(node.right);
        }
    }
    
    public int kthSmallest(TreeNode root, int k) {
        return new MyBST(root).kthSmallest(k);
    }
}

class MyBST {

    private TreeNode root;
    Map<TreeNode, Integer> table;
    
    public MyBST(TreeNode root) {
        this.root = root;
        table = new HashMap();
        count(root);
    }
    
    public int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        table.put(root, 1 + count(root.left) + count(root.right));
        return table.get(root);
    }
    
    public int kthSmallest(int k) {
        if (root == null) {
            return 0;
        }
        TreeNode cur = root;
        while (cur != null) {
            int rank = table.getOrDefault(cur.left, 0);
            if (rank < k - 1) {
                cur = cur.right;
                k -= rank + 1;
            } else if (rank == k - 1) {
                break;
            } else {
                cur = cur.left;
            }
        }
        return cur.val;
    }
}
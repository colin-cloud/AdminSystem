import java.util.*;

public class MaxDepth { 
    public static void main(String[] args) { 
    
    }
    
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getDepth(root.left, 1), getDepth(root.right, 1));
    }

    public int getDepth(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        depth++;
        return Math.max(getDepth(root.left, depth), getDepth(root.right, depth));
    }
}
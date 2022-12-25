import java.util.*;

public class ValidBST { 
    public static void main(String[] args) { 
        
    }
    
    public boolean isValidBST(TreeNode root) {
        
       return isIilegal(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean isIilegal(TreeNode root, long lower, long upper) {
        if (node == null) {
            return true;    
        }
        
        if (root.val <= lower || root.val >= upper) {
            return false;
        }
        
        return isIilegal(root.left, lower, root.val) && isIilegal(root.right, root.val, upper);
    }
    
    public boolean isValidBST(TreeNode root) {
        //中序遍历
        
        Deque<TreeNode> stack = new LinkedList();
        double inorder = -Double.MAX_VALUE;
        
        while (!stack.isEmpty() || root!= null) {
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        
        return true;
    }
}
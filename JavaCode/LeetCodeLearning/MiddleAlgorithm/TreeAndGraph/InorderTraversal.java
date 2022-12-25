import java.util.*;

public class InorderTrversal { 
    public static void main(String[] args) { 
        System.out.println("Hello world!"); 
    }
    
    List<Integer> inorderNodes = new ArrayList();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return inorderNodes;
        }
        if (root.left != null) {
            inorderTraversal(root.left);
        }
        inorderNodes.add(root.val);
        if (root.right != null) {
            inorderTraversal(root.right);
        }
        return inorderNodes;
    }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList();
        while (root != null || !queue.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            inorderNodes.add(root.val);
            root = root.right;
        }
    }
}
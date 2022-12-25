import java.util.*;

public class Symmetric { 
    public static void main(String[] args) { 
        
    }
    
    
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        //递归方式
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

    
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }
    
    public boolean check(TreeNode l, TreeNode r) {
        //迭代方式
        //创建队列
        Queue<TreeNode> queue = new LinkedList();
        //两种左右两个指针存入队列
        queue.offer(l);
        queue.offer(r);
        
        while (!queue.isEmpty()) {
        
            //将队列中弹出两个结点进行比较
            l = queue.poll();
            r = queue.poll();
            
            //当两个结点都为null时
            if (l == null && r == null) {
                continue;
            }
            
            //考虑false的情况
            if (l == null || r == null || l.val != r.val) {
                return false;
            }
            
            //将l,r的左右结点放入队列
            queue.offer(l.left);
            queue.offer(r.right);
            queue.offer(l.right);
            queue.offer(r.left);
        }
        
        return true;
    }
}
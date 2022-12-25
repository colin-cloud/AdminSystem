import java.util.*;

public class ZigzagLevelOrder { 
    public static void main(String[] args) { 
    
    }
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> ans = new LinkedList();
        if (root == null) {
            return ans;
        }
        //创建队列来进行广度优先搜索
        Queue<TreeNode> queue = new LinkedList();
        //将根节点放入队列
        queue.offer(root);
        //创建变量来指定添加方向
        boolean flag = true;
        while (!queue.isEmpty()) {
            //创建list来装填数据
            LinkedList<Integer> list = new LinkedList();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                //取出队列中的数据
                TreeNode node = queue.poll();
                if (!flag) {
                    list.addFirst(node.val);
                } else {
                    list.addLast(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                } 
            }
            ans.add(list);
            flag = !flag;
        }
        return ans;
    }
}
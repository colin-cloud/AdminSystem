import java.util.*;

public class LevelOrder { 
    public static void main(String[] args) { 

    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
    
        //创建一个list来装填返回值
        List<List<TreeNode>> results = new ArrayList();
        List<List<Integer>> result = new ArrayList();
        
        //判断根结点是否为空
        if (root == null) {
            return result;
        }
        
        List<TreeNode> rootNode = new ArrayList<TreeNode>();
        rootNode.add(root);
        List<Integer> rootVal = new ArrayList<Integer>();
        rootVal.add(root.val);
        //将根结点放入集合中
        results.add(rootNode);
        result.add(rootVal);
        
        //创建一个临时的集合来装入每一层的结果
        List<TreeNode> tmp = new ArrayList();
        List<TreeNode> nodes = null;
        List<Integer> list = new ArrayList();
        for (int i = 0; (nodes = results.get(i)) != null && results.get(i).size() != 0; i++) {
            
            for (int j = 0; j < nodes.size(); j++) {
            
                TreeNode node = nodes.get(j);
                if (node.left != null) {
                    tmp.add(node.left);
                    list.add(node.left.val);
                }
                if (node.right != null) {
                    tmp.add(node.right);
                    list.add(node.right.val);
                }
            }
            if (tmp == null || tmp.size() == 0) {
                break;
            }
            results.add(tmp);
            result.add(list);
            tmp = new ArrayList();
            list = new ArrayList();
        }
        
        return result;
    }
    
    //使用递归方式
    
    List<List<Integer>> lists = new ArrayList();
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        addLevel(root, 0);
        return lists;
    }
    
    public void addLevel(TreeNode root, int level) {
        //结点为空，只接返回
        if (root == null) {
            return null;
        }
        //当层数等于lists的大小时才添加新的list
        if (level == lists.size()) {
            lists.add(new ArrayList<Integer>());
        }
        
        //将当前的值添加进去
        lists.get(level).add(root.val);
        
        //向左进行下一层的添加
        addLevel(root.left, level + 1);
        //向右进行下一层的添加
        addLevel(root.right, level + 1);
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> ret = new ArrayList();
        if (root == null) {
            return ret;
        }
        
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            
            int curLevel = queue.size();
            List<Integer> curLevelList = new ArrayList();
            
            for (int i = 1; i <= curLevel; i++) {
            
                TreeNode node = queue.poll();
                cueLevelList.add(node.val);
            
                //将左右指针添加到队列中
                if (node.left != null) {
                    queue.offer(node.left);
                }
            
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(curLevelList);
        }
        
        return ret;
    }
}
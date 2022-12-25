import java.util.*;

public class BuildTree { 
    public static void main(String[] args) { 
        
    }
    
    //实用的递归方式
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> preList = new ArrayList();
        List<Integer> inList = new ArrayList();
        for (int i = 0; i < preorder.length; i++) {
            preList.add(preorder[i]);
            inList.add(inorder[i]);
        }
        return build(preList, inList);
    }
    
    public TreeNode build(List<Integer> preList, List<Integer> inList) {
        if (inList.size() == 0) {
            return null;
        }
        //前序遍历的第一个结点就是根结点
        int rootVal = preList.remove(0);
        TreeNode root = new TreeNode(rootVal);
        //在中序遍历中找到根结点的索引
        int index = inList.indexOf(rootVal);
        //将中序遍历的集合进行拆分
        //根结点左部分为根结点的左子树
        root.left = build(preList, inList.subList(0, index));
        //根结点的右部分为根结点的右子树
        root.right = build(preList, inList.subList(index + 1));
        //返回根结点
        return root;
    }
    
    //使用迭代的方式
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //创建根结点
        TreeNode root = new TreeNode(preorder[0]);
        //创建栈
        Deque<TreeNode> stack = new LinkedList();
        stack.push(root);
        //创建中序遍历的指针
        int index = 0;
        //遍历前序遍历
        for (int i = 1; i < preorder.length; i++) {
            int preVal = preorder[i];
            //得到栈顶元素
            TreeNode node = stack.peek();
            if (node.val != inorder[index]) {
                node.left = new TreeNode(preVal);
                stack.push(node.left);
            } else {
                //先找到不想等的数
                while (!stack.isEmpty() && stack.peek().val == inorder[index]) {
                    node = stack.pop();
                    index++;
                }
                //当前索引不想等的数就是node结点的右子结点
                node.right = new TreeNode(preVal);
                stack.push(node.right);
            }
        }
        return root;
    }
}
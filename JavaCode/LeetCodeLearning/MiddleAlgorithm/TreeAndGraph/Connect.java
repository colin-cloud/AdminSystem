import java.util.*;

public class Connect { 
    public static void main(String[] args) { 
        System.out.println("Hello world!"); 
    }
    
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        //创建队列来保存结点
        Queue<Node> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            //根据队列大小来遍历队列
            for (int i = 0; i < size; i++) {
                Node node1 = queue.poll();
                //将左右子结点加入队列
                if (node1.left != null) {
                    queue.offer(node1.left);
                }
                if (node1.right != null) {
                    queue.offer(node1.right);
                }
                //当前结点是否为最后一个结点
                if (i == size - 1) {
                    node1.next = null;
                    break;
                }
                //进行连接
                Node node2 = queue.peek();
                node1.next = node2;
            }
        }
        return root;
    }
    
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        //创建结点指向当前层的最左结点
        Node left = root;
        //判断left的左子结点是否为空
        while (left.left != null) {
            Node cur = left;
            while (cur != null) {
                //将当前结点的左右结点进行连接
                cur.left.next = cur.right;
                if (cur.next != null) {
                    //如果不是当前层的最后一个结点，就进行不同父结点的子结点的连接
                    cur.right.next = cur.next.left;
                }
                //移动当前结点
                cur = cur.next;
            }
            //向下继续连接
            left = left.left;
        }
        return root;
    }
}
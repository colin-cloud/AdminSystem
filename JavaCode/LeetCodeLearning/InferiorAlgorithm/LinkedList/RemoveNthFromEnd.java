import java.util.*;

public class RemoveNthFromEnd { 
    public static void main(String[] args) { 
        System.out.println("Hello world!"); 
    }
    /**
    public static List removeNthFromEnd(ListNode head, int n){
        if (head.next == null) {
            return null;
        }
        ListNode res, tmp = head;
        
        while (tmp != null) {
            res = tmp.next;
            for (int i = 0; i < n - 1; i++){
               res = res.next;
            }
            if (res == null){
                //删除的是头结点
                head = tmp.next;
                break;
            }
            if (res.next == null) {
                //找到了
                if (tmp.next.next != null){
                    tmp.next = tmp.next.next;
                } else {
                    //删除的是最后一个结点
                    tmp.next = null;
                }
                break;
            }
            tmp = tmp.next;
        }
        return head;
    }
    */
    /**
    public static ListNode removeNthFromEnd(ListNode head, int n){
        //在删除结点时，为了防止删除的结点为头结点，
        //可以使用一个哑元来指向头指针
        ListNode dummy = new ListNode(0, head);
        //创建栈
        Deque<ListNode> stack = new LinkedList();
        ListNode res = dummy;
        
        while (res != null) {
            //将当前指针入栈
            stack.push(res);
            res = res.next;
        }
        for (int i = 0; i < n; i++){
            stack.pop();
        }
        res = stack.peek();
        res.next = res.next.next;
        return dummy.next;
    }
    */
    
    public static ListNode removeNthFromEnd(ListNode head, int n){
        ListNode dummy = new ListNode(0, head);
        ListNode res = dummy;
        while (res != null) {
        
            if (getNthFromEnd(res.next) == n) {
                res.next = res.next.next;
            }
            res = res.next;
        }
        return dummy.next;
    }
    public static int getNthFromEnd(ListNode node){
        if (node == null) {
            return 0;
        }
        return getNthFromEnd(node.next) + 1;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int v) {
        val = v;
    }
    ListNode(int v, ListNode n){
        val = v;
        next = n;
    }
}
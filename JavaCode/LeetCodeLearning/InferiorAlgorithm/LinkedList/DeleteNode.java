import java.util.*;

public class DeleteNode { 
    public static void main(String[] args) { 
        
    }
    /**
    public static void deleteNode(ListNode node){
    
        while (node.next.next != null){
            node.val = node.next.val;
            node = node.next;
        }
        //退出循环后，node指向最后一个结点的前一个结点
        node.val = node.next.val;
        node.next.next = null;
    }
    */
    
    public static void deleteNode(ListNode node){
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}
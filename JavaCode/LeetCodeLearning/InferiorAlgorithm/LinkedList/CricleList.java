import java.util.*;

public class CricleList { 
    public static void main(String[] args) { 
        System.out.println("Hello world!"); 
    }
    /**
    public static boolean hasCricle(ListNode head) {
    
        //创建一个散列集
        Set<ListNode> hashSet = new HashSet();
        
        while (head != null) {
            if (!hashSet.add(head)) {
                return true;
            }
            head = head.next;
        }
        
        return false;
    }
    */
    
    public static boolean hasCricle(ListNode head) {
    
        if (head.next == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head.next;
        
        while (fast != slow) {
            if (fast != null && fast.next != null) {
                fast = fast.next.next;
            } else {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
} 

class ListNode {

    int val;
    ListNode next;
    
    ListNode(int v) {
        val = v;
    }
}
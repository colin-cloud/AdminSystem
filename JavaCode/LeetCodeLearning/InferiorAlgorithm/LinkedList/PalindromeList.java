import java.util.*;

public class PalindromeList { 
    public static void main(String[] args) { 
        System.out.println("Hello world!"); 
    }
    /**
    public static boolean isPalindrome(ListNode head) {
        //栈方式，类似于数组拷贝值
        Deque<ListNode> stack = new LinkedList();
        
        ListNode pos = head;
        while (pos != null) {
            stack.push(pos);
            pos = pos.next;
        }
        
        while (head != null && stack.pop().val == head.val) {
            head = head.next;
        }
        
        return head == null;
    }
    */
    /**
    
    public static boolean isPalindrome(ListNode head) {
        //递归方式
        frontier = head;
        return isCommonVal(head);
    }
    
    private ListNode frontier;
    
    public static boolean isCommonVal(ListNode cur) {
        if (cur != null) {
        
            if (!isCommonVal(cur.next)) {
                return false;
            }
            if (!(frontier.val == cur.val)) {
                return false;
            }
            frontier = frontier.next;
        }
        return true;
    }
    */
    
    public static boolean isPalindrome(ListNode head) {
    
        ListNode endOfHalfList = endOfFirstHalf(head);
        ListNode rear = reverseFirstHalfList(head, endOfHalfList);
        ListNode pre = endOfHalfList;
        while (pre != null) {
        
            if (pre.val != rear.val) {
                return false;
            }
            pre = pre.next;
            rear = rear.next;
        }
        return true;
    }
    
    public static ListNode reverseFirstHalfList(ListNode head, ListNode end) {
        
        ListNode cur = head.next;
        ListNode pre = head;
        ListNode rear = null;
        
        while (cur != null) {
            rear = cur.next;
            cur.next = pre;
            pre = cur;
            cur = rear;
            if (pre == end) {
                break;
            }
        }
        
        return cur;
    }
    
    
    public static ListNode endOfFirstHalf(ListNode head) {
        ListNode quick = head;
        ListNode slow = head;
        
        while (quick.next != null && quick.next.next != null) {
            quick = quick.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
}

class ListNode {

    int val;
    ListNode next;
    
    ListNode(int v) {
        val = v;
    }
}
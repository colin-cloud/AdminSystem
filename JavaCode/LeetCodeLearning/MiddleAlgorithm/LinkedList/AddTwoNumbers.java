import java.util.*;

public class AddTwoNumbers { 
    public static void main(String[] args) { 
        System.out.println("Hello world!"); 
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = null, cur = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int total = 0;
            if (l1 == null) {
                total = l2.val + carry;
            } else if (l2 == null) {
                total = l1.val + carry;
            } else {
                total = l1.val + l2.val + carry;
            }
            carry = total / 10;
            int mod = total % 10;
            if (res == null) {
                res = new ListNode(mod);
                cur = res;
            } else {
                cur.next = new ListNode(mod);
                cur = cur.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry != 0) {
            cur.next = new ListNode(1);
        }
        return res;
    }
}
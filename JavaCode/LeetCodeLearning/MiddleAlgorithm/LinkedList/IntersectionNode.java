import java.util.*;

public class IntersectionNode { 
    public static void main(String[] args) {
    
    }
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //创建set集
        Set<ListNode> set = new HashSet();
        while (headA != null || headB != null) {
            if (headA != null) {
                if (!set.add(headA)) {
                    return headA;
                }
                headA = headA.next;
            }
            if (headB != null) {
                if (!set.add(headB)) {
                    return headB;
                }
                headB = headB.next;
            }
        }
        return null;
    }
    
    public ListNode getIntersectionNode(ListNode headA, Listznode headB) {
        if (headA == null && headB == null) {
            return null;
        }
        ListNode l1 = headA, l2 = headB;
        while (l1 != l2) {
            l1 = l1 == null ? headB : l1.next;
            l2 = l2 == null ? headA : l2.next;
        }
        return l1;
    }
}
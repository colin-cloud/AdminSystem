import java.util.*;

public class OddEvenList { 
    public static void main(String[] args) { 
        
    }
    
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //保存第一个偶数结点
        ListNode p = head.next;
        ListNode tmp = head.next;
        //遍历当前链表
        ListNode cur = head;
        while (cur.next != null) {
            cur.next = cur.next.next;
            if (cur.next == null) {
                //下一个偶数索引为空
                tmp.next = null;
                break;
            } else {
                tmp.next = cur.next.next;
                tmp = tmp.next;
            }
            cur = cur.next;
        }
        cur.next = p;
        return head;
    }
}
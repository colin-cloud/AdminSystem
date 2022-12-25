import java.util.*;

public class ReverseLst { 
    public static void main(String[] args) { 
        System.out.println("Hello world!"); 
    }
    
    /**
    public static ListNode reverseList(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        //迭代的方式
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode rear;
        
        while (cur != null) {
            //保存cur的下一个指针
            rear = cur.next;
            //将当前指针的next指向前面
            cur.next = pre;
            //将前指针指向当前指针
            pre = cur;
            //将cur进行后移
            cur = rear;
        }
        
        //当循环推出时，即pre指向最后一个指针
        head.next = null;
        return pre;
    }
    */
    
    public static ListNode reverseLust(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //优先得到尾部指针
        ListNode rear = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        //依次返回倒数的指针
        return rear;
    }
}
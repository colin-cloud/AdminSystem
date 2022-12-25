import java.util.*;

public class MergeTeoLists { 
    public static void main(String[] args) { 
        
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){

         if (list1 == null){
             return list2;
         }
         if (list2==null){
             return list1;
         }
         if (list1.val < list2.val){
             ListNode temp =list1;
             list1=list2;
             list2=temp;
            
         }
         ListNode tepL1,tepL2,saveL1,saveL2;
         tepL1 =list1;
         tepL2=list2;
         saveL2=list1;


         while(tepL1!=null&&tepL2!=null){
              
              
              while(tepL2.next!=null&&tepL2.next.val<=tepL1.val){
                  tepL2 =tepL2.next;
              }
              if (tepL2.next==null){
                  tepL2.next = tepL1;
                  return list2;
              }
              while (tepL1.next!=null&&tepL1.next.val<=tepL2.val){
                  tepL1=tepL1.next;
              }
              saveL1 =tepL1.next;
              
              tepL1.next =tepL2.next;
              tepL2.next=list1;
              list1=saveL1;
              
              
              tepL1=saveL1;


         }
         return list2;
   }
}
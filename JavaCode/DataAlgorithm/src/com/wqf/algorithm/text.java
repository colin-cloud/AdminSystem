package com.wqf.algorithm;

/**
 * @author 小白学java
 * @version 3.0
 */
public class text {

    public static void main(String[] args) {

        ListNode list1 = new ListNode(5);
        ListNode list2 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode listNode = mergeTwoLists(list1, list2);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //判断两个链表是否有空的情况
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        //判断两个链表的头结点的权值哪个大
        if (list1.val > list2.val) {
            ListNode temp = list2;
            list2 = list1;
            list1 = temp;
        }
        //使用list1来进行排序
        ListNode keepList1 = list1;
        ListNode cur = list1.next;
        ListNode temp = list2.next;
        while (cur != null) {
            if (cur.val > list2.val) {
                //将list2中的结点插入到list1后面
                list1.next = list2;
                list2.next = cur;
                list2 = temp;
                if (temp != null) {
                    temp = temp.next;
                }
            }
            list1 = cur;
            cur = cur.next;
        }
        if (list2 != null) {
            list1.next = list2;
        }
        if (temp != null) {
            //直接将剩下的结点插入到list1后面
            list1.next = temp;
        }
        return keepList1;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

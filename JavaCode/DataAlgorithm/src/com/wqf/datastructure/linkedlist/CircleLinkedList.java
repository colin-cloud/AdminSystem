package com.wqf.datastructure.linkedlist;

/**
 * @author 小白学java
 * @version 3.0
 * 约瑟夫问题
 */
public class CircleLinkedList {

    public static void main(String[] args) {

        CircleList list = new CircleList();
        list.add(5);
        list.game(1, 2, list.head);
    }
}

class CircleList {
    public People head = new People(1);

    public People add(int n) {
//        for (int i = 2; i <= n; i++) {
//            People people = new People(i);
//            add(people);
//            if (i == n) {
//                people.next = head;
//            }
//        }
//        return head;
        //使用辅助指针
        People curPer = head;
        for (int i = 2; i <= n; i++) {
            People people = new People(i);
            curPer.next = people;
            people.next = head;
            curPer = curPer.next;
        }
        return head;
    }

    public void add(People people) {
        if (head.next == null) {
            head.next = people;
            return;
        }
        People people1 = head.next;
        while (people1.next != null) {
            people1 = people1.next;
        }
        people1.next = people;
    }

    public void list() {
        People temp = head;
        while (true) {
            System.out.println(temp);
            if (temp.next == head) {
                break;
            }
            temp = temp.next;
        }
    }

    public void game(int k, int m, People head) {
        People cur = head;
        People helper = head;
        while (true) {
            helper = helper.next;
            if (helper.next == head) {
                break;
            }
        }
        //到达第k个人
        for (int i = 1; i < k; i++) {
            helper = helper.next;
            cur = cur.next;
        }
        int num = 1;
        while (true) {
            if (helper == cur) {
                System.out.println(cur);
                break;
            }
//            if (num == m) {
//                System.out.println(cur);
//                helper.next = cur.next;
//                num = 1;
//                cur = cur.next;
//            }
            //移动m-1步到达相应位置
            for (int i = 1; i < m; i++) {
                helper = helper.next;
                cur = cur.next;
            }
            //进行出圈
            System.out.println(cur);
            cur = cur.next;
            helper.next = cur;
//            helper = helper.next;
//            cur = cur.next;
//            num++;
        }
    }

}

class People {
    public int no;
    public People next;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public People(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "People{" +
                "no=" + no +
                '}';
    }
}
package com.wqf.datastructure.linkedlist;

import java.util.Stack;

/**
 * @author 小白学java
 * @version 3.0
 */
public class LinkedList {
    public Hero head = new Hero();

    public static void main(String[] args) {

        //创建链表
        LinkedList linkedList = new LinkedList();
        Hero hero = new Hero("林冲", 1);
        Hero hero1 = new Hero("林冲", 3);
        Hero hero2 = new Hero("林冲", 2);
        linkedList.add(hero);
        linkedList.add(hero1);
        linkedList.add(hero2);
//        linkedList.list();
//        linkedList.reverseList(linkedList.head);
//        linkedList.list();
        linkedList.reverseDis(linkedList.head.next);
    }

    //添加结点
    public void add(Hero hero) {
//        if (head.next == null) {
////            head.next = hero;
////            return;
////        }
////        Hero tmp = head.next;
////        if (tmp.no > hero.no) {
////            hero.next = tmp;
////            head.next = hero;
////            return;
////        }
////        if (tmp.no == hero.no) {
////            System.out.println("无法添加");
////            return;
////        }
////        while (true) {
////            if (tmp.next != null) {
////                if (tmp.next.no > hero.no) {
////                    hero.next = tmp.next;
////                    tmp.next = hero;
////                    return;
////                } else if (tmp.next.no == hero.no) {
////                    System.out.println("无法添加");
////                    return;
////                } else {
////                    tmp = tmp.next;
////                }
////            } else {
////                tmp.next = hero;
////                return;
////            }
////        }
        //指定临时变量
        Hero tmp = head;
        //指定变量判断是否重复添加
        boolean flag = false;
        while (true) {
            if (tmp.next == null) {
                //说明该结点已经是尾结点
                break;
            }
            if (tmp.next.no > hero.no) {
                //说明该结点的下一个结点的排名要大
                break;
            }
            if (tmp.next.no == hero.no) {
                //排名重复
                flag = true;
                break;
            }
            tmp = tmp.next;
        }
        hero.next = tmp.next;
        tmp.next = hero;
    }

    //删除指定结点
    public void delete(int no) {
        Hero hero = head;
        //判断头结点是否为要删除的结点
        if (head.no == no) {
            head = null;
            return;
        }
        while (hero.next != null && hero.next.no != no) {
            hero = hero.next;
        }
        //判断当前hero.next是否为空
        if (hero.next == null) {
            System.out.println("没有找到");
        } else {
            hero.next = hero.next.next;
        }
    }

    //显示链表
    public void list() {
        //判断头结点后是否为空
        if (head.next == null) {
            System.out.println("链表为空，无法遍历");
            return;
        }
        Hero temp = head.next;
        while (temp != null) {
            //展示数据
            System.out.println(temp);
            //更改指针
            temp = temp.next;
        }
    }

    //逆序打印
    public void reverseDis(Hero node) {
        //递归方式
//        if (node.next != null) {
//            reverseDis(node.next);
//        }
//        System.out.println(node);

        //栈方式
        if (node.next == null) {
            return;//空链表，不能打印
        }
        Stack<Hero> heroStack = new Stack<Hero>();
        Hero tmp = node.next;
        while (tmp != null) {
            heroStack.add(tmp);
            tmp = tmp.next;
        }
        while (heroStack.size() > 0) {
            System.out.println(heroStack.pop());
        }
    }

    public Hero reverseList(Hero head) {
//        //创建一个新的头进行操作
////        Hero newHead = new Hero();
////        //遍历head所带领的链表
////        Hero tmp = head.next;
////        //每进行一次循环，就将当前的结点头插入新的头结点中
////        boolean flag = true;
////        while (tmp != null) {
////            head.next = tmp.next;
////            tmp.next = null;
////            addForHead(newHead, tmp);
////            tmp = head.next;
////        }
////        head.next = newHead.next;
////        newHead = null;
////        return head;
        //创建一个新的头结点
        Hero newHead = new Hero();
        if (head.next == null || head.next.next == null) {
            return head;
        }
        Hero cur = head.next;
        Hero next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = newHead.next;
            newHead.next = cur;
            cur = next;
        }
        head.next = newHead.next;
        newHead = null;
        return head;
    }

    public void addForHead(Hero head, Hero node) {
        if (head.next == null) {
            head.next = node;
            return;
        }
        node.next = head.next;
        head.next = node;
    }

}

class Hero {

    public String name;
    public int no;
    public Hero next;

    public Hero(String name, int no) {
        this.name = name;
        this.no = no;
    }

    public Hero() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", no=" + no +
                '}';
    }
}

package com.wqf.collection.set;

import java.util.HashSet;
import java.util.Objects;

/**
 * @author 小白学java
 * @version 1.0
 */
public class HashSetSource {

    public static void main(String[] args) {

        HashSet hashSet = new HashSet();
//        hashSet.add("java");
//        hashSet.add("php");
//        hashSet.add("java");
//        System.out.println(hashSet);
        /* 1. 执行HashSet()
           public HashSet() {
                map = new HashMap<>();
           }
           2. 执行add()方法
           public boolean add(E e) {
                return map.put(e, PRESENT)==null;//PRESENT是private static final Object PRESENT = new Object();
           }
           3. 执行put()方法  ---   执行hash(key)得到key的hash值 = (h = key.hashCode()) ^ (h >>> 16)
           public V put(K key, V value) { value是共享的
                return putVal(hash(key), key, value, false, true);
           }
           4. 执行putVal()方法
           //final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
                Node<K,V>[] tab; Node<K,V> p; int n, i; //定义了辅助变量.table是HashMap的一个数组，类型是Node[]
                //if 表示table为空或者大小为0，就进行第一次扩容，16个空间
                if ((tab = table) == null || (n = tab.length) == 0)
                    n = (tab = resize()).length;
                //1. 根据key得到的hash值去计算该key应该存放到table中的哪个索引位置，并把这个位置的对象赋给p
                //2. 判断p 是否为null
                //2.1 如果p为null， 表示还没存放元素，就创建一个Node(key = "java", value = PRESENT)
                //2.2 然后存放到tab[i] = newNode(hash, key, value, null)
                if ((p = tab[i = (n - 1) & hash]) == null)
                    tab[i] = newNode(hash, key, value, null);//hash是进行判断下次存放元素
                else { //第二次添加"java"时进入了else语句
                       //一个开发技巧提示：定义变量时什么地方需要什么地方创建
                    Node<K,V> e; K k;
                    if (p.hash == hash && //如果当前索引对应的链表对应的第一个元素和正要添加的key的hash值一样
                                          //并且满足以下条件之一:
                                          //1. 准备加入的key 和p 指向的Node节点的key是同一个对象
                                          //2. p 指向的Node节点的key的equals方法和准备加入的key 内容相同
                        ((k = p.key) == key || (key != null && key.equals(k))))
                        e = p;
                    //判断p 是不是红黑树
                    //如果是红黑树就调用((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value)
                    else if (p instanceof TreeNode)
                        e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
                    //如果当前table对应的索引是一个链表，就依次比较
                    //1. 依次比较后都不相同，则加入到该链表的最后，然后立即判断 该链表是否已经带到8个节点
                    //    就调用treeifyBin(tab, hash)对当前链表进行树化-转成红黑树
                    //    在转成红黑树时，还进行了判断
                    //    if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY)
                    //        resize();
                    //    如果条件成立，先对table进行扩容；否则，才进行转化红黑树
                    //2. 如果有相同情况，就直接break，放弃添加
                    else {
                        for (int binCount = 0; ; ++binCount) {
                            if ((e = p.next) == null) {
                                p.next = newNode(hash, key, value, null);
                                if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                                    treeifyBin(tab, hash);
                                break;
                            }
                            if (e.hash == hash &&
                                ((k = e.key) == key || (key != null && key.equals(k))))
                                break;
                            p = e;
                        }
                    }
                    if (e != null) { // existing mapping for key
                        V oldValue = e.value;
                        if (!onlyIfAbsent || oldValue == null)
                            e.value = value;
                        afterNodeAccess(e);
                        return oldValue;
                    }
                }
                ++modCount;
                if (++size > threshold)
                    resize();
                afterNodeInsertion(evict);
                return null;
            }
         */
        for (int i = 0; i < 12; i++) {
            hashSet.add(new A(i));
        }
        System.out.println(hashSet);
    }
}
class A {
    private int n;

    public A(int n) {
        this.n = n;
    }

    @Override
    public int hashCode() {
        return 100;
    }
}

package com.wqf.collection.queue;

import java.time.LocalDate;
import java.util.*;

/**
 * @author 小白学java
 * @version 3.0
 */
public class PriorityQueueTest {

    public static void main(String[] args) {


        HashSet ha = new HashSet();
        PriorityQueue<LocalDate> pq = new PriorityQueue();
        pq.add(LocalDate.of(1906, 12, 9));
        pq.add(LocalDate.of(1815, 12, 10));
        pq.add(LocalDate.of(1903, 12, 3));
        pq.add(LocalDate.of(1910, 6, 22));

        System.out.println("Iterating over elements...");

//        Iterator<LocalDate> iter = pq.iterator();
//        while (iter.hasNext()) {
//            System.out.println(iter.next());
//        }
        for(LocalDate ld : pq) {
            System.out.println(ld);
        }

        System.out.println("Removing elements...");

        while (!pq.isEmpty()) {
            System.out.println(pq.remove());
        }
    }

}

package com.wqf.collection.set;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 小白学java
 * @version 1.0
 */
public class HashSet_ {
    public static void main(String[] args) {

        HashSet hashSet = new HashSet();
        hashSet.add(new String("wqf"));//可以
        hashSet.add(new String("wqf"));//不可以
        System.out.println(hashSet);
    }
}

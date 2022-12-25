package com.wqf.generic.advanced;

import javax.jws.Oneway;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Generic03 {

    public static void main(String[] args) {

        List<Object> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        List<AA> list2 = new ArrayList<>();
        List<BB> list3 = new ArrayList<>();
        List<CC> list4 = new ArrayList<>();
    }
    public static void printCollection1(List<?> list) {
        for (Object obj : list) {
            System.out.println(obj);
        }
    }
    public static void printCollection2(List<? extends AA> list) {
        for (Object obj : list) {
            System.out.println(obj);
        }
    }
    public static void printCollection3(List<? super AA> list) {
        for (Object obj : list) {
            System.out.println(obj);
        }
    }
}
class AA {

}
class BB extends AA {

}
class CC extends BB {

}



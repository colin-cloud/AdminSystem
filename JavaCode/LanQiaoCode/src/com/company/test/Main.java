package com.company.test;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int count = 0;
    static int zero;
    static int one;
    static int two;
    static int three;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        zero = sc.nextInt();
        one = sc.nextInt();
        two = sc.nextInt();
        three = sc.nextInt();
        for (int i = 1; i <= 3; i++) {
            List<Integer> l = new ArrayList<Integer>();
            l.add(i);
            if (i == 1) {
                backtrack(zero, one - 1, two, three, l);
            } else if (i == 2) {
                backtrack(zero, one, two - 1, three, l);
            } else {
                backtrack(zero, one, two, three - 1, l);
            }
        }
        System.out.println(count);
    }

    public static void backtrack(int zero, int one, int two, int three, List<Integer> res) {
        if (zero <= Main.zero - 1 && one <= Main.one - 1 && two <= Main.two - 1 && three <= Main.three - 1 && res.size() >= 4) {
            count++;
        }
        if (zero >= 1) {
            res.add(0);
            backtrack(zero - 1, one, two, three, res);
        }
        if (one >= 1) {
            res.add(1);
            backtrack(zero, one - 1, two, three, res);
        }
        if (two >= 1) {
            res.add(2);
            backtrack(zero, one, two - 1, three, res);
        }
        if (three >= 1) {
            res.add(3);
            backtrack(zero, one, two, three - 1, res);
        }
    }
}

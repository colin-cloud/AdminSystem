package com.wqf.String_;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Exercise {

    public static void main(String[] args) {

//        String a = "hello";
//        String b = "abc";
//        String c = a + b;

        Test test = new Test();
        test.change(test.str, test.chars);
        System.out.print(test.str + "and");
        System.out.println(test.chars);
    }
}
class Test {
    String str = new String("wqf");
    final char[] chars = {'j', 'a', 'v', 'a'};
    public void change(String str, char ch[]) {
        str = "java";
        chars[0] = 'h';
    }
}

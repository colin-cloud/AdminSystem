package com.wqf.String_;

/**
 * @author 小白学java
 * @version 1.0
 */
public class String01 {

    public static void main(String[] args) {

        String name = "小王";
        final char[] value1 = {'a', 'b', 'c'};
        final char[] value2 = {'a', 'b', 'c'};
//        value1 = value2;
        System.out.println(name.valueOf(1.2));
        String s = String.valueOf(1.2);
        Person person = new Person();
        person.name = "hh";
        Person person1 = new Person();
        person1.name = "hh";
        System.out.println(person.name.hashCode() + " " + person1.name.hashCode());
    }
}
class Person {
    public String name;
}

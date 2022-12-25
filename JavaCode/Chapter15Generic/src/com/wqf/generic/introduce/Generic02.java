package com.wqf.generic.introduce;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Generic02 {

    public static void main(String[] args) {

        Person<String> person = new Person<String>("x");
        Person<Integer> integerPerson = new Person<>(100);
    }
}
class Person<E>  {
    E name;//E 表示s的数据类型，改数据类型在定义Person对象时指定，即在编译期间，就确定了E是什么类型

    public Person(E name) {
        this.name = name;
    }
    public E fn() {
        return name;
    }
}

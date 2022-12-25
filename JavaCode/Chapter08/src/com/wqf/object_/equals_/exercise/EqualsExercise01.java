package com.wqf.object_.equals_.exercise;

public class EqualsExercise01 {
    //判断两个Person对象内容是否相等，相等返回true
    public static void main(String[] args) {

        //重写equals
        Person person1 = new Person("小王", 18);
        Person person2 = new Person("小王", 18);
        Person person3 = person1;
        System.out.println(person1.equals(person3));
    }
}

class Person {
    private String name;
    private int age;
    private char gender;//性别

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Person) {
            //判断内容是否相同
            Person person = (Person) obj;//向下转型：默认传进来的参数是Object类型 -> Person类型
//            if (this.name.equals(person.name) && this.age == person.age) {
//                return true;
//            } else {
//                return false;
//            }
            return this.name.equals(person.name) && this.age == person.age;
        } else {
            return false;
        }
    }
}



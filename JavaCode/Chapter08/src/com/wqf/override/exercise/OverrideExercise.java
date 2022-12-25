package com.wqf.override.exercise;

public class OverrideExercise {

    public static void main(String[] args) {
        Person person = new Person("小王", 18);

        Student student = new Student("小王", 18, "2107010220", 80);

        System.out.println(person.showMyselfInfo());

        System.out.println(student.showMyselfInfo());
    }
}

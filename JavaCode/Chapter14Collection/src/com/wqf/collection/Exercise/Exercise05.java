package com.wqf.collection.Exercise;

import java.util.HashSet;
import java.util.Objects;

/**
 * @author 小白学java
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class Exercise05 {

    public static void main(String[] args) {

        HashSet hashSet = new HashSet();
        Person person = new Person(1001, "AA");
        Person person1 = new Person(1002, "BB");
        hashSet.add(person1);
        hashSet.add(person);
        person.name = "CC";
        hashSet.remove(person);
        System.out.println(hashSet);
        hashSet.add(new Person(1001, "CC"));
        System.out.println(hashSet);
        hashSet.add(new Person(1001, "AA"));
        System.out.println(hashSet);
    }
}
@SuppressWarnings({"all"})
class Person {
    public int id;
    public String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

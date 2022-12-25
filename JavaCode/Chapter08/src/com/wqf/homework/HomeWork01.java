//package com.wqf.homework;
//
////定义Person类，及相关数组，使用冒泡排序按年龄从大到小
//public class HomeWork01 {
//
//    public static void main(String[] args) {
//
//        Person[] people = new Person[3];
////        Person person = new Person("小王", 18, "学生");
////        Person person1 = new Person("小李", 10, "无工作");
////        Person person2 = new Person("小陈", 30, "总监");
////        people[0] = person;
////        people[1] = person1;
////        people[2] = person2;
//        people[0] = new Person("小王", 18, "学生");
//        people[1] = new Person("小李", 10, "无工作");
//        people[2] = new Person("小陈", 30, "总监");
//        people[0].bubbleSorting(people);
//        for (int i = 0; i < people.length; i++) {
//            System.out.println(people[i]);
//        }
//    }
//}
//
//class Person {
//    private String name;
//    private int age;
//    private String job;
//    //构造器
//    public Person(String name, int age, String job) {
//        this.setName(name);
//        this.setAge(age);
//        this.setJob(job);
//    }
//    //写get、set方法
//    public void setName(String name) {
//        this.name = name;
//    }
//    public String getName() {
//        return name;
//    }
//    public void setAge(int age) {
//        this.age = age;
//    }
//    public int getAge() {
//        return age;
//    }
//    public void setJob(String job) {
//        this.job = job;
//    }
//    public String getJob() {
//        return job;
//    }
////    public void showInfo() {
////        System.out.println(name + age + job);
////    }
//    @Override
//    public String toString() {
//        return "Person{" +
//                "name='" + getName() + '\'' +
//                ", age=" + getAge() +
//                ", job='" + getJob() + '\'' +
//                '}';
//    }
//    public void bubbleSorting(Person[] people) {
//        for (int i = 0; i < people.length - 1; i++) {
//            for (int j = 0; j < people.length - 1 - i; j++) {
//                if (people[j].age < people[j + 1].age) {
//                    Person person = people[j];
//                    people[j] = people[j + 1];
//                    people[j + 1] = person;
//            }
//            }
//        }
//    }
//}
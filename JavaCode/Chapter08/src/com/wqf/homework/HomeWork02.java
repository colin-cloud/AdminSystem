//package com.wqf.homework;
//
//public class HomeWork02 {
//
//    public static void main(String[] args) {
//
//        Teacher teacher = new Teacher("王老师", 20, "教师");
//        teacher.introduce();
//        Professor professor = new Professor("王教授", 59, "教授");
//        professor.introduce();
//    }
//}
//class Teacher {
//    private String name;
//    private int age;
//    private String post;
//    private double salary = 2000;
//
//    public Teacher(String name, int age, String post) {
//        this.name = name;
//        this.age = age;
//        this.post = post;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public String getPost() {
//        return post;
//    }
//
//    public void setPost(String post) {
//        this.post = post;
//    }
//
//    public double getSalary() {
//        return salary;
//    }
//
//    public void setSalary(double salary) {
//        this.salary = salary;
//    }
//
//    public void introduce() {
//        System.out.println("Teacher{" +
//                "name='" + getName() + '\'' +
//                ", age=" + getAge() +
//                ", post='" + getPost() + '\'' +
//                ", salary=" + getSalary() +
//                '}');
//    }
//}
//
//class Professor extends Teacher {
//    private double salary;
//    public Professor(String name, int age, String post) {
//        super(name, age, post);
//        this.salary = 1.3 * super.getSalary();
//    }
//
//    public void introduce() {
//        System.out.println("Teacher{" +
//                "name='" + getName() + '\'' +
//                ", age=" + getAge() +
//                ", post='" + getPost() + '\'' +
//                ", salary=" + this.salary +
//                '}');
//    }
//}
//class TextProfessor extends Teacher {
//    private double salary;
//    public TextProfessor(String name, int age, String post, double salary) {
//        super(name, age, post);
//        this.salary = 1.2 * super.getSalary();
//    }
//
//    public void introduce() {
//        System.out.println("Teacher{" +
//                "name='" + getName() + '\'' +
//                ", age=" + getAge() +
//                ", post='" + getPost() + '\'' +
//                ", salary=" + this.salary +
//                '}');
//    }
//}
//
//class Lecturer extends Teacher {
//    private double salary;
//    public Lecturer(String name, int age, String post) {
//        super(name, age, post);
//        this.salary = 1.1 * super.getSalary();
//    }
//
//    public void introduce() {
//        System.out.println("Teacher{" +
//                "name='" + getName() + '\'' +
//                ", age=" + getAge() +
//                ", post='" + getPost() + '\'' +
//                ", salary=" + this.salary +
//                '}');
//    }
//}
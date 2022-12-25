package com.wqf.polymorphic.apply;

public class PolymorphicArray {

    public static void main(String[] args) {

        //创建1个person，2个student，2个teacher统一放在数组中，并调用say方法
        Person[] people = new Person[5];
        people[0] = new Person("jack", 18);
        people[1] = new Student("jack", 18, 100);
        people[2] = new Student("smith", 18, 29);
        people[3] = new Teacher("smith", 29, 10000);
        people[4] = new Teacher("scott", 29, 10500);

        for (int i = 0; i < people.length; i++) {
            System.out.println(people[i].say());
            //调用子类特有方法
            if (people[i] instanceof Student) {
                Student student = (Student) people[i];
                student.study();
            } else if (people[i] instanceof Teacher) {
                Teacher teacher = (Teacher) people[i];
                teacher.teach();
            }
        }
    }
}

class Person {
    private String name;
    private  int age;

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

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String say() {
        return name + " " + age;
    }
}

class Student extends Person {
    private double score;

    public Student(String name, int age, double score) {
        super(name, age);
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String say() {
        return super.say() + " " + score;
    }
    public void study() {
        System.out.println(getName() + "正在学java");
    }
}

class Teacher extends Person {
    private double salary;

    public Teacher(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String say() {
        return super.say() +" " + salary;
    }
    public void teach() {
        System.out.println(getName() + "正在授课");
    }
}

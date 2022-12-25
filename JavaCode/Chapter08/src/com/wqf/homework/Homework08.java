package com.wqf.homework;

public class Homework08 {

    public static void main(String[] args) {

        Person[] people = new Person[4];
        people[0] = new Student("小王", 17, '男', "20003");
        people[1] = new Student("小李", 18, '女', "20005");
        people[2] = new Teacher1("小王", 28, '男', 5);
        people[3] = new Teacher1("小李", 29, '女', 4);
        //要求年龄从高到低排序
        people[0].bubbleSort(people);
//        for (int i = 0; i < people.length; i++) {
//            people[i].showInformation();
//            System.out.println("------------------");
//        }
        for (Person person : people) {
            person.showInformation();
            System.out.println("------------------");
        }
    }
}

class Person {
    private String name;
    private int age;
    private char gender;

    public Person(String name, int age, char gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
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

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String play() {
        return name + "爱玩";
    }
    public void bubbleSort(Person[] people) {
        for (int i = 0; i < people.length - 1; i++) {
            for (int j = 0; j < people.length - 1 - i; j++) {
                if (people[j].age < people[j + 1].age) {
                    Person person = people[j];
                    people[j] = people[j + 1];
                    people[j + 1] = person;
                }
            }
        }
    }
    //可以将其放在子类当中
//    public void useStuTeaMethod(Person person) {
//        if (person instanceof Student) {
//            Student student = (Student) person;
//            student.study();
//        }
//        if (person instanceof Teacher1) {
//            Teacher1 teacher1 = (Teacher1) person;
//            teacher1.teach();
//        }
//    }
    public void showInformation() {}
    //可以将打印信息的方法写在对应子类中形成封装
//    public void showInformation(Person person) {
//        if (person instanceof Student) {
//            System.out.println("学生的信息:");
//            System.out.println("姓名：" + person.name);
//            System.out.println("年龄：" + person.age);
//            System.out.println("性别：" + person.gender);
//            System.out.println("学号：" + ((Student) person).getId());
//            useStuTeaMethod(person);
//            System.out.println(person.play());
//        }
//        else if (person instanceof Teacher1) {
//            System.out.println("老师的信息:");
//            System.out.println("姓名：" + person.name);
//            System.out.println("年龄：" + person.age);
//            System.out.println("性别：" + person.gender);
//            System.out.println("工龄：" + ((Teacher1) person).getWorkAge());
//            useStuTeaMethod(person);
//            System.out.println(person.play());
//        }
//    }
}
class Student extends Person {
    private String id;

    public Student(String name, int age, char gender, String id) {
        super(name, age, gender);
        this.setId(id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void study() {
        System.out.println("我承诺，我会好好学习。");
    }
    public String play() {
        return super.play() + "足球";
    }
    public void useStuTeaMethod() {
        this.study();
    }
    public void showInformation() {
        System.out.println("学生的信息:");
        System.out.println("姓名：" + getName());
        System.out.println("年龄：" + getAge());
        System.out.println("性别：" + getGender());
        System.out.println("学号：" + getId());
        useStuTeaMethod();
        System.out.println(this.play());
    }
}
class Teacher1 extends Person {
    private int workAge;

    public Teacher1(String name, int age, char gender, int workAge) {
        super(name, age, gender);
        this.setWorkAge(workAge);
    }

    public int getWorkAge() {
        return workAge;
    }

    public void setWorkAge(int workAge) {
        this.workAge = workAge;
    }
    public void teach() {
        System.out.println("我承诺，我会认真教学");
    }
    public String play() {
        return super.play() + "象棋";
    }
    public void useStuTeaMethod() {
        this.teach();
    }
    public void showInformation() {
        System.out.println("老师的信息:");
        System.out.println("姓名：" + getName());
        System.out.println("年龄：" + getAge());
        System.out.println("性别：" + getGender());
        System.out.println("工龄：" + getWorkAge());
        useStuTeaMethod();
        System.out.println(this.play());
    }
}

package com.wqf.homework;

public class HomeWork07 {

    public static void main(String[] args) {

        Doctor doctor = new Doctor("小王", 18, "医生", '男', 1000);
        Doctor doctor1 = new Doctor("小王", 18, "医生", '男', 1000);
        System.out.println(doctor.equals(doctor1));
    }
}
class Doctor {
    private String name;
    private int age;
    private String job;
    private char gender;
    private double salary;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Doctor) {
            Doctor doctor = (Doctor) obj;
            if (doctor.age == this.age && doctor.gender == this.gender && this.salary == doctor.salary
            && doctor.job.equals(this.job) && doctor.name.equals(this.name)) {
                return true;
            }
        }
        return false;
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Doctor(String name, int age, String job, char gender, double salary) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.gender = gender;
        this.salary = salary;
    }
}

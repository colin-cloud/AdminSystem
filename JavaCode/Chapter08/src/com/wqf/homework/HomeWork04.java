package com.wqf.homework;

public class HomeWork04 {

    public static void main(String[] args) {

        Teacher teacher = new Teacher(1000, 20);
        System.out.println(teacher.toString());
        Worker worker = new Worker(1000);
        System.out.println(worker.toString());
    }
}
class Employee {
    private double salary;

    public Employee(double salary) {
        this.setSalary(salary);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary * 12 +
                '}';
    }
}
class Worker extends Employee {
    public Worker(double salary) {
        super(salary);
    }

    @Override
    public String toString() {
        return "Worker{" + "salary" + getSalary() * 12 + "}";
    }
}
class Peasant extends Employee {
    public Peasant(double salary) {
        super(salary);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
class Teacher extends Employee {
    private double dollars;

    public Teacher(double salary, double dollars) {
        super(salary);
        this.dollars = dollars;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "salary" + (dollars * 365 + getSalary() * 12) +
                '}';
    }
}
class Scientist extends Employee {
    private double bonus;

    public Scientist(double salary, double bonus) {
        super(salary);
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "Scientist{" +
                "salary" + (bonus + 12 * getSalary()) +
                '}';
    }
}
class Waiter extends Employee {
    public Waiter(double salary) {
        super(salary);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
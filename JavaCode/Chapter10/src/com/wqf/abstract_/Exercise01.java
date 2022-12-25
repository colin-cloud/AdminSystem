package com.wqf.abstract_;

public class Exercise01 {

    public static void main(String[] args) {

        Manager manager = new Manager("小王", "299",200, 200 );
        manager.work();
        CommonEmployee commonEmployee = new CommonEmployee("小李", "29", 20);
        commonEmployee.work();
    }
}

abstract class Employee {
    private String name;
    private String id;
    private double salary;

    public Employee(String name, String id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
    public abstract void work();
}
class Manager extends Employee {
    private double bonus;

    public Manager(String name, String id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    public void work() {
        System.out.println("经理在工作");
    }
}
class CommonEmployee extends Employee {
    public CommonEmployee(String name, String id, double salary) {
        super(name, id, salary);
    }
    public void work() {
        System.out.println("员工工作中");
    }
}
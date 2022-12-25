package com.wqf.polymorphic.apply;

public class PolymorphicParameter {

    public static void main(String[] args) {

        Employee employee = new Employee("jack", 10000);
        Employee staff = new Staff("smith", 10000);
        Employee manager = new Manager("scott", 20000, 2000);
        Test test = new Test();
        test.testWork(staff);
        test.showEmpAnnal(staff);
        test.testWork(manager);
        test.showEmpAnnal(manager);
    }
}

class Employee {
    private String name;
    private double salary;//月工资

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getAnnual() {
        return getSalary() * 12;
    }
}

class Staff extends Employee {

    public Staff(String name, double salary) {
        super(name, salary);
    }

    public void work() {
        System.out.println(getName() + "正在工作");
    }

    @Override
    public double getAnnual() {
        return super.getAnnual();
    }
}

class Manager extends Employee {
    private double bonus;

    public Manager(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    public double getBonus() {
        //
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public void manage() {
        System.out.println(getName() + "管理员工");
    }

    @Override
    public double getAnnual() {
        return super.getAnnual() + getBonus();
    }
}

class Test {
    public void showEmpAnnal(Employee e) {
        //实现获取任何员工对象的年工资
        System.out.println(e.getAnnual());
    }
    public void testWork(Employee e) {
        if (e instanceof Staff) {
            ((Staff) e).work();
        } else if (e instanceof Manager) {
            ((Manager) e).manage();
        }
    }
}
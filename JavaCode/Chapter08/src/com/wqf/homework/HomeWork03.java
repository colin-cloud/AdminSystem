//package com.wqf.homework;
//
//public class HomeWork03 {
//
//    public static void main(String[] args) {
//
//        Staff staff = new Staff("小王", 400, 30, 1.0);
//        Manager manager = new Manager("小陈", 500, 30,1000, 1.2);
//        staff.displayWage();
//        manager.displayWage();
//        manager.setBonus(2000);
//        manager.displayWage();
//    }
//}
//
//class Employee {
//    private String name;
//    private double dailyWage;
//    private int day;
//    private double grade;
//
//    public Employee(String name, double dailyWage, int day, double grade) {
//        this.setName(name);
//        this.setDay(day);
//        this.setDailyWage(dailyWage);
//        this.setGrade(grade);
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
//    public double getDailyWage() {
//        return dailyWage;
//    }
//
//    public void setDailyWage(double dailyWage) {
//        this.dailyWage = dailyWage;
//    }
//
//    public int getDay() {
//        return day;
//    }
//
//    public void setDay(int day) {
//        this.day = day;
//    }
//
//    public void setGrade(double grade) {
//        this.grade = grade;
//    }
//
//    public double getGrade() {
//        return grade;
//    }
//
//    public void displayWage() {
//        System.out.println(dailyWage * day);
//    }
//}
//class Manager extends Employee {
//    private double managerSalary;
//    private double bonus;
//    public Manager(String name, double dailyWage, int day, double bonus, double grade) {
//        super(name, dailyWage, day, grade);
//        this.setBonus(bonus);
//    }
//    public void setBonus(double bonus) {
//        this.bonus = bonus;
//    }
//    public double getBonus() {
//        return bonus;
//    }
//    //设置工资
//    public void setManagerSalary() {
//        managerSalary = getBonus() + getDailyWage() * getDay() * getGrade();
//    }
//    public double getManagerSalary() {
//        setManagerSalary();
//        return managerSalary;
//    }
//    @Override
//    public void displayWage() {
//        System.out.println(getName() + "工资为" + getManagerSalary());
//    }
//}
//class Staff extends Employee {
//    private double staffSalary;
//    public Staff(String name, double dailyWage, int day, double grade) {
//        super(name, dailyWage, day, grade);
//        staffSalary = dailyWage * day * grade;
//    }
//
//    @Override
//    public void displayWage() {
//        System.out.println(getName() + "工资为" + staffSalary);
//    }
//}

package com.wqf.generic.exercise;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Exercise02 {

    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();
        Employee employee = new Employee("小王w", 0, new MyDate(9, 23, 2003));
        Employee employee1 = new Employee("小陈w", 0, new MyDate(8, 24, 2002));
        Employee employee2 = new Employee("小熊", 0, new MyDate(9, 24, 2003));
        employees.add(null);
        employee.getClass().getSimpleName();
        employees.add(employee);
        employees.add(employee1);
        employees.add(employee2);
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1 == null) {
                    return -1;
                }
                if (o2 == null) {
                    return 1;
                }
                //下面是进行date的比较，应放到mydate类中实现成一个方法,重写comparable中的compareTo方法
                if (o1.getName().length() == o2.getName().length()) {
                    if (o1.getBirthday().getYear() == o2.getBirthday().getYear()) {
                        if (o1.getBirthday().getMonth() == o2.getBirthday().getMonth()) {
                            if (o1.getBirthday().getDay() == o2.getBirthday().getDay()) {
                                return 0;
                            }
                            return o1.getBirthday().getDay() - o2.getBirthday().getDay();
                        }
                        return o1.getBirthday().getMonth() - o2.getBirthday().getMonth();
                    }
                    return o1.getBirthday().getYear() - o2.getBirthday().getYear();
                }
                return o2.getName().length() - o1.getName().length();
            }
        });
        System.out.println(employees);
    }
}
class MyDate {
    private int month;
    private int day;
    private int year;

    public MyDate(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;

    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "month=" + month +
                ", day=" + day +
                ", year=" + year +
                '}';
    }
}
class Employee {
    private String name;
    private double salary;
    private MyDate birthday;

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

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    public Employee(String name, double salary, MyDate birthday) {
        this.name = name;
        this.salary = salary;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", birthday=" + birthday +
                '}' + "\n";
    }
}

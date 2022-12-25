package com.wqf.collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author 小白学java
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class Exercise01 {

    public static void main(String[] args) {

        HashMap map = new HashMap();
        map.put("01", new Employee("小王", "01", 200000));
        map.put("02", new Employee("小李", "02", 2000));
        map.put("03", new Employee("小陈", "03", 200000));
        Set set = map.entrySet();
        for (Object obj : set) {
            Map.Entry entry = (Map.Entry) obj;
            Employee value = (Employee) entry.getValue();
            if(value.getSalary() > 18000)
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }
}
@SuppressWarnings({"all"})
class Employee {

    private String name;
    private String id;
    private double salary;

    public Employee(String name, String id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", salary=" + salary +
                '}';
    }
}
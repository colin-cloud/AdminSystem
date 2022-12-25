package com.wqf.encapsulation;


public class Encapsulation01 {
    /*要求:不能随便查看人的年龄，工资等隐私，并对设置的年龄进行合理的验证。
    年龄合理就设置，否则就默认年龄，必须在年龄1~120，
    工资不能直接查看，name的长度在2~6个字符之间
     */
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("00000");
        person.setAge(29);
        person.setSalary(30000);
        System.out.println("人的信息如下:");
        System.out.println(person.showInfo());
        //缺点:使用构造器可以进行破解
        Person smith = new Person("smith", 299999, 20000);
        System.out.println(smith.showInfo());
        //代码进行健壮:

    }
}

class Person {
    //人的字段
    public String name;//name的长度在2~6个字符之间
    private int age;
    private double salary;

    //创建构造器
    public Person() {

    }

    public Person(String name, int age, double salary) {
        //该种方法不能对构造器起作用，对代码进行完善 ：
//        this.name = name;
//        this.age = age;
//        this.salary = salary;

        //使程序更加健壮
        this.setName(name);
        this.setAge(age);
        this.setSalary(salary);
    }

    //对类的字段进行封装
    public void setName(String name) {
        //如果符合逻辑就复制
        if (name != null) {
            if (name.length() >= 2 && name.length() <= 6) {
            this.name = name;
            } else {
                //设置一个默认值
                System.out.println("姓名输入错误，置为默认值");
                this.name = "XXX";
            }
        } else {
            System.out.println("输入错误，年龄不能为空");
        }
    }
    public String getName() {
      return this.name;
    }
    public void setAge(int age) {
        if (age >= 1 && age <= 120) {
            this.age = age;
        } else {
            System.out.println("年龄输入错误，置为默认值");
            this.age = 18;
        }
    }
    public int getAge() {
        return this.age;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public double getSalary() {
        return this.salary;
    }
    public String showInfo() {
        return "姓名 :" + this.name + " 年龄 :" + this.age + " 工资 :" + this.salary;
    }
}
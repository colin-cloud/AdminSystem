package com.wqf.encapsulation;

public class EncapsulationExercise {
    /*创建程序，在其中定义两个类：Account和AccountTest类
    1. Account类要求具有属性：姓名(长度为2位3位或4位)、余额(必须>20)、密码(必须是6位)，如果不满足，提示信息，给出默认值
    2. 通过setXXX的方法给Account赋值
     */
    public static void main(String[] args) {
        Account account = new Account("smith", 299, "000000");
        System.out.println(account.showInfo());
        System.out.println(account.getMoney());
    }
}

class Account {
    private String name;
    private double money;
    private String keyWord;
    //构造器

    public Account() {

    }

    public Account(String name, double money, String keyWord) {
        this.setName(name);
        this.setMoney(money);
        this.setKeyWord(keyWord);
    }
    //对属性进行封装
    //Account类要求具有属性：姓名(长度为2位3位或4位)、余额(必须>20)、密码(必须是6位)，如果不满足，提示信息，给出默认值
    public String getName() {
        return name;
    }

    public void setName(String name) {
        //姓名(长度为2位3位或4位)
        if (name.length() >= 2 && name.length() <= 6) {
            this.name = name;
        } else {
            System.out.println("姓名输入错误，置为默认值");
            this.name = "XXX";
        }
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        //余额(必须>20)
        if (money > 20) {
            this.money = money;
        } else {
            System.out.println("余额不足");
            this.money = 0;
        }
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        //密码(必须是6位)
        if (keyWord.length() == 6) {
            this.keyWord = keyWord;
        } else {
            System.out.println("密码输入错误，为6位");
            this.keyWord = null;
        }
    }
    public String showInfo() {
        return this.name + " " + this.money;
    }
}

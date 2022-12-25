package com.wqf.homework;

import java.util.Scanner;

public class HomeWork05 {

    public static void main(String[] args) {

//        CheckingAccount checkingAccount = new CheckingAccount(1000);
//        checkingAccount.deposit(10);
//        System.out.println(checkingAccount.getBalance());
        SavingsAccount savingsAccount = new SavingsAccount(1000);
        savingsAccount.deposit(100);
        savingsAccount.deposit(100);
        savingsAccount.deposit(100);
        System.out.println(savingsAccount.getBalance());
        savingsAccount.withdraw(100);
        savingsAccount.withdraw(100);
        savingsAccount.withdraw(100);
        System.out.println(savingsAccount.getBalance());
        savingsAccount.earnMonthlyInterest();
        savingsAccount.deposit(100);
        System.out.println(savingsAccount.getBalance());
    }
}
class BankAccount {
    private double balance;
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    public void deposit(double amount) {
        balance += amount;
    }
    public void withdraw(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

class CheckingAccount extends BankAccount {
    public CheckingAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount - 1);
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount + 1);
    }
}
class SavingsAccount extends BankAccount {
    private int n = 3;
    public SavingsAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void deposit(double amount) {
        Scanner scanner = new Scanner(System.in);
        if (this.n > 0) {
            System.out.println("你还有" + n + "次免手续费的机会" + "请问是否使用免手续费功能(yes/no):");
            String answer = scanner.next();
            if (answer.equals("yes")) {
                super.deposit(amount);
                this.n--;
            }
        } else {
            System.out.println("你这个月的免手续费功能使用完毕");
            super.deposit(amount - 1);
        }
    }

    @Override
    public void withdraw(double amount) {
        Scanner scanner = new Scanner(System.in);
        if (this.n > 0) {
            System.out.println("你还有" + n + "次免手续费的机会" + "请问是否使用免手续费功能(yes/no):");
            String answer = scanner.next();
            if (answer.equals("yes")) {
                super.withdraw(amount);
                this.n--;
            }
        } else {
            System.out.println("你这个月的免手续费功能使用完毕");
            super.withdraw(amount + 1);
        }
    }
    public void earnMonthlyInterest() {
        n = 3;
        super.deposit(10);
    }
}
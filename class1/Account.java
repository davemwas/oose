package oop.class1;
public class Account {

    public int accountNo;
    public String accountName;
    public double balance;

    public void deposit(double amount){
        balance = balance + amount;
    }
}
package oop.class1;
public class CreateAccount {
    public static void main(String[] args) {
    Account daveAccount = new Account(); 
    daveAccount.accountNo = 591;
    daveAccount.accountName = "David";
    daveAccount.balance = 1800;

    System.out.println("A/c no: " + daveAccount.accountNo + " A/c name: " + daveAccount.accountName + " Balance: " + daveAccount.balance);
    }
}


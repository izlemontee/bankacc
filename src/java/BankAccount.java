package src.java;

import java.util.ArrayList;
import java.util.List;

public class BankAccount{
    private String accountName;
    private String accountNumber;
    private float balance;
    private List<Transaction> transactionList = new ArrayList<>();
    private boolean isClosed = false;
    private String openDate;
    private String closeDate;
    
    //first constructor has a parameter which is the account holder's name
    public BankAccount(String accountName){
        this.accountName = accountName;
        this.isClosed = false;
        balance = 0;

    }

    //second constructor has 2 parameters- account holder's name and initial balance
    public BankAccount(String accountName, float balance){
        this.accountName = accountName;
        this.isClosed = false;
        this.balance = balance;
    }

    public void deposit(Transaction t){
        transactionList.add(t);
        float amt = t.getAmt();
        balance += amt;
        t.description();
    }

    public void withdraw(Transaction t){
        transactionList.add(t);
        float amt = t.getAmt();
        balance -= amt;
        t.description();
    }

    public void setStatus(boolean status){
        isClosed = status;
    }

    public boolean getStatus(){return isClosed;}

}
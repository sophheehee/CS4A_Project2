package org.example;

public class Account {
    private String accountName;
    private int accountNumber;
    private float balance;

    public Account() {
        this.accountName = "";
        this.accountNumber = 0;
        this.balance = 0;
    }
    public Account(String accountName, int accountNumber, float balance) {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getName() {
        return accountName;
    }

    public void setName(String accountName) {
        this.accountName = accountName;
    }

    public int getAccNumber() {
        return accountNumber;
    }

    public void setAccNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }


    public int getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public float getBalance() {
        return balance;
    }

    public float withdraw(float amount) throws InsufficientFunds {
        if (amount > this.balance) {
             throw new InsufficientFunds("Withdrawal Failed, Balance less than " + amount);
        }
        this.balance -= amount;
        return amount;
    }

    public boolean deposit(float amount){
        if (amount < 0) {
             System.out.println("Deposit Failed, Negative deposit is not allowed");
             return false;
        }
        this.balance += amount;
        return true;
    }
}


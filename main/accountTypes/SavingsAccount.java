package org.example.main.accountTypes;

import org.example.main.exceptions.InsufficientFunds;
import org.example.main.Account;
import org.example.main.interfaces.IntrestBearing;

public class SavingsAccount extends Account implements IntrestBearing{
    float intrestrate;

    public SavingsAccount() {
        super();
        this.intrestrate = 0;
    }
    public SavingsAccount(float intrestrate) {
        super();
        this.intrestrate = intrestrate;
    }
    // account constructor with all parameters
    public SavingsAccount(String accountName, int accountNumber, float balance) {
        super(accountName, accountNumber, balance);
        this.intrestrate = 0;
    }
    public SavingsAccount(String accountName, int accountNumber, float balance, float intrestrate) {
        super(accountName, accountNumber, balance);
        this.intrestrate = intrestrate;
    }

    public float getIntrestRate() {
        return intrestrate;
    }
    public void setIntrestRate(float intrestrate) {
        this.intrestrate = intrestrate;
    }

    @Override
    public float applyIntrest(int months, boolean addToBalance){
        float balance = super.getBalance();
        float intrest = (balance * this.intrestrate * months);
        if(addToBalance==true){
            deposit(intrest);
        } 
        return intrest;
    }

    @Override
    public boolean deposit(float amount) {
        return super.deposit(amount);
    }

    @Override
    public float withdraw(float amount) throws InsufficientFunds {
        return super.withdraw(amount);
    }
}

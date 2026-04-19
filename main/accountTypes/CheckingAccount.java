//package org.example;

import org.cs4a.BankProject.Account;
import org.cs4a.BankProject.InsufficientFunds;
import org.cs4a.BankProject.IntrestBearing;

public class CheckingAccount extends Account implements LoanEligible{
    float minbalance;
    int timesBelowMinBalance;

    public CheckingAccount() {
        super();
        this.minbalance = 0;
    }
    public CheckingAccount(float minbalance) {
        super();
        this.minbalance = minbalance;
    }
    // account constructor with all parameters
    public CheckingAccount(String accountName, int accountNumber, float balance) {
        super(accountName, accountNumber, balance);
        this.minbalance = 0;
    }
    public CheckingAccount(String accountName, int accountNumber, float balance, float minbalance) {
        super(accountName, accountNumber, balance);
        this.minbalance = minbalance;
    }

    public float getminbalance() {
        return minbalance;
    }
    public void setminbalance(float minbalance) {
        this.minbalance = minbalance;
    }

    @Override
    public boolean checkLoanEligible(){
        if(timesBelowMinBalance > 5){
            return false;
        }
        return true;
    }

    @Override
    public boolean deposit(float amount) {
        return super.deposit(amount);
    }

    @Override
    public float withdraw(float amount) throws InsufficientFunds {
        //if balance minus amount is above min balance and also above zero
        if ((minbalance > (super.getBalance() - amount)) && ((super.getBalance() - amount)>0)) {
            throw new InsufficientFunds("WARNING: Withdrawal of " + amount + " brings your account below minimum balance $" + minbalance);
            timesBelowMinBalance++;
        }
        // call the original withdraw for
        return super.withdraw(amount);
    }
}


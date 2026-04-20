package org.example.main.accountTypes;
// had to just copy and paste this bc my ide wouldn't pull it
import java.util.ArrayList;
import java.util.List;

import org.example.main.Account;
import org.example.main.interfaces.LoanEligible;


public class BusinessAccount extends Account implements LoanEligible {
    List<String> authorizedUsers;

    public BusinessAccount() {
        super();
        authorizedUsers = new ArrayList<>();
    }

    public BusinessAccount(List<String> authorizedUsers) {
        super();
        this.authorizedUsers = authorizedUsers;
    }

    public BusinessAccount(String accountName, int accountNumber, float balance) {
        super(accountName, accountNumber, balance);
        authorizedUsers = new ArrayList<>();
    }

    public BusinessAccount(String accountName, int accountNumber, float balance, List<String> authorizedUsers) {
        super(accountName, accountNumber, balance);
        this.authorizedUsers = authorizedUsers;
    }

    public List<String> getAuthorizedUsers() {
        return authorizedUsers;
    }

    public void addAuthorizedUser(String user) {
        authorizedUsers.add(user);
    }

    @Override
    public boolean checkLoanEligible() {
        if (super.getBalance() > 1000) {
            return true;
        }
        return false;
    }

    @Override
    public boolean deposit(float amount) {
        return super.deposit(amount);
    }

    @Override
    public float withdraw(float amount) {
        return super.withdraw(amount);
    }
}
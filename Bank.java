package org.example;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public void addAcc(Account account) {
        accounts.add(account);
    }

    public Account removeAcc(int accountNumber) throws AccountNotFound {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccNumber() == accountNumber) {
                return accounts.remove(i);
            }
        }
        throw new AccountNotFound("Account removal failed: no account found with number " + accountNumber);
    }

    public Account getAccount(int accountNumber) throws AccountNotFound {
        for (Account account : accounts) {
            if (account.getAccNumber() == accountNumber) {
                return account;
            }
        }
        throw new AccountNotFound("Account not found with number " + accountNumber);
    }
}

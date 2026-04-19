package org.example;

public class CreditAccount extends Account {
    private float creditLimit;

    // default account constructor
    public CreditAccount() {
        super();
        this.creditLimit = 0;
    }
    public CreditAccount(float creditLimit) {
        super();
        this.creditLimit = creditLimit;
    }
    // account constructor with all parameters
    public CreditAccount(String accountName, int accountNumber, float balance) {
        super(accountName, accountNumber, balance);
        this.creditLimit = 0;
    }
    public CreditAccount(String accountName, int accountNumber, float balance, float creditLimit) {
        super(accountName, accountNumber, balance);
        this.creditLimit = creditLimit;
    }

    public float getCreditLimit() {
        return creditLimit;
    }
    public void setCreditLimit(float creditLimit) {
        this.creditLimit = creditLimit;
    }

    //i learned that with creditcards the balance is the amount u owe
    //so we should check if the amount u want would make ur balance to high if u get me
    @Override
    public float withdraw(float amount) throws InsufficientFunds {
        if ((super.getBalance() + amount) > creditLimit) {
            throw new InsufficientFunds("Credit Withdrawal of " + amount + "Failed, Amount more than " + creditLimit + " credit limit");
        }
        // call the original withdraw for
        // this makes it so withdrawing increases the balance u owe
        return super.deposit(amount);
    }
}

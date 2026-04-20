package org.example.main;
//imports
import java.util.Scanner;

import org.example.main.accountTypes.BusinessAccount;
import org.example.main.accountTypes.CheckingAccount;
import org.example.main.accountTypes.CreditAccount;
import org.example.main.accountTypes.SavingsAccount;
import org.example.main.exceptions.AccountNotFound;
import org.example.main.exceptions.InsufficientFunds;

public class Main {
    public Main(){super();} // idk if i actually need this but it was in the last one lol
    public static void main(String[] args){
        // create new bank manager object
        Bank bankManager = new Bank();

        //input scanner creation
        Scanner input = new Scanner(System.in);

        // MAIN PROGRAM LOOP
        int mainChoice = 0;
        while(mainChoice != 3){
            System.out.println();
            System.out.println("Welcome to Saddleback Bank");

            // Main Menu
            System.out.println("---------------------------");
            System.out.println("     Account Options ");
            System.out.println("---------------------------");
            System.out.println("1. Open New Account");
            System.out.println("2. Manage Existing Account");
            System.out.println("3. Exit ");
            System.out.print(" Selection: ");

            mainChoice = getIntInput(input);

            switch(mainChoice){
                case 1: // open new account menu
                    openNewAccount(bankManager, input);
                    break;
                case 2: // existing account submenu
                    System.out.println("Loading account information...");
                    clearScreen();
                    manageAccount(bankManager, input);
                    break;
                case 3: // exit the program
                    System.out.println("Exiting...");
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;

            }


        }
    }


    // submenu functions yay!
    private static void openNewAccount(Bank bankManager, Scanner input){
        int accChoice = 0;
        while(accChoice != 5){
            System.out.println("* * * * * SADDLEBACK BANK * * * * *");
            System.out.println("        NEW ACCOUNT OPTIONS         ");
            System.out.println("*************************************");
            System.out.println("1. Open Savings Account");
            System.out.println("2. Open Checking Account");
            System.out.println("3. Open Business Account");
            System.out.println("4. Open Credit Account");
            System.out.println("5. Return to main menu");
            System.out.print(" Selection: ");

            accChoice = getIntInput(input);

            switch(accChoice){
                case 1: { // savings
                    System.out.print("Enter account name: ");
                    String name = input.nextLine();

                    System.out.print("Enter account number: ");
                    int number = getIntInput(input);
                    if (accountExists(bankManager, number)) { // make sure it do not!
                        System.out.println("Error: Account number already exists.");
                        break;
                    }
                    System.out.print("Enter starting balance: ");
                    float balance = getFloatInput(input);

                    System.out.print("Enter interest rate: ");
                    float interestRate = getFloatInput(input);

                    SavingsAccount account =
                            new SavingsAccount(name, number, balance, interestRate);

                    bankManager.addAcc(account);
                    System.out.println("Savings account created successfully.");
                    break;
                }
                case 2: { //checking
                    System.out.print("Enter account name: ");
                    String name = input.nextLine();

                    System.out.print("Enter account number: ");
                    int number = getIntInput(input);
                    if (accountExists(bankManager, number)) {
                        System.out.println("Error: Account number already exists.");
                        break;
                    }
                    System.out.print("Enter starting balance: ");
                    float balance = getFloatInput(input);

                    System.out.print("Enter minimum balance: ");
                    float minBalance = getFloatInput(input);

                    CheckingAccount account = new CheckingAccount(name, number, balance, minBalance);
                    bankManager.addAcc(account);
                    System.out.println("Checking account created successfully.");
                    break;

                }
                case 3:{ //business acc
                    System.out.print("Enter account name: ");
                    String name = input.nextLine();

                    System.out.print("Enter account number: ");
                    int number = getIntInput(input);
                    if (accountExists(bankManager, number)) {
                        System.out.println("Error: Account number already exists.");
                        break;
                    }
                    System.out.print("Enter starting balance: ");
                    float balance = getFloatInput(input);
                    BusinessAccount account = new BusinessAccount(name, number, balance);
                    bankManager.addAcc(account);
                    System.out.println("Business account created successfully.");
                    break;
                }
                case 4: { //crebit
                    System.out.print("Enter account name: ");
                    String name = input.nextLine();

                    System.out.print("Enter account number: ");
                    int number = getIntInput(input);
                    if (accountExists(bankManager, number)) {
                        System.out.println("Error: Account number already exists.");
                        break;
                    }
                    System.out.print("Enter starting balance: ");
                    float balance = getFloatInput(input);

                    System.out.print("Enter credit limit: ");
                    float creditLimit = getFloatInput(input);

                    CreditAccount account = new CreditAccount(name, number, balance, creditLimit);
                    bankManager.addAcc(account);
                    System.out.println("Credit account created successfully.");
                    break;
                }
                case 5:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }

    }
    // general account management to detremine what kind of account
    private static void manageAccount(Bank bankManager, Scanner input) {
        System.out.print("Enter account number: ");
        int accountNumber = getIntInput(input);

        try {
            Account account = bankManager.getAccount(accountNumber);

            if (account instanceof SavingsAccount) {
                manageSavingsAccount((SavingsAccount) account, input);
            } else if (account instanceof CheckingAccount) {
                manageCheckingAccount((CheckingAccount) account, input);
            } else if (account instanceof BusinessAccount) {
                manageBusinessAccount((BusinessAccount) account, input);
            } else if (account instanceof CreditAccount) {
               manageCreditAccount((CreditAccount) account, input);
            } else {
                System.out.println("Unknown account type.");
            }

        } catch (AccountNotFound e) {
            System.out.println(e.getMessage());
        }
    }
    //******************* MANAGEMENT OF EACH ACCOUNT TYPE******************
private static void manageCheckingAccount(CheckingAccount account, Scanner input) {
        int choice = 0;

        while (choice != 5) {
            System.out.println("\n* * * CHECKING ACCOUNT MENU * * *");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. View Balance");
            System.out.println("4. Check Loan Eligibility");
            System.out.println("5. Return");
            System.out.print("Selection: ");

            choice = getIntInput(input);

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    float dep = getFloatInput(input);
                    if (account.deposit(dep)) {
                        System.out.println("Deposit successful.");
                    }
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    float w = getFloatInput(input);
                    try {
                        account.withdraw(w);
                        System.out.println("Withdrawal successful.");
                    } catch (InsufficientFunds e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Balance: $" + account.getBalance());
                    break;

                case 4:
                    System.out.println(account.checkLoanEligible()
                            ? "Eligible for loan"
                            : "Not eligible for loan");
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
private static void manageSavingsAccount(SavingsAccount account, Scanner input) {
        int choice = 0;

        while (choice != 5) {
            System.out.println("\n* * * SAVINGS ACCOUNT MENU * * *");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Apply Interest");
            System.out.println("4. View Balance");
            System.out.println("5. Return");
            System.out.print("Selection: ");

            choice = getIntInput(input);

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    float dep = getFloatInput(input);
                    account.deposit(dep);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    float w = getFloatInput(input);
                    try {
                        account.withdraw(w);
                    } catch (InsufficientFunds e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.print("Enter number of months: ");
                    int months = getIntInput(input);
                    System.out.print("Add interest to balance? (1 = yes, 0 = no): ");
                    boolean add = getIntInput(input) == 1;
                    float interest = account.applyIntrest(months, add);
                    System.out.println("Interest: $" + interest);
                    break;
                case 4:
                    System.out.println("Balance: $" + account.getBalance());
                    break;
                case 5:
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }

private static void manageBusinessAccount(BusinessAccount account, Scanner input) {
        int choice = 0;

        while (choice != 7) {
            System.out.println("\n* * * BUSINESS ACCOUNT MENU * * *");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. View Balance");
            System.out.println("4. Add Authorized User");
            System.out.println("5. View Authorized Users");
            System.out.println("6. Check Loan Eligibility");
            System.out.println("7. Return");
            System.out.print("Selection: ");

            choice = getIntInput(input);

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    float dep = getFloatInput(input);
                    account.deposit(dep);
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    float w = getFloatInput(input);
                    try {
                        account.withdraw(w);
                    } catch (InsufficientFunds e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("Balance: $" + account.getBalance());
                    break;

                case 4:
                    System.out.print("Enter user name: ");
                    String user = input.nextLine();
                    account.addAuthorizedUser(user);
                    break;

                case 5:
                    System.out.println("Authorized Users:");
                    for (String u : account.getAuthorizedUsers()) {
                        System.out.println("- " + u);
                    }
                    break;

                case 6:
                    System.out.println(account.checkLoanEligible()
                            ? "Eligible for loan"
                            : "Not eligible for loan");
                    break;

                case 7:
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
private static void manageCreditAccount(CreditAccount account, Scanner input) {
        int choice = 0;

        while (choice != 5) {
            System.out.println("\n* * * CREDIT ACCOUNT MENU * * *");
            System.out.println("1. Use Credit");
            System.out.println("2. Make Payment");
            System.out.println("3. View Balance");
            System.out.println("4. View Credit Limit");
            System.out.println("5. Return");
            System.out.print("Selection: ");

            choice = getIntInput(input);

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to use: ");
                    float use = getFloatInput(input);
                    try {
                        account.withdraw(use);
                    } catch (InsufficientFunds e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Enter payment amount: ");
                    float pay = getFloatInput(input);
                    account.deposit(pay);
                    break;
                case 3:
                    System.out.println("Balance (amount owed): $" + account.getBalance());
                    break;
                case 4:
                    System.out.println("Credit Limit: $" + account.getCreditLimit());
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
    //UTILITIES - i just copied and pasted everything over from project 1 basically
//helper function to manage possible input prob like same as last time
    private static int getIntInput(Scanner input) {
        try { // updated now so it won't be a problem with adding extra buffers and stuff everywhere
            return Integer.parseInt(input.nextLine()); // fixed that variable redundancy
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    // clears the screen (in a terminal, not my ide tho)
    public static void clearScreen(){
        System.out.print("\033[H\033[2J"); //use ansi excape code for terminal clear
    }
    // just a screen pause basically
    public static void pause(Scanner input){
        System.out.println("\n(Press Enter to Continue...)");
        if(input.hasNextLine()){
            input.nextLine();
        }
    }
    // helper for floats
    private static float getFloatInput(Scanner input) {
        try {
            return Float.parseFloat(input.nextLine());
        } catch (Exception e) {
            return -1;
        }
    }
// helper to make sure account doesn't exist yety
private static boolean accountExists(Bank bankManager, int number) {
    try {
        bankManager.getAccount(number);
        return true;
    } catch (AccountNotFound e) {
        return false;
    }
}
}// where main class ends

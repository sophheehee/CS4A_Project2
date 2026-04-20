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

//        if (accChoice == 1){
//            addAcc(Account account){ accounts.addAcc
//        }


        }

    }
    // general account management to detremine what kind of account
    private static void manageAccount(Bank bankManager, Scanner input) {
        System.out.print("Enter account number: ");
        int accountNumber = getIntInput(input);

        try {
            Account account = bankManager.getAccount(accountNumber);

            if (account instanceof SavingsAccount) {
                //manageSavingsAccount((SavingsAccount) account, input);
            } else if (account instanceof CheckingAccount) {
                //manageCheckingAccount((CheckingAccount) account, input);
            } else if (account instanceof BusinessAccount) {
                //manageBusinessAccount((BusinessAccount) account, input);
            } else if (account instanceof CreditAccount) {
               // manageCreditAccount((CreditAccount) account, input);
            } else {
                System.out.println("Unknown account type.");
            }

        } catch (AccountNotFound e) {
            System.out.println(e.getMessage());
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



}// where main class ends

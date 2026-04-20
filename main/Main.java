//imports
import java.util.Scanner;
import java.util.Vector;


public class Main {
    public Main(){super();}
    public static void main(String[] args){
        // create new bank manager object
        Bank bankManager = new Bank();

        //import utilities
        Scanner input = new Scanner(System.in);

        // MAIN PROGRAM LOOP
        int mainChoice = 0;
        while(mainChoice ! = 3){
            System.out.println();
            System.out.println("Welcome to Saddleback Bank");

            // Main Menu
            System.out.println("---------------------------");
            System.out.println("     Account Options ");
            System.out.println("---------------------------");
            System.out.println("1. Open New Account");
            System.out.println("2. Manage Existing Account");
            System.out.println("3. Exit ");


        }
    }
}
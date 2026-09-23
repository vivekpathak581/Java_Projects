package Project_Constructor_And_Encapsulation;

import java.util.Scanner;

class Account {

    private String accountHolder;
    private long accountNumber;
    private double balance;

    Account(String accountHolder, long accountNumber, double balance) {

        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;

        System.out.println("\nAccount created successfully!");
    }

    void displayAccount() {

        System.out.println("\n===== ACCOUNT DETAILS =====");
        System.out.println("Account Holder : " + this.accountHolder);
        System.out.println("Account Number : " + this.accountNumber);
        System.out.println("Balance        : ₹" + this.balance);
    }


    void deposit(double amount) {

        if (amount < 100) {
            System.out.println("Minimum deposit amount is ₹100.");
            return;
        }

        this.balance = this.balance + amount;

        System.out.println("₹" + amount + " deposited successfully.");
        System.out.println("Current Balance: ₹" + this.balance);
    }

    void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Enter a valid withdrawal amount.");
            return;
        }

        if (amount > this.balance) {
            System.out.println("Insufficient balance.");
            return;
        }

        this.balance = this.balance - amount;

        System.out.println("₹" + amount + " withdrawn successfully.");
        System.out.println("Current Balance: ₹" + this.balance);
    }
    void checkBalance() {

        System.out.println("Current Balance: ₹" + this.balance);
    }
}


public class ATM {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== CREATE YOUR ACCOUNT =====");

        System.out.print("Enter your name: ");
        String accountHolder = sc.nextLine();

        System.out.print("Enter your account number: ");
        long accountNumber = sc.nextLong();

        System.out.print("Enter initial balance (minimum ₹2000): ");
        double balance = sc.nextDouble();

        while (balance < 2000) {

            System.out.println(
                    "Please enter a valid amount greater than or equal to ₹2000."
            );

            System.out.print("Enter initial balance again: ");
            balance = sc.nextDouble();
        }

        Account ac = new Account(accountHolder, accountNumber, balance);

        ac.displayAccount();

        int choice;

        do {

            System.out.println("\n********** ATM MAIN MENU **********");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Account Details");
            System.out.println("5. Exit");
            System.out.println("***********************************");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();

                    ac.deposit(depositAmount);

                    break;


                case 2:

                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();

                    ac.withdraw(withdrawAmount);

                    break;


                case 3:

                    ac.checkBalance();

                    break;


                case 4:

                    ac.displayAccount();

                    break;


                case 5:

                    System.out.println(
                            "Thank you for using our ATM."
                    );

                    break;


                default:

                    System.out.println(
                            "Invalid choice. Please select 1-5."
                    );
            }

        } while (choice != 5);
        sc.close();
    }
}

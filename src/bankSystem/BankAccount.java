package bankSystem;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BankAccount implements Reportable {
    private int accountNumber;
    private String accountHolderName;
    private double balance;
    private List<String> transactions = new ArrayList<>();
    Scanner scanner= new Scanner(System.in);


    @Override
    public  void generateAccountSummary() {
        System.out.println( " Account summary: ");
        System.out.println(" Account number : " + accountNumber);
        System.out.println(" Account Holder Name : " + accountHolderName);
        System.out.println(" Account Balance : " + balance);
    }




    public BankAccount()
    {
    }

    // Constructor to create bank account
    public BankAccount(int accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    // Method to display account details
    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Current Account Balance: " + balance);
    }

    // Method to deposit money into bank account (input in console from user)
    public void deposit() {
        System.out.print("Enter amount to deposit: ");
        try
        {
        double amount = scanner.nextDouble();
            if (amount <= 0) {
                System.out.println("Please enter a valid deposit amount greater than zero");
            } else {
                this.balance += amount;
                recordTransaction(" You are depositing : ", amount);
                System.out.println("Deposit added successfully, Account Balance: " + balance);
            }
        }
        catch (InputMismatchException e)
        {
            System.out.println(" Invalid input. Please enter a numeric value ");
            scanner.nextLine(); // Clear the invalid input
        }
    }


    // Method to withdraw money from bank account (input in console from user)
    public void withdraw()
    {
        System.out.print("Enter amount to withdraw: ");

        try
        {
        double amount = scanner.nextDouble();

        if (amount <= 0)
        {
            System.out.println(" Please enter a valid amount greater than zero");
        }
        else if (amount > balance)
        {
            System.out.println(" No enough balance in your account");
        }
        else
        {
            balance -= amount;
            recordTransaction(" You are withdrawing " , amount);
            System.out.println(" Withdrew is done successfully, Account Balance: " + balance);
        }
    } catch (InputMismatchException e)
        {
            System.out.println("Invalid input. Please enter a numeric value.");
             scanner.nextLine(); // Clear the invalid input
        }
    }

    // method to record transactions
    public void recordTransaction(String transactionType, double amount)
    {
    String record = transactionType + amount + "$" + "Account total balance" + balance;
    transactions.add(record);
    }

    // Method to display transaction history
    public void displayTransactionHistory()
    {
        if (transactions.isEmpty()){
            System.out.println(" No transaction done till now ");
        }
        else {
            System.out.println(" The Transactions is : ");
            for (int i = 0; i < transactions.size(); i++) {
                System.out.println(transactions.get(i));
            }
        }
    }

    // Method to check the account balance
    public void checkBalance()
    {
        System.out.println("Current Balance: " + balance);
    }

    // Method to save transaction in file
    public void saveTransactionHistoryToFile(String fileName)
    {
        try (FileWriter file = new FileWriter(fileName))
        {
            for (int i = 0; i < transactions.size(); i++)
            {
                file.write(transactions.get(i) + "\n");
            }
        }
        catch (IOException e)
        {
            System.out.println("Can't save transaction history" + e.getMessage());
        }
    }
}

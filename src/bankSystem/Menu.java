package bankSystem;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    private BankAccount selectedAccount;

    // Constructor to accept account details
    public Menu(int accountNumber, String accountHolderName, double balance)
    {
        System.out.println(" Choose your account type:");
        System.out.println(" 1- Current account");
        System.out.println(" 2- Saving account");
        int accountType = scanner.nextInt();  // User choose account type

        // Create obj. of account the user choose
        if (accountType == 2)
        {
            selectedAccount = new SavingsAccount(accountNumber, accountHolderName, balance); // Pass values to SavingAccount
        }
        else
        {
            selectedAccount = new BankAccount(accountNumber, accountHolderName, balance); // Pass values to BankAccount
        }
    }

    // Method to show the menu to the user
    public void showMenu()
    {
        try
        {
        while (true) {
            System.out.println(" Welcome to the Bank System, your account is created successfully:");
            System.out.println(" Choose an option:");
            System.out.println(" 1- Deposit ");
            System.out.println(" 2- Withdraw ");
            System.out.println(" 3- Check Balance ");
            System.out.println(" 4- View Transaction History ");
            System.out.println(" 5- Generate account summary ");
            System.out.println(" 6- Apply Interest for 12 Months (Savings Account Only)");
            System.out.println(" 7- End");

           int choice = 0;

           choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    selectedAccount.deposit();
                    break;

                case 2:
                    selectedAccount.withdraw();
                    break;

                case 3:
                    selectedAccount.checkBalance();
                    break;

                case 4:
                    selectedAccount.displayTransactionHistory();
                    break;
                case 5:
                    selectedAccount.generateAccountSummary();
                    break;
                case 6:
                    if (selectedAccount instanceof SavingsAccount) {
                        ((SavingsAccount) selectedAccount).applyInterestFor12Months();
                    } else {
                        System.out.println("Interest application is only available for Savings Accounts.");
                    }
                    break;
                case 7:
                    System.out.println("Thank you for choosing our Bank.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Enter a valid option.");
            }
        }
    }
        catch (InputMismatchException e)
        {
            System.out.println("Invalid input, Enter valid choice.");
        }
}
}

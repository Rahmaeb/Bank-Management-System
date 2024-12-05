package bankSystem;

import java.util.Scanner;

public class SavingsAccount extends BankAccount {
    private final double minimumbalance = 49.9; // Minimum balance
    private double interestRate= 0.05;
    // Scanner scanner= new Scanner(System.in);

    // Constructor for Savings account inherits from Bank account
    public SavingsAccount(int accountNumber, String accountHolderName, double balance)
    {
        super(accountNumber, accountHolderName, balance);
    }

@Override
    public void generateAccountSummary()
    {
        System.out.println();
        System.out.println("Account Type: Savings Account" );
        super.generateAccountSummary();
        System.out.println("Minimum Balance: " + minimumbalance);
              //  "\nInterest Rate: " + (interestRate * 100) + "%");
    }

    @Override
    public void withdraw()
    {
        System.out.println(" Enter valid withdraw value ");
        double amount = scanner.nextDouble();

        if (amount< 0 )
        {
            System.out.println(" Enter valid value ");
        }

        else if (this.getBalance() - amount < minimumbalance)
        {
            System.out.println(" Sorry, No enough balance in your saving account ");
        }

        else {
            setBalance(getBalance() - amount);
            recordTransaction(" You are withdrawing " , amount);
            System.out.println("Withdrew is done successfully, Account Balance: " + getBalance());
        }
    }

    public void applyMonthlyInterest() {
        double monthlyInterest = (getBalance() * interestRate) / 12; // Divide the annual rate by 12
        setBalance(getBalance() + monthlyInterest);
        recordTransaction("Monthly interest applied: ", monthlyInterest);
        System.out.println("New balance after applying monthly interest: " + getBalance());
    }
    public void applyInterestFor12Months() {
        for (int i = 1; i <= 12; i++) {
            applyMonthlyInterest();
            System.out.println("Month " + i + " completed.");
        }
        System.out.println("Interest applied for 12 months. Final balance: " + getBalance());
    }

}




package bankSystem;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        BankAccount A = new BankAccount();
        Scanner scanner = new Scanner(System.in);

        System.out.println(" Enter account number : ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.println(" Enter full name : ");
        String accountHolderName = scanner.nextLine();

        System.out.println(" Enter the start balance : ");
        double balance = scanner.nextDouble();

        Menu menu1 = new Menu(accountNumber, accountHolderName, balance);
        menu1.showMenu();

        A.saveTransactionHistoryToFile(" Record Transaction");
    }
}
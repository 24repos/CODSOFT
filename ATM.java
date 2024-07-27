import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000); // initial balance
        ATM atm = new ATM(userAccount);
        atm.displayMenu();
    }

    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    // Design the user interface for the ATM
    public void displayMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    deposit(depositAmount);
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 4);
        sc.close();
    }

    // Implement methods for each option
    public void withdraw(double amount) {
        try {
            if (account.getBalance() >= amount && amount > 0) {
                account.setBalance(account.getBalance() - amount);
                System.out.println("You have withdrawn: $" + amount);
                System.out.println("New balance: $" + account.getBalance());
            } else {
                throw new Exception("Insufficient balance or invalid amount.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deposit(double amount) {
        try {
            if (amount > 0) {
                account.setBalance(account.getBalance() + amount);
                System.out.println("You have deposited: $" + amount);
                System.out.println("New balance: $" + account.getBalance());
            } else {
                throw new Exception("Invalid amount.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void checkBalance() {
        System.out.println("Your current balance is: $" + account.getBalance());
    }
}

// Class to represent the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

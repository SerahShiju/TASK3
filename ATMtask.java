import java.util.Scanner;
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

// Class to represent the ATM machine
class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount account) {
        bankAccount = account;
    }

    // Method to display user interface and handle options
    public void displayMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        double amount;

        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    amount = sc.nextDouble();
                    deposit(amount);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    amount = sc.nextDouble();
                    withdraw(amount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 4);
    }
    private void checkBalance() {
        System.out.println("Your current balance is: $" + bankAccount.getBalance());
    }
    private void deposit(double amount) {
        if (amount > 0) {
            bankAccount.deposit(amount);
            System.out.println("Deposit successful. Your new balance is: $" + bankAccount.getBalance());
        } else {
            System.out.println("Invalid amount for deposit!");
        }
    }
    private void withdraw(double amount) {
        if (amount > 0) {
            if (bankAccount.withdraw(amount)) {
                System.out.println("Withdrawal successful. Your new balance is: $" + bankAccount.getBalance());
            } else {
                System.out.println("Insufficient funds!");
            }
        } else {
            System.out.println("Invalid amount for withdrawal!");
        }
    }
}

public class ATMtask {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0);
        ATM atm = new ATM(account);
        atm.displayMenu();
    }
}

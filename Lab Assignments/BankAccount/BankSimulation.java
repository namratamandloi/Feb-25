import java.util.Scanner;

// Abstract class defining account operations
abstract class AccountOperations {
    abstract void deposit(double amount);
    abstract void withdraw(double amount);
    abstract void displayBalance();
}

// BankAccount class implementing OOP concepts
class BankAccount extends AccountOperations {
    // Encapsulation: Private instance variables
    private static int accountCounter = 1000;
    private final String accountNumber;
    private String accountHolderName;
    private double balance;

    // Static member to keep track of total accounts
    private static int totalAccounts = 0;

    // Private method to generate a unique account number
    private static String generateAccountNumber() {
        return "BA" + (accountCounter++);
    }

    // Default Constructor
    public BankAccount() {
        this.accountNumber = generateAccountNumber();
        this.accountHolderName = "Unknown";
        this.balance = 0.0;
        totalAccounts++;
    }

    // Parameterized Constructor
    public BankAccount(String accountHolderName, double initialDeposit) {
        this.accountNumber = generateAccountNumber();
        this.accountHolderName = accountHolderName;
        this.balance = initialDeposit;
        totalAccounts++;
    }

    // Copy Constructor
    public BankAccount(BankAccount existingAccount) {
        this.accountNumber = generateAccountNumber();
        this.accountHolderName = existingAccount.accountHolderName;
        this.balance = existingAccount.balance;
        totalAccounts++;
    }

    // Getter methods (Encapsulation)
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    // Deposit method implementation
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Display balance method
    public void displayBalance() {
        System.out.println("Account Balance: " + balance);
    }

    // Static method to display total accounts
    public static void displayTotalAccounts() {
        System.out.println("Total Accounts Created: " + totalAccounts);
    }
}

// Optional: SavingsAccount subclass demonstrating Method Overriding
class SavingsAccount extends BankAccount {
    private static final double MIN_BALANCE = 500.0;

    public SavingsAccount(String accountHolderName, double initialDeposit) {
        super(accountHolderName, initialDeposit);
    }

    public void withdraw(double amount) {
        if (getBalance() - amount >= MIN_BALANCE) {
            super.withdraw(amount);
        } else {
            System.out.println("Withdrawal denied! Minimum balance requirement not met.");
        }
    }
}

// Main class to test functionality
public class BankSimulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter initial deposit amount: ");
        double initialDeposit = scanner.nextDouble();
        
        BankAccount acc1 = new BankAccount(name, initialDeposit);
        
        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Balance");
            System.out.println("4. Exit");
            
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    acc1.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    acc1.withdraw(withdrawAmount);
                    break;
                case 3:
                    acc1.displayBalance();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
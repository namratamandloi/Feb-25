class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

// BankAccount class with synchronization
class BankAccount {
    private int balance;

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited " + amount + ", New Balance: " + balance);
    }

    public synchronized void withdraw(int amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException(Thread.currentThread().getName() + " attempted to withdraw " + amount + ", but insufficient funds. Current Balance: " + balance);
        }
        balance -= amount;
        System.out.println(Thread.currentThread().getName() + " withdrew " + amount + ", New Balance: " + balance);
    }

    public synchronized int getBalance() {
        return this.balance;
    }
}

// Customer class implementing Runnable
class Customer implements Runnable {
    private final BankAccount account;
    private final boolean isDeposit;
    private final int amount;

    public Customer(BankAccount account, boolean isDeposit, int amount) {
        this.account = account;
        this.isDeposit = isDeposit;
        this.amount = amount;
    }

    @Override
    public void run() {
        try {
            if (isDeposit) {
                account.deposit(amount);
            } else {
                account.withdraw(amount);
            }
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
    }
}

// Main class to run the multithreading simulation
public class BankTransaction {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        Thread t1 = new Thread(new Customer(account, true, 500), "Customer1");
        Thread t2 = new Thread(new Customer(account, false, 700), "Customer2");
        Thread t3 = new Thread(new Customer(account, false, 1200), "Customer3");
        Thread t4 = new Thread(new Customer(account, true, 300), "Customer4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
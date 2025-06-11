 

#include <iostream>
#include <string>
using namespace std;

class BankAccount {
    private:
        int accountNumber;
        string accountHolderName;
        double balance;
    public:
        // Constructor to initialize account details
        BankAccount(int accNum, string accHolderName, double initialBalance) {
            accountNumber = accNum;
            accountHolderName = accHolderName;
            balance = initialBalance;
        }

        // Getter for account number
        int getAccountNumber() {
            return accountNumber;
        }

        // Getter for account holder name
        string getAccountHolderName() {
            return accountHolderName;
        }

        // Getter for balance
        double getBalance() {
            return balance;
        }

        // Method to deposit money
        void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                cout << "Deposited: " << amount << ". New balance: " << balance << endl;
            } else {
                cout << "Invalid deposit amount." << endl;
            }
        }

        // Method to withdraw money
        void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                cout << "Withdrawn: " << amount << ". New balance: " << balance << endl;
            } else if (amount > balance) {
                cout << "Insufficient balance." << endl;
            } else {
                cout << "Invalid withdrawal amount." << endl;
            }
        }

        // Method to display account details
        void displayAccountDetails() {
            cout << "\n--- Account Details ---\n";
            cout << "Account Number      : " << accountNumber << endl;
            cout << "Account Holder Name : " << accountHolderName << endl;
            cout << "Current Balance     : " << balance << endl;
        }
};
int main() {
    int accountNumber;
    string accountHolderName;
    double initialBalance;

    cout << "Enter account number: ";
    cin >> accountNumber;
    cin.ignore(); // To clear newline left in the buffer
    cout << "Enter account holder name: ";
    getline(cin, accountHolderName);
    cout << "Enter initial balance: ";
    cin >> initialBalance;

    BankAccount account(accountNumber, accountHolderName, initialBalance);

    int choice;
    do {
        cout << "\n===== Banking Menu =====\n";
        cout << "1. Deposit Money\n";
        cout << "2. Withdraw Money\n";
        cout << "3. Display Account Details\n";
        cout << "4. Exit\n";
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice) {
            case 1: {
                double depositAmount;
                cout << "Enter amount to deposit: ";
                cin >> depositAmount;
                account.deposit(depositAmount);
                break;
            }
            case 2: {
                double withdrawAmount;
                cout << "Enter amount to withdraw: ";
                cin >> withdrawAmount;
                account.withdraw(withdrawAmount);
                break;
            }
            case 3:
                account.displayAccountDetails();
                break;
            case 4:
                cout << "Exiting program.\n";
                break;
            default:
                cout << "Invalid choice. Try again.\n";
        }
    } while (choice != 4);

    return 0;
}

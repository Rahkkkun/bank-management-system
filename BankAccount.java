import java.util.Scanner;

class BankAccount {
    private String customerName;
    private String accountId;
    private double balance;
    private double prevTransaction;

    // Constructor
    public BankAccount(String customerName, String accountId) {
        this.customerName = customerName;
        this.accountId = accountId;
        this.balance = 0.0;
        this.prevTransaction = 0.0;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            prevTransaction = amount;
            System.out.println("Amount deposited: $" + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                prevTransaction = -amount;
                System.out.println("Amount withdrawn: $" + amount);
            } else {
                System.out.println("Insufficient balance!");
            }
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    // Check balance method
    public double checkBalance() {
        return balance;
    }

    // View previous transaction
    public void viewPrevTransaction() {
        if (prevTransaction > 0) {
            System.out.println("Deposited: $" + prevTransaction);
        } else if (prevTransaction < 0) {
            System.out.println("Withdrawn: $" + Math.abs(prevTransaction));
        } else {
            System.out.println("No transactions yet.");
        }
    }

    // Display menu
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        char option;

        System.out.println("\nWelcome, " + customerName + "!");
        System.out.println("Your Account ID: " + accountId);
        System.out.println("\nChoose an option:");
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. View Previous Transaction");
        System.out.println("E. Exit");

        do {
            System.out.print("\nEnter an option: ");
            option = scanner.next().charAt(0);

            switch (Character.toUpperCase(option)) {
                case 'A':
                    System.out.println("Balance: $" + checkBalance());
                    break;

                case 'B':
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    break;

                case 'C':
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawAmount);
                    break;

                case 'D':
                    viewPrevTransaction();
                    break;

                case 'E':
                    System.out.println("Exiting... Thank you for banking with us!");
                    break;

                default:
                    System.out.println("Invalid option! Please try again.");
            }
        } while (Character.toUpperCase(option) != 'E');
        
    }
}


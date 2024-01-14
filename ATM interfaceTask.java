import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BankTerminal {
    private double balance;
    private BufferedReader reader;

    public BankTerminal(double initialBalance) {
        this.balance = initialBalance;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void run() {
        while (true) {
            displayMenu();

            try {
                int option = Integer.parseInt(reader.readLine());
                executeOption(option);
            } catch (IOException | NumberFormatException e) {
                System.out.println("Error processing your request. Please try again.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\nBank Terminal Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        System.out.print("Choose an option (1-4): ");
    }

    private void executeOption(int option) throws IOException {
        switch (option) {
            case 1:
                checkBalance();
                break;
            case 2:
                deposit();
                break;
            case 3:
                withdraw();
                break;
            case 4:
                System.out.println("Exiting Bank Terminal. Thank you!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please choose a valid option.");
        }
    }

    private void checkBalance() {
        System.out.println("Your current balance: $" + balance);
    }

    private void deposit() throws IOException {
        System.out.print("Enter deposit amount: $");
        double depositAmount = getValidAmountInput();
        balance += depositAmount;
        System.out.println("Deposit successful. Your new balance: $" + balance);
    }

    private void withdraw() throws IOException {
        System.out.print("Enter withdrawal amount: $");
        double withdrawAmount = getValidAmountInput();
        if (withdrawAmount <= balance) {
            balance -= withdrawAmount;
            System.out.println("Withdrawal successful. Your new balance: $" + balance);
        } else {
            System.out.println("Insufficient funds. Withdrawal canceled.");
        }
    }

    private double getValidAmountInput() throws IOException {
        while (true) {
            try {
                String input = reader.readLine();
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid numeric value.");
            }
        }
    }

    public static void main(String[] args) {
        // Create a BankTerminal instance with an initial balance
        BankTerminal bankTerminal = new BankTerminal(1000.0);

        // Run the BankTerminal
        bankTerminal.run();
    }
}

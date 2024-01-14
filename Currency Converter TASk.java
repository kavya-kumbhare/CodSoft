import java.util.Scanner;

public class CurrencyProcessor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        CurrencyProcessor currencyProcessor = new CurrencyProcessor();

     
        String baseCurrency = currencyProcessor.getUserInput("Enter the base currency code: ", scanner);
        String targetCurrency = currencyProcessor.getUserInput("Enter the target currency code: ", scanner);
        double amount = currencyProcessor.getValidAmount(scanner);

        double exchangeRate = currencyProcessor.getExchangeRate(baseCurrency, targetCurrency);

        // Perform currency conversion
        currencyProcessor.convertAndDisplay(baseCurrency, targetCurrency, amount, exchangeRate);

        scanner.close();
    }

    private String getUserInput(String prompt, Scanner scanner) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private double getValidAmount(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Enter the amount to convert: ");
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid numeric value.");
            }
        }
    }

    private double getExchangeRate(String baseCurrency, String targetCurrency) {
        
        // For now, return a sample value; replace this with the actual logic.
        return 1.25;
    }

    private void convertAndDisplay(String baseCurrency, String targetCurrency, double amount, double exchangeRate) {
        if (exchangeRate != -1) {
            double convertedAmount = amount * exchangeRate;
            System.out.printf("%.2f %s is equal to %.2f %s%n", amount, baseCurrency, convertedAmount, targetCurrency);
        } else {
            System.out.println("Sorry, failed to get the exchange rate for the specified currencies.");
        }
    }
}

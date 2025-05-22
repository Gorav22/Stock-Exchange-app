package StockExchangeApp.Main;

import StockExchangeApp.Services.StockExchangeService;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StockExchangeService stockExchangeService = new StockExchangeService();

        while (true) {
            System.out.println("\n=== Welcome to Terminal Stock Exchange App ===");
            System.out.println("1. Register User");
            System.out.println("2. View Stock Price");
            System.out.println("3. Buy Stock");
            System.out.println("4. Sell Stock");
            System.out.println("5. View Portfolio Summary");
            System.out.println("6. Add Money to Account");     // ✨ NEW
            System.out.println("7. Show Available Balance");  // ✨ NEW
            System.out.println("8. View Transaction History");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the leftover newline

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter initial balance: ");
                    double balance = scanner.nextDouble();
                    stockExchangeService.registerUser(username, balance);
                    break;

                case 2:
                    System.out.print("Enter stock symbol to view: ");
                    String symbol = scanner.nextLine();
                    double price = stockExchangeService.viewStockPrice(symbol);
                    System.out.println("Current price of " + symbol + ": $" + price);
                    break;

                case 3:
                    System.out.print("Enter username: ");
                    username = scanner.nextLine();
                    System.out.print("Enter stock symbol to buy: ");
                    symbol = scanner.nextLine();
                    System.out.print("Enter quantity to buy: ");
                    int buyQty = scanner.nextInt();
                    stockExchangeService.buyStock(username, symbol, buyQty);
                    break;

                case 4:
                    System.out.print("Enter username: ");
                    username = scanner.nextLine();
                    System.out.print("Enter stock symbol to sell: ");
                    symbol = scanner.nextLine();
                    System.out.print("Enter quantity to sell: ");
                    int sellQty = scanner.nextInt();
                    stockExchangeService.sellStock(username, symbol, sellQty);
                    break;

                case 5:
                    System.out.print("Enter username: ");
                    username = scanner.nextLine();
                    stockExchangeService.showPortfolioSummary(username);
                    break;

                case 6: // ✨ Add Money to Account
                    System.out.print("Enter username: ");
                    username = scanner.nextLine();
                    System.out.print("Enter amount to add: ");
                    double amount = scanner.nextDouble();
                    stockExchangeService.addMoneyToAccount(username, amount);
                    break;

                case 7: // ✨ Show Available Balance
                    System.out.print("Enter username: ");
                    username = scanner.nextLine();
                    stockExchangeService.showAvailableBalance(username);
                    break;

                case 8:
                    stockExchangeService.showTransactionHistory();
                    break;

                case 9:
                    System.out.println("Thank you for using Terminal Stock Exchange App!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again!");
            }
        }
    }
}

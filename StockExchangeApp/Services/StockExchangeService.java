package StockExchangeApp.Services;

import StockExchangeApp.Models.Stock;
import StockExchangeApp.Models.Transaction;
import StockExchangeApp.Models.User;
import StockExchangeApp.Utils.ApiUtils;
import java.util.HashMap;
import java.util.Map;

public class StockExchangeService {
    private Map<String, User> users = new HashMap<>();
    private Map<String, Stock> stocks = new HashMap<>();
    private TransactionService transactionService = new TransactionService();
    public void registerUser(String username, double initialBalance) {
        if (users.containsKey(username)) {
            System.out.println("Username already exists.");
            return;
        }
        users.put(username, new User(username, initialBalance));
        System.out.println("User " + username + " registered successfully!");
    }

    public double viewStockPrice(String stockSymbol) {
        Stock stock = stocks.get(stockSymbol);

        if (stock == null) {
            double price = ApiUtils.getStockPrice(stockSymbol);
            stock = new Stock(stockSymbol, stockSymbol, price, 1000);
            stocks.put(stockSymbol, stock);
        } else {
            double price = ApiUtils.getStockPrice(stockSymbol);
            stock.updatePrice(price);
        }

        stock.getPriceHistory().display();
        return stock.getCurrentPrice();
    }

    // Buy stock
    public void buyStock(String username, String stockSymbol, int quantity) {
        User user = users.get(username);
        if (user == null) {
            System.out.println("User not found!");
            return;
        }

        double pricePerShare = viewStockPrice(stockSymbol);
        double totalCost = pricePerShare * quantity;

        if (user.getBalance() < totalCost) {
            System.out.println("Insufficient balance.");
            return;
        }

        user.deductBalance(totalCost);
        user.addStock(stockSymbol, quantity);

        System.out.println(username + " bought " + quantity + " shares of " + stockSymbol + " for $" + totalCost);

        Transaction transaction = new Transaction(username, "BUY", stockSymbol, quantity, pricePerShare, totalCost);
        transactionService.recordTransaction(transaction);
    }

    public void sellStock(String username, String stockSymbol, int quantity) {
        User user = users.get(username);
        if (user == null) {
            System.out.println("User not found!");
            return;
        }

        if (!user.hasStock(stockSymbol, quantity)) {
            System.out.println("Not enough stock to sell.");
            return;
        }

        double pricePerShare = viewStockPrice(stockSymbol);
        double totalEarned = pricePerShare * quantity;

        user.addBalance(totalEarned);
        user.removeStock(stockSymbol, quantity);

        System.out.println(username + " sold " + quantity + " shares of " + stockSymbol + " for $" + totalEarned);

        Transaction transaction = new Transaction(username, "SELL", stockSymbol, quantity, pricePerShare, totalEarned);
        transactionService.recordTransaction(transaction);
    }

    public void showPortfolioSummary(String username) {
        User user = users.get(username);
        if (user == null) {
            System.out.println("User not found!");
            return;
        }

        System.out.println("\nPortfolio Summary for " + username);
        System.out.println("Available Balance: $" + user.getBalance());
        System.out.println("Owned Stocks:");
        user.displayStocks();
    }

    public void showTransactionHistory() {
        transactionService.showTransactionHistory();
    }

    public void addMoneyToAccount(String username, double amount) {
        User user = users.get(username);
        if (user == null) {
            System.out.println("User not found!");
            return;
        }

        if (amount <= 0) {
            System.out.println("Amount must be greater than 0.");
            return;
        }

        user.addBalance(amount);
        System.out.println("Successfully added $" + amount + " to " + username + "'s account.");
    }

    public void showAvailableBalance(String username) {
        User user = users.get(username);
        if (user == null) {
            System.out.println("User not found!");
            return;
        }

        System.out.println(username + "'s Available Balance: $" + user.getBalance());
    }
}

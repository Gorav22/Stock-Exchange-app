package StockExchangeApp.Models;

import java.util.HashMap;
import java.util.Map;

public class User {
    private String username;
    private double balance;
    private Map<String, Integer> ownedStocks;

    public User(String username, double balance) {
        this.username = username;
        this.balance = balance;
        this.ownedStocks = new HashMap<>();
    }

    public String getUsername() {
        return username;
    }

    public double getBalance() {
        return balance;
    }

    public void deductBalance(double amount) {
        this.balance -= amount;
    }

    public void addBalance(double amount) {
        this.balance += amount;
    }

    public void addStock(String stockSymbol, int quantity) {
        ownedStocks.put(stockSymbol, ownedStocks.getOrDefault(stockSymbol, 0) + quantity);
    }

    public void removeStock(String stockSymbol, int quantity) {
        if (ownedStocks.containsKey(stockSymbol)) {
            int currentQty = ownedStocks.get(stockSymbol);
            if (currentQty <= quantity) {
                ownedStocks.remove(stockSymbol); // sold all
            } else {
                ownedStocks.put(stockSymbol, currentQty - quantity);
            }
        }
    }

    public boolean hasStock(String stockSymbol, int quantity) {
        return ownedStocks.getOrDefault(stockSymbol, 0) >= quantity;
    }
    
    public void displayStocks() {
        if (ownedStocks.isEmpty()) {
            System.out.println("No stocks owned.");
            return;
        }
        for (Map.Entry<String, Integer> entry : ownedStocks.entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + entry.getValue() + " shares");
        }
    }
}

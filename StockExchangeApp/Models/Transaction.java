package StockExchangeApp.Models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private String username;
    private String type; // BUY or SELL
    private String stockSymbol;
    private int quantity;
    private double pricePerShare;
    private double totalAmount;
    private String dateTime;

    public Transaction(String username, String type, String stockSymbol, int quantity, double pricePerShare, double totalAmount) {
        this.username = username;
        this.type = type;
        this.stockSymbol = stockSymbol;
        this.quantity = quantity;
        this.pricePerShare = pricePerShare;
        this.totalAmount = totalAmount;
        this.dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public void display() {
        System.out.println(type + " | " + stockSymbol + " | Qty: " + quantity + " | Price: $" + pricePerShare + " | Total: $" + totalAmount + " | " + dateTime);
    }
}

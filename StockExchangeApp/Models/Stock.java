package StockExchangeApp.Models;

import StockExchangeApp.DataStructures.PriceHistoryQueue;

public class Stock {
    private String stockSymbol;
    private String stockName;
    private double currentPrice;
    private int availableQuantity;
    private PriceHistoryQueue priceHistory;

    public Stock(String stockSymbol, String stockName, double currentPrice, int availableQuantity) {
        this.stockSymbol = stockSymbol;
        this.stockName = stockName;
        this.currentPrice = currentPrice;
        this.availableQuantity = availableQuantity;
        this.priceHistory = new PriceHistoryQueue(5); 
        priceHistory.enqueue(currentPrice);
    }

    public void updatePrice(double newPrice) {
        this.currentPrice = newPrice;
        priceHistory.enqueue(newPrice);
    }

    public String getStockSymbol() { return stockSymbol; }
    public String getStockName() { return stockName; }
    public double getCurrentPrice() { return currentPrice; }
    public int getAvailableQuantity() { return availableQuantity; }
    public PriceHistoryQueue getPriceHistory() { return priceHistory; }

    public void setAvailableQuantity(int quantity) {
        this.availableQuantity = quantity;
    }
}

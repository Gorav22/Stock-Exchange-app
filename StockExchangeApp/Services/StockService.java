package StockExchangeApp.Services;

import StockExchangeApp.Models.Stock;
import java.util.HashMap;
import java.util.Map;

public class StockService {
    private Map<String, Stock> stocks = new HashMap<>();

    public void addStock(Stock stock) {
        stocks.put(stock.getStockSymbol(), stock);
    }

    public Stock getStock(String symbol) {
        return stocks.get(symbol);
    }


    public void showAllStocks() {
        for (Stock stock : stocks.values()) {
            System.out.println(stock.getStockSymbol() + " | " + stock.getStockName() + " | $" + stock.getCurrentPrice());
        }
    }
}

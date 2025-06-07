package StockTradingPLatform;

import java.util.HashMap;
import java.util.Map;

public class Portfolio {

    // key = stock symbol, value = quantity owned
    private Map<String, Integer> holdings;

    public Portfolio() {
        holdings = new HashMap<>();
    }

    // Add shares to portfolio
    public void addStock(String symbol, int quantity) {
        holdings.put(symbol, holdings.getOrDefault(symbol, 0) + quantity);
    }

    // Remove shares from portfolio
    public boolean removeStock(String symbol, int quantity) {
        if (holdings.containsKey(symbol)) {
            int currentQty = holdings.get(symbol);
            if (quantity <= currentQty) {
                holdings.put(symbol, currentQty - quantity);
                if (holdings.get(symbol) == 0) {
                    holdings.remove(symbol);
                }
                return true;
            }
        }
        return false;
    }

    public int getStockQuantity(String symbol) {
        return holdings.getOrDefault(symbol, 0);
    }

    public Map<String, Integer> getHoldings() {
        return holdings;
    }

    public void displayPortfolio() {
        System.out.println("📂 Your Portfolio:");
        if (holdings.isEmpty()) {
            System.out.println("You don't own any stocks yet.");
        } else {
            for (Map.Entry<String, Integer> entry : holdings.entrySet()) {
                System.out.printf("• %s - %d shares\n", entry.getKey(), entry.getValue());
            }
        }
    }
}


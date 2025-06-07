package StockTradingPLatform;

import java.time.LocalDateTime;

public class Transaction {
    private String stockSymbol;
    private int quantity;
    private double priceAtTransaction;
    private String type; // "BUY" or "SELL"
    private LocalDateTime dateTime;

    public Transaction(String stockSymbol, int quantity, double priceAtTransaction, String type) {
        this.stockSymbol = stockSymbol;
        this.quantity = quantity;
        this.priceAtTransaction = priceAtTransaction;
        this.type = type;
        this.dateTime = LocalDateTime.now();
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPriceAtTransaction() {
        return priceAtTransaction;
    }

    public String getType() {
        return type;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void displayTransaction() {
        System.out.printf("[%s] %s %d of %s at $%.2f\n",
                dateTime.toString(), type, quantity, stockSymbol, priceAtTransaction);
    }
}


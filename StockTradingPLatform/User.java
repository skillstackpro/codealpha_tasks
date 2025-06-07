package StockTradingPLatform;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private double balance;
    private Portfolio portfolio;
    private List<Transaction> transactionHistory;

    public User(String name, double initialBalance) {
        this.name = name;
        this.balance = initialBalance;
        this.portfolio = new Portfolio();
        this.transactionHistory = new ArrayList<>();
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    // Add or deduct balance
    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    // Add a transaction to history
    public void recordTransaction(Transaction transaction) {
        transactionHistory.add(transaction);
    }

    // Display transaction history
    public void displayTransactionHistory() {
        System.out.println("🧾 Transaction History:");
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (Transaction t : transactionHistory) {
                t.displayTransaction();
            }
        }
    }

    // Display user balance and portfolio
    public void displayUserInfo() {
        System.out.printf("\n👤 User: %s | 💰 Balance: $%.2f\n", name, balance);
        portfolio.displayPortfolio();
    }
}


package StockTradingPLatform;

import java.util.Random;

    public class Stock {
        private String symbol;
        private String companyName;
        private double currentPrice;

        public Stock(String symbol, String companyName, double currentPrice) {
            this.symbol = symbol;
            this.companyName = companyName;
            this.currentPrice = currentPrice;
        }

        // Getters
        public String getSymbol() {
            return symbol;
        }

        public String getCompanyName() {
            return companyName;
        }

        public double getCurrentPrice() {
            return currentPrice;
        }

        // Method to simulate random price update
        public void updatePrice() {
            Random random = new Random();
            double change = (random.nextDouble() * 10) - 5; // -5 to +5 range
            currentPrice = Math.max(1, currentPrice + change); // Avoid negative prices
        }

        // Display stock info
        public void displayStock() {
            System.out.printf("%s (%s): $%.2f\n", companyName, symbol, currentPrice);
        }
    }



package StockTradingPLatform;

import StockTradingPLatform.*;

public class TradeService {

    private MarketService marketService;

    public TradeService(MarketService marketService) {
        this.marketService = marketService;
    }

    // BUY STOCK
    public void buyStock(User user, String symbol, int quantity) {
        Stock stock = marketService.getStockBySymbol(symbol);

        if (stock == null) {
            System.out.println("❌ Stock not found.");
            return;
        }

        double totalPrice = stock.getCurrentPrice() * quantity;

        if (user.withdraw(totalPrice)) {
            user.getPortfolio().addStock(symbol, quantity);
            user.recordTransaction(new Transaction(symbol, quantity, stock.getCurrentPrice(), "BUY"));
            System.out.printf("✅ Bought %d shares of %s at $%.2f each.\n", quantity, symbol, stock.getCurrentPrice());
        } else {
            System.out.println("❌ Not enough balance to complete the purchase.");
        }
    }

    // SELL STOCK
    public void sellStock(User user, String symbol, int quantity) {
        int ownedQuantity = user.getPortfolio().getStockQuantity(symbol);

        if (ownedQuantity < quantity) {
            System.out.println("❌ You don't own enough shares to sell.");
            return;
        }

        Stock stock = marketService.getStockBySymbol(symbol);

        if (stock == null) {
            System.out.println("❌ Stock not found in market.");
            return;
        }

        double totalValue = stock.getCurrentPrice() * quantity;
        user.getPortfolio().removeStock(symbol, quantity);
        user.deposit(totalValue);
        user.recordTransaction(new Transaction(symbol, quantity, stock.getCurrentPrice(), "SELL"));

        System.out.printf("✅ Sold %d shares of %s at $%.2f each.\n", quantity, symbol, stock.getCurrentPrice());
    }
}


package StockTradingPLatform;

import StockTradingPLatform.Stock;
import java.util.ArrayList;
import java.util.List;

public class MarketService {

    private List<Stock> stockList;

    public MarketService() {
        stockList = new ArrayList<>();
        // Add some sample stocks
        stockList.add(new Stock("AAPL", "Apple Inc.", 150.00));
        stockList.add(new Stock("GOOGL", "Alphabet Inc.", 2800.00));
        stockList.add(new Stock("TSLA", "Tesla Inc.", 700.00));
        stockList.add(new Stock("AMZN", "Amazon Inc.", 3200.00));
    }

    public List<Stock> getAllStocks() {
        return stockList;
    }

    public Stock getStockBySymbol(String symbol) {
        for (Stock stock : stockList) {
            if (stock.getSymbol().equalsIgnoreCase(symbol)) {
                return stock;
            }
        }
        return null;
    }

    public void updateMarketPrices() {
        for (Stock stock : stockList) {
            stock.updatePrice();
        }
    }

    public void displayMarket() {
        System.out.println("📈 Current Market Stocks:");
        for (Stock stock : stockList) {
            stock.displayStock();
        }
    }
}


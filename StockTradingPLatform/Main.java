package StockTradingPLatform;

import StockTradingPLatform.User;
import StockTradingPLatform.MarketService;
import StockTradingPLatform.TradeService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 1. Setup Market and Services
        MarketService marketService = new MarketService();
        TradeService tradeService = new TradeService(marketService);

        // 2. Create User
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        User user = new User(name, 10000); // Starting with $10,000
        System.out.println("👤 Welcome " + name + "! Starting balance: $10,000\n");

        boolean running = true;
        while (running) {
            System.out.println("\n===== 📊 STOCK TRADING PLATFORM =====");
            System.out.println("1. View Market");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. View Transactions");
            System.out.println("6. Update Market Prices");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    marketService.displayMarket();
                    break;

                case 2:
                    System.out.print("Enter stock symbol to BUY: ");
                    String buySymbol = sc.nextLine().toUpperCase();
                    System.out.print("Enter quantity: ");
                    int buyQty = sc.nextInt();
                    tradeService.buyStock(user, buySymbol, buyQty);
                    break;

                case 3:
                    System.out.print("Enter stock symbol to SELL: ");
                    String sellSymbol = sc.nextLine().toUpperCase();
                    System.out.print("Enter quantity: ");
                    int sellQty = sc.nextInt();
                    tradeService.sellStock(user, sellSymbol, sellQty);
                    break;

                case 4:
                    user.displayUserInfo();
                    break;

                case 5:
                    user.displayTransactionHistory();
                    break;

                case 6:
                    marketService.updateMarketPrices();
                    break;

                case 0:
                    running = false;
                    break;

                default:
                    System.out.println("❌ Invalid choice.");
            }
        }

        System.out.println("\n👋 Exiting... Thanks for trading!");
        sc.close();
    }
}


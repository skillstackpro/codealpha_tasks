package HotelReservationSystem;


import HotelReservationSystem.User;
import HotelReservationSystem.HotelService;
import HotelReservationSystem.PaymentService;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HotelService hotelService = new HotelService();
        PaymentService paymentService = new PaymentService();
        Scanner scanner = new Scanner(System.in);

        hotelService.addSampleRooms();

        boolean running = true;

        System.out.println("🏨 Welcome to the Hotel Reservation System 🏨");

        while (running) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Search Rooms by Category");
            System.out.println("3. Make a Reservation");
            System.out.println("4. View All Bookings");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    hotelService.showAvailableRooms();
                    break;

                case 2:
                    System.out.print("Enter room category (Standard, Deluxe, Suite): ");
                    String category = scanner.nextLine();
                    hotelService.showRoomsByCategory(category);
                    break;

                case 3:
                    System.out.print("Your name: ");
                    String name = scanner.nextLine();

                    System.out.print("Your email: ");
                    String email = scanner.nextLine();

                    System.out.print("Your phone: ");
                    String phone = scanner.nextLine();

                    User user = new User(name, email, phone);

                    System.out.print("Enter room number to book: ");
                    int roomNumber = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter check-in date (YYYY-MM-DD): ");
                    LocalDate checkIn = LocalDate.parse(scanner.nextLine());

                    System.out.print("Enter check-out date (YYYY-MM-DD): ");
                    LocalDate checkOut = LocalDate.parse(scanner.nextLine());

                    boolean success = hotelService.makeReservation(user, roomNumber, checkIn, checkOut);

                    if (success) {
                        double totalAmount = (checkOut.toEpochDay() - checkIn.toEpochDay()) *
                                hotelService
                                        .getRoomByNumber(roomNumber)
                                        .getPricePerNight();

                        System.out.print("Enter payment method (Cash/Card): ");
                        String method = scanner.nextLine();

                        paymentService.processPayment(method, totalAmount);
                    }
                    break;

                case 4:
                    hotelService.showAllBookings();
                    break;

                case 5:
                    running = false;
                    System.out.println("👋 Thank you for using the system!");
                    break;

                default:
                    System.out.println("❌ Invalid option. Try again.");
            }
        }

        scanner.close();
    }
}





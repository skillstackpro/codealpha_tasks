import java.util.*;
import java.io.*;

public class HotelReservationSystem {
    private static ArrayList<Room> rooms = new ArrayList<>();
    private static ArrayList<Booking> bookings = new ArrayList<>();

    public static void main(String[] args) {
        try {
            rooms = FileStorage.loadRooms();
            bookings = FileStorage.loadBookings();
        } catch (Exception e) {
            System.out.println("Error loading data: " + e.getMessage());
        }

        if (rooms.isEmpty()) initializeRooms();

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Hotel Reservation System ---");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View All Bookings");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    viewAvailableRooms();
                    break;
                case 2:
                    bookRoom(scanner);
                    break;
                case 3:
                    cancelBooking(scanner);
                    break;
                case 4:
                    viewAllBookings();
                    break;
                case 0:
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid option!");
            }

        } while (choice != 0);

        try {
            FileStorage.saveRooms(rooms);
            FileStorage.saveBookings(bookings);
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    private static void initializeRooms() {
        for (int i = 1; i <= 3; i++) rooms.add(new Room(i, "Standard"));
        for (int i = 4; i <= 6; i++) rooms.add(new Room(i, "Deluxe"));
        for (int i = 7; i <= 9; i++) rooms.add(new Room(i, "Suite"));
    }

    private static void viewAvailableRooms() {
        System.out.println("\nAvailable Rooms:");
        for (Room room : rooms) {
            if (!room.isBooked()) {
                System.out.println(room);
            }
        }
    }

    private static void bookRoom(Scanner scanner) {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        viewAvailableRooms();
        System.out.print("Enter room number to book: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine();

        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && !room.isBooked()) {
                room.setBooked(true);
                Booking booking = new Booking(name, room);

                System.out.print("Pay now? (yes/no): ");
                String pay = scanner.nextLine();
                if (pay.equalsIgnoreCase("yes")) {
                    booking.pay();
                    System.out.println("Payment successful.");
                } else {
                    System.out.println("Booking made without payment.");
                }

                bookings.add(booking);
                System.out.println("Booking confirmed!");
                return;
            }
        }

        System.out.println("Invalid room number or room already booked.");
    }

    private static void cancelBooking(Scanner scanner) {
        System.out.print("Enter your name to cancel booking: ");
        String name = scanner.nextLine();

        Iterator<Booking> iterator = bookings.iterator();
        while (iterator.hasNext()) {
            Booking booking = iterator.next();
            if (booking.getCustomerName().equalsIgnoreCase(name)) {
                booking.getRoom().setBooked(false);
                iterator.remove();
                System.out.println("Booking cancelled.");
                return;
            }
        }

        System.out.println("No booking found for name: " + name);
    }

    private static void viewAllBookings() {
        System.out.println("\n--- All Bookings ---");
        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
        } else {
            for (Booking booking : bookings) {
                System.out.println(booking);
                System.out.println("--------------------");
            }
        }
    }
}


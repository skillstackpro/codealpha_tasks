package HotelReservationSystem;

import HotelReservationSystem.*;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HotelService {
    private List<Room> rooms;
    private List<Booking> bookings;

    public HotelService() {
        rooms = new ArrayList<>();
        bookings = new ArrayList<>();
    }

    // Add sample rooms
    public void addSampleRooms() {
        rooms.add(new Room(101, "Standard", 3000));
        rooms.add(new Room(102, "Deluxe", 5000));
        rooms.add(new Room(103, "Suite", 8000));
    }

    // Show all available rooms
    public void showAvailableRooms() {
        System.out.println("\nAvailable Rooms:");
        for (Room room : rooms) {
            if (room.isAvailable()) {
                room.displayRoomInfo();
            }
        }
    }

    // Search by category
    public void showRoomsByCategory(String category) {
        System.out.println("\nRooms in category: " + category);
        for (Room room : rooms) {
            if (room.getCategory().equalsIgnoreCase(category) && room.isAvailable()) {
                room.displayRoomInfo();
            }
        }
    }

    // Book a room
    public boolean makeReservation(User user, int roomNumber, LocalDate checkIn, LocalDate checkOut) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && room.isAvailable()) {
                Booking booking = new Booking(user, room, checkIn, checkOut);
                bookings.add(booking);
                room.setAvailable(false);
                System.out.println("✅ Booking successful!");
                booking.displayBookingInfo();
                return true;
            }
        }
        System.out.println("❌ Room not available or doesn't exist.");
        return false;
    }
    public Room getRoomByNumber(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }

    public void showAllBookings() {
        System.out.println("\nAll Bookings:");
        for (Booking b : bookings) {
            b.displayBookingInfo();
            System.out.println("-----------------------");
        }
    }
}


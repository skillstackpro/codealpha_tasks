package HotelReservationSystem;

import java.time.LocalDate;

public class Booking {
    private User user;
    private Room room;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private double totalAmount;

    public Booking(User user, Room room, LocalDate checkInDate, LocalDate checkOutDate) {
        this.user = user;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalAmount = calculateTotalAmount();
    }

    private double calculateTotalAmount() {
        long days = checkOutDate.toEpochDay() - checkInDate.toEpochDay();
        return room.getPricePerNight() * days;
    }

    public void displayBookingInfo() {
        System.out.println("Booking Details:");
        user.displayUserInfo();
        room.displayRoomInfo();
        System.out.println("Check-in: " + checkInDate +
                " | Check-out: " + checkOutDate +
                " | Total Amount: $" + totalAmount);
    }

    public Room getRoom() {
        return room;
    }
}


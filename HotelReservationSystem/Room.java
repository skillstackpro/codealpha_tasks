package HotelReservationSystem;

public class Room {
    private int roomNumber;
    private String category; // e.g., Standard, Deluxe, Suite
    private double pricePerNight;
    private boolean isAvailable;

    public Room(int roomNumber, String category, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.pricePerNight = pricePerNight;
        this.isAvailable = true; // default when added
    }

    // Getters
    public int getRoomNumber() {
        return roomNumber;
    }

    public String getCategory() {
        return category;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // Setters
    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public void displayRoomInfo() {
        System.out.println("Room " + roomNumber +
                " | Type: " + category +
                " | Price/Night: $" + pricePerNight +
                " | " + (isAvailable ? "Available" : "Booked"));
    }
}


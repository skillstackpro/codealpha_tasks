import java.io.Serializable;

public class Booking implements Serializable {
    private String customerName;
    private Room room;
    private boolean isPaid;

    public Booking(String customerName, Room room) {
        this.customerName = customerName;
        this.room = room;
        this.isPaid = false;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Room getRoom() {
        return room;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void pay() {
        isPaid = true;
    }

    @Override
    public String toString() {
        return "Customer: " + customerName +
                "\nRoom: " + room +
                "\nPayment: " + (isPaid ? "Paid" : "Not Paid");
    }
}


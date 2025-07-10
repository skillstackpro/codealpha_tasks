import java.io.*;
import java.util.ArrayList;

public class FileStorage {
    private static final String ROOM_FILE = "rooms.dat";
    private static final String BOOKING_FILE = "bookings.dat";

    public static void saveRooms(ArrayList<Room> rooms) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ROOM_FILE))) {
            oos.writeObject(rooms);
        }
    }

    public static ArrayList<Room> loadRooms() throws IOException, ClassNotFoundException {
        File file = new File(ROOM_FILE);
        if (!file.exists()) return new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ROOM_FILE))) {
            return (ArrayList<Room>) ois.readObject();
        }
    }

    public static void saveBookings(ArrayList<Booking> bookings) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(BOOKING_FILE))) {
            oos.writeObject(bookings);
        }
    }

    public static ArrayList<Booking> loadBookings() throws IOException, ClassNotFoundException {
        File file = new File(BOOKING_FILE);
        if (!file.exists()) return new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(BOOKING_FILE))) {
            return (ArrayList<Booking>) ois.readObject();
        }
    }
}


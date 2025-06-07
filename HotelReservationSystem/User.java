package HotelReservationSystem;

public class User {
    private String name;
    private String email;
    private String phone;

    public User(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void displayUserInfo() {
        System.out.println("Name: " + name + " | Email: " + email + " | Phone: " + phone);
    }
}


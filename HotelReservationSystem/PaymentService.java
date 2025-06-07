package HotelReservationSystem;

public class PaymentService {

    public boolean processPayment(String method, double amount) {
        // Simulate payment logic
        System.out.println("\n🧾 Payment Method: " + method);
        System.out.println("💵 Amount: Rs. " + amount);

        // In a real system, you'd integrate with a payment API here
        // We'll assume payment is always successful for this simulation
        System.out.println("✅ Payment successful. Thank you!");
        return true;
    }
}


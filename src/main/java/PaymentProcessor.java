import java.util.ArrayList;
import java.util.List;

class PaymentProcessor {
    private final List<Double> acceptedCash;
    private final boolean cardPaymentEnabled = true;

    public PaymentProcessor() {
        acceptedCash = new ArrayList<>();
        // Initialize with common denominations
        acceptedCash.add(0.10);
        acceptedCash.add(0.25);
        acceptedCash.add(1.00);
        acceptedCash.add(5.00);
        acceptedCash.add(10.00);
        acceptedCash.add(20.00);
        acceptedCash.add(50.00);
        acceptedCash.add(100.00);
    }

    public boolean validateCashPayment(double amount) {
        return acceptedCash.contains(amount);
    }

    public boolean processCardPayment(double price) {
        if (cardPaymentEnabled) {
            // Simulate card payment processing
            System.out.println("Processing card payment of $" + price);
            return true;
        }
        return false;
    }

    public double calculateChange(double price,
                                  double inserted) {
        return inserted - price;
    }
}

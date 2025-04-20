import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private final List<Product> products;
    private double balance;
    private double cashReserve;
    private Product selectedProduct;
    private final PaymentProcessor paymentProcessor;

    public VendingMachine() {
        this.products = new ArrayList<>();
        this.balance = 0;
        this.cashReserve = 100.00;
        this.paymentProcessor = new PaymentProcessor();
    }

    public void selectProduct(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                if (product.isAvailable()) {
                    selectedProduct = product;
                    System.out.println("Selected: " + product.getName());
                } else {
                    System.out.println("Product not available");
                }
                return;
            }
        }
        System.out.println("Product not found");
    }

    public void insertMoney(double amount) {
        if (paymentProcessor.validateCashPayment(amount)) {
            balance += amount;
            System.out.println("Inserted: $" + amount + ". Total: $" + balance);
        } else {
            System.out.println("Invalid cash amount");
        }
    }

    public Product dispenseProduct() {
        if (selectedProduct == null) {
            System.out.println("No product selected");
            return null;
        }

        if (balance >= selectedProduct.getPrice()) {
            if (selectedProduct.isAvailable()) {
                double change = paymentProcessor.calculateChange(selectedProduct.getPrice(), balance);
                if (cashReserve >= change) {
                    selectedProduct.setQuantity(selectedProduct.getQuantity() - 1);
                    cashReserve += selectedProduct.getPrice();
                    System.out.println("Dispensing: " + selectedProduct.getName());
                    return selectedProduct;
                } else {
                    System.out.println("Not enough change in machine");
                    return null;
                }
            } else {
                System.out.println("Product out of stock");
                return null;
            }
        } else {
            System.out.println("Insufficient funds");
            return null;
        }
    }

    public double returnChange() {
        if (selectedProduct != null && balance > 0) {
            double change = paymentProcessor.calculateChange(selectedProduct.getPrice(), balance);
            if (cashReserve >= change) {
                System.out.println("Returning change: $" + change);
                return change;
            }
        }
        return 0;
    }

    public String showProductInfo(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product.toString();
            }
        }
        return "Product not found";
    }

    public void resetSession() {
        selectedProduct = null;
        if (balance > 0) {
            returnChange();
        }
        balance = 0;
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getCashReserve() {
        return cashReserve;
    }

    public void setCashReserve(final double cashReserve) {
        this.cashReserve = cashReserve;
    }
}

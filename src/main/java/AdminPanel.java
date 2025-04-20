public class AdminPanel {
    private final String password;
    private final VendingMachine machine;

    public AdminPanel(String password,
                      VendingMachine machine) {
        this.password = password;
        this.machine = machine;
    }

    public boolean authenticate(String password) {
        return this.password.equals(password);
    }

    public void addProduct(Product newProduct) {
        for (Product existing : machine.getProducts()) {
            if (existing.getId() == newProduct.getId()) {
                System.out.println("Product with this ID already exists");
                return;
            }
        }
        machine.getProducts().add(newProduct);
        System.out.println("Added new product: " + newProduct.getName());
    }

    public void restock(int productId,
                        int amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount to restock");
            return;
        }

        for (Product product : machine.getProducts()) {
            if (product.getId() == productId) {
                product.setQuantity(product.getQuantity() + amount);
                System.out.println("Successfully restocked. New quantity for " +
                        product.getName() + ": " + product.getQuantity());
                return;
            }
        }
        System.out.println("Product with ID " + productId + " not found");
    }

    public void addCash(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount to add");
            return;
        }

        machine.setCashReserve(machine.getCashReserve() + amount);
        System.out.println("Added $" + amount + " to cash reserve. New reserve: $" + machine.getCashReserve());
    }

    public double collectCash() {
        double collected = machine.getCashReserve();
        machine.setCashReserve(0);
        System.out.println("Collected $" + collected + " from cash reserve");
        return collected;
    }

    public String viewStatistics() {
        StringBuilder stats = new StringBuilder();
        stats.append("=== Vending Machine Statistics ===\n");
        stats.append(String.format("Current Cash Reserve: $%.2f%n", machine.getCashReserve()));
        stats.append("Products Inventory:\n");

        for (Product product : machine.getProducts()) {
            stats.append(String.format("- %s (ID: %d): %d available, Price: $%.2f%n",
                    product.getName(), product.getId(), product.getQuantity(), product.getPrice()));
        }

        return stats.toString();
    }
}
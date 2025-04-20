public class Product {
    private final int id;
    private final String name;
    private final double price;
    private int quantity;

    public Product(int id,
                   String name,
                   double price,
                   int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public boolean isAvailable() {
        return quantity > 0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("""
                        ID: %d
                        Name: %s
                        Price: $%.2f
                        Quantity: %d
                        """,
                id, name, price, quantity);
    }
}

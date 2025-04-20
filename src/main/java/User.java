public class User {
    private final VendingMachine machine;

    public User(final VendingMachine machine) {
        this.machine = machine;
    }

    public void chooseProduct(int productId) {
        machine.selectProduct(productId);
    }

    public void pay(double amount) {
        machine.insertMoney(amount);
    }

    public Product takeProduct() {
        return machine.dispenseProduct();
    }

    public double takeChange() {
        return machine.returnChange();
    }
}

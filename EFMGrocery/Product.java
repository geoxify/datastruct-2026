package EFMGrocery;

public class Product {
    // Encapsulation: fields are private
    private String name;
    private double price;
    private double quantity;

    public Product(String name, double price, double quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // A helper method to get the total cost for this specific line item
    public double getLineTotal() {
        return this.price * this.quantity;
    }

    public String getName() {
        return name;
    }

    public void printReceiptLine() {
        System.out.printf("%-5.0f %-15s %10.2f %10.2f\n",
                this.quantity, this.name, this.price, this.getLineTotal());
    }
}
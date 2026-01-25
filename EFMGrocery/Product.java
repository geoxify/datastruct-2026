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

    public void printDetails() {
        System.out.println("--- Item Details ---");
        System.out.println("Product: " + this.name);
        System.out.println("Price: " + this.price);
        System.out.println("Quantity: " + this.quantity);
        System.out.println("Line Total: " + this.getLineTotal());
    }
}
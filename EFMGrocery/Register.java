package EFMGrocery;

public class Register {
    private double currentBill;

    private Product[] cart;
    private int itemCount;

    public Register() {
        this.currentBill = 0;
        this.cart = new Product[50];
        this.itemCount = 0;
    }

    // The register takes a product and adds its cost to the running total
    public void scanItem(Product p) {
        double itemCost = p.getLineTotal();
        this.currentBill += itemCost;

        if (itemCount < cart.length) {
            cart[itemCount] = p; // Store the object
            itemCount++; // Move to next slot
        } else {
            System.out.println("Cart is full!");
        }

        System.out.println("   > Added: " + p.getName() + " (P" + itemCost + ")");
        System.out.println("   > Running Total: " + this.currentBill);
    }

    public void printReceipt() {
        System.out.println("\n============================================");
        System.out.println("              OFFICIAL RECEIPT              ");
        System.out.println("============================================");
        // Table Headers
        System.out.printf("%-5s %-15s %10s %10s\n", "Qty", "Item", "Price", "Total");
        System.out.println("--------------------------------------------");

        // Loop through the array and print each line
        for (int i = 0; i < itemCount; i++) {
            cart[i].printReceiptLine();
        }

        System.out.println("--------------------------------------------");
        System.out.printf("GRAND TOTAL: %30.2f\n", this.currentBill);
        System.out.println("============================================");
    }

    public double getBillTotal() {
        return this.currentBill;
    }

    // Returns the change amount, or -1 if payment is insufficient
    public double processPayment(double payment) {
        if (payment >= this.currentBill) {
            return payment - this.currentBill;
        } else {
            return -1.0; // Indicate failure
        }
    }
}
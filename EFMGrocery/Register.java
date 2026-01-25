package EFMGrocery;

public class Register {
    private double currentBill;

    public Register() {
        this.currentBill = 0;
    }

    // The register takes a product and adds its cost to the running total
    public void scanItem(Product p) {
        double itemCost = p.getLineTotal();
        this.currentBill += itemCost;
        System.out.println("Added to bill: " + itemCost);
        System.out.println("Running Total: " + this.currentBill);
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
package Grocery;

public class Register {
    private double currentBill;
    private Product[] cart;
    private int itemCount;

    public Register() {
        this.currentBill = 0;
        this.cart = new Product[50];
        this.itemCount = 0;
    }

    public void scanItem(Product p) {
        double itemCost = p.getLineTotal();
        this.currentBill += itemCost;

        if (itemCount < cart.length) {
            cart[itemCount] = p;
            itemCount++;
        }

        // Using BLUE for a subtle confirmation
        System.out.println(GroceryMain.BLUE + "   > Added: " + p.getName() + " (P" + itemCost + ")" + GroceryMain.RESET);
        System.out.println(GroceryMain.BLUE + "   > Running Total: " + this.currentBill + GroceryMain.RESET);
    }

    public void printReceipt() {
        // CYAN Border
        System.out.println(GroceryMain.CYAN + "\n============================================" + GroceryMain.RESET);
        System.out.println(GroceryMain.CYAN + "              OFFICIAL RECEIPT              " + GroceryMain.RESET);
        System.out.println(GroceryMain.CYAN + "============================================" + GroceryMain.RESET);
        
        System.out.printf("%-5s %-15s %10s %10s\n", "Qty", "Item", "Price", "Total");
        System.out.println(GroceryMain.CYAN + "--------------------------------------------" + GroceryMain.RESET);

        for (int i = 0; i < itemCount; i++) {
            cart[i].printReceiptLine();
        }

        System.out.println(GroceryMain.CYAN + "--------------------------------------------" + GroceryMain.RESET);
        System.out.print("GRAND TOTAL:                   ");
        // GREEN Total
        System.out.println(GroceryMain.GREEN + String.format("%10.2f", this.currentBill) + GroceryMain.RESET);
        System.out.println(GroceryMain.CYAN + "============================================" + GroceryMain.RESET);
    }

    public double getBillTotal() {
        return this.currentBill;
    }

    public double processPayment(double payment) {
        if (payment >= this.currentBill) {
            return payment - this.currentBill;
        } else {
            return -1.0;
        }
    }
}
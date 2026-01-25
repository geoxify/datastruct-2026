package EFMGrocery;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String newCustomer;

        do {
            System.out.println("\n=== Welcome to EFM Grocery ===");
            
            // Create a NEW Register object for every customer.
            // This automatically ensures the bill starts at 0.0.
            Register currentRegister = new Register();
            
            String newProduct;

            // --- Product Loop ---
            do {
                System.out.print("Input Product Name: ");
                String productName = sc.nextLine();

                System.out.print("Enter Price: ");
                double price = sc.nextDouble();

                System.out.print("Enter Quantity: ");
                double quantity = sc.nextDouble();
                sc.nextLine(); // Consume the newline left by nextDouble()

                // 1. Create the Product object
                Product p = new Product(productName, price, quantity);

                // 2. Pass the Product to the Register
                currentRegister.scanItem(p);

                System.out.print("\nAdd another product? (Y/N): ");
                newProduct = sc.nextLine();

            } while (newProduct.equalsIgnoreCase("y"));

            // --- Payment Section ---
            double totalBill = currentRegister.getBillTotal();
            System.out.println("\nFinal Bill: " + totalBill);
            
            double payment;
            double change;
            
            // Loop until valid payment is received
            while (true) {
                System.out.print("Enter Payment Amount: ");
                payment = sc.nextDouble();
                sc.nextLine(); // Consume newline

                change = currentRegister.processPayment(payment);

                if (change != -1.0) {
                    System.out.println("Change: " + change);
                    currentRegister.printReceipt();
                    break; // Exit payment loop
                } else {
                    System.out.println("Error: Insufficient funds.");
                }
            }

            System.out.print("\nProcess next customer? (Y/N): ");
            newCustomer = sc.nextLine();

        } while (newCustomer.equalsIgnoreCase("y"));

        System.out.println("Program Terminating. Goodbye!");
        sc.close();
    }
}
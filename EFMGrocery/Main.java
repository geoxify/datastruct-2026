package EFMGrocery;

import java.util.Scanner;

public class Main {
    // --- COLOR PALETTE ---
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String newCustomer;

        // --- 2D ARRAY INVENTORY ---
        // { Name, Price }
        String[][] inventory = {
            {"Banana", "15.00"},
            {"Vitamilk", "30.00"},
            {"Rice", "15.00"},
            {"Egg", "10.00"},
            {"Biscuit", "10.00"}
        };

        do {
            System.out.println(CYAN + "\n=== Welcome to EFM Grocery ===" + RESET);
            Register currentRegister = new Register();
            String newProduct;

            do {
                // 1. Show Inventory Menu
                System.out.println("\n" + BLUE + "--- Available Items ---" + RESET);
                for(int i = 0; i < inventory.length; i++) {
                    System.out.printf("[%d] %-15s " + GREEN + "P%s" + RESET + "\n", 
                        (i+1), inventory[i][0], inventory[i][1]);
                }
                System.out.println("[0] Manual Input");
                
                // 2. Ask for Selection
                System.out.print(YELLOW + "Select Product ID: " + RESET);
                int choice = sc.nextInt();
                sc.nextLine(); // Consume newline

                String productName;
                double price;

                // 3. Determine if Manual or From Inventory
                if (choice > 0 && choice <= inventory.length) {
                    // Array index is choice - 1
                    productName = inventory[choice - 1][0];
                    price = Double.parseDouble(inventory[choice - 1][1]);
                    System.out.println(BLUE + "Selected: " + productName + RESET);
                } else {
                    // Manual Input Logic
                    System.out.print(YELLOW + "Input Product Name: " + RESET);
                    productName = sc.nextLine();
                    System.out.print(YELLOW + "Enter Price: " + RESET);
                    price = sc.nextDouble();
                    sc.nextLine(); 
                }

                // 4. Ask for Quantity
                System.out.print(YELLOW + "Enter Quantity: " + RESET);
                double quantity = sc.nextDouble();
                sc.nextLine(); 

                // 5. Add to Register
                Product p = new Product(productName, price, quantity);
                currentRegister.scanItem(p);

                System.out.print(YELLOW + "\nAdd another product? (Y/N): " + RESET);
                newProduct = sc.nextLine();

            } while (newProduct.equalsIgnoreCase("y"));

            // --- Payment Section ---
            double totalBill = currentRegister.getBillTotal();
            System.out.println("\nFinal Bill: " + GREEN + totalBill + RESET);
            
            while (true) {
                System.out.print(YELLOW + "Enter Payment Amount: " + RESET);
                double payment = sc.nextDouble();
                sc.nextLine();

                double change = currentRegister.processPayment(payment);

                if (change != -1.0) {
                    System.out.println(GREEN + "Change: " + change + RESET);
                    currentRegister.printReceipt();
                    break;
                } else {
                    double missing = totalBill - payment;
                    System.out.println(RED + "Error: Insufficient funds. You need P" + missing + " more." + RESET);
                }
            }

            System.out.print(YELLOW + "\nProcess next customer? (Y/N): " + RESET);
            newCustomer = sc.nextLine();

        } while (newCustomer.equalsIgnoreCase("y"));

        System.out.println(CYAN + "Program Terminating. Goodbye!" + RESET);
        sc.close();
    }
}
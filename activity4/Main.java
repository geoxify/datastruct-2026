package activity4;

import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Please input the following: ");
        System.out.print("Product ID: ");
        int iprodId = InputInt();
        sc.nextLine();

        System.out.print("Name: ");
        String strProdName = InputString();

        System.out.print("Description: ");
        String strProdDesc = InputString();

        System.out.print("Quantity: ");
        double dQty = InputDouble();

        System.out.print("Price: ");
        double dPrice = InputDouble();
        sc.nextLine();

        System.out.print("Discount: ");
        double discount = InputInt();

        display(iprodId, strProdName, dPrice, dQty, discount);
    }

    public static String InputString() {
        return sc.nextLine();
    }

    public static int InputInt() {
        return sc.nextInt();
    }

    public static double InputDouble() {
        return sc.nextDouble();
    }

    public static double getSubtotal(double dPrice, double dQty, double discount) {
        return (dPrice * dQty) - discount;
    }

    public static void display(int id, String name, double price, double quantity, double discount) {
        System.out.printf("""
                
                %d %s
                Priced at %.0f for %.0f pieces
                Discounted at %.0f
                Subtotal: %.0f
                """, id, name, price, quantity, discount, getSubtotal(price, quantity, discount));
    }

}

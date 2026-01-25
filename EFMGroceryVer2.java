import java.util.Scanner;

public class EFMGroceryVer2 {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        // Declare Key Variables
        String strProdName = "";
        String strAnotherP;

        String strCustomer = "";

        char cCustomer = ' ';
        char cAnotherP = ' ';

        double dQty = 0;
        double dBill;
        double dPrice = 0;

        double dTotal;
        double dPay;
        double dChange = 0;

        do {
            header();
            strProdName = getProductName(strProdName);

            dPrice = getProductPrice(dPrice);

            dQty = getQuantity(dQty);
            input.nextLine();

            System.out.println("Total: " + getTotal(dQty, dPrice));
            getBill(getTotal(dChange, dPrice), dChange);

        } while (cAnotherP == 'y');

        System.out.println("Bill: " + getBill(getTotal(dChange, dPrice), dChange));


    }

    public static void header() {
        System.out.printf("""
                === E F M ===
                G R O C E R Y
                ^^^^^^^^^^^^^
                """);
    }

    public static String getProductName(String product) {
        System.out.print("Input product name: ");
        return product = input.nextLine();
    }

    public static double getProductPrice(double price) {
        System.out.print("Input product price: ");
        return price = input.nextDouble();
    }

    public static double getQuantity(double quantity) {
        System.out.print("Quantity: ");
        return quantity = input.nextDouble();
    }

    public static double getTotal(double quantity, double price) {
        return quantity * price;
    }

    public static double getBill(double total, double change) {
        return total + change;
    }
}
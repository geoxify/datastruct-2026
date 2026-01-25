import java.util.Scanner;

public class EFM_Grocery {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String strProdName, strAnotherP;
        String strCustomer = "";
        char cCustomer = ' ', cAnotherP = ' ';
        double dQty, dBill, dPrice;
        double dTotal, dPay, dChange = 0;

        do {
            dBill = 0;
            do {
                System.out.print("\n=-=>EFM Grocery<=-=\n");
                System.out.print("Input product name: ");
                strProdName = input.nextLine();

                System.out.print("\nInput product price: ");
                dPrice = input.nextDouble();

                System.out.print("Quanity: ");
                dQty = input.nextDouble(); input.nextLine();

                dTotal = dQty * dPrice;
                System.out.println("Total: " + dTotal);
                dBill = dBill + dTotal;

                System.out.print("Another product Y/N? ");
                strAnotherP = input.nextLine();
                cAnotherP = strAnotherP.charAt(0);
            } while ((cAnotherP == 'y') || (cAnotherP == 'Y'));
            System.out.println("Bill: " + dBill);
            System.out.print("Payment: ");
            dPay = input.nextDouble();
            input.nextLine();
            if (dPay >= dBill) {
                dChange = dPay - dBill;
                System.out.println("Change: " + dChange);
                System.out.println("Thank you for shopping");

            } else {
                System.out.println("Money is not enough!");
            }
            System.out.println("Another customer Y/N? ");
            strCustomer = input.nextLine();
            cCustomer = strCustomer.charAt(0);

        } while ((cCustomer == 'y') || (cCustomer == 'Y'));
        System.out.println("Grocery program terminating");

    }
}
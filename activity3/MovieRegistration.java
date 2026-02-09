package activity3;
import java.util.Scanner;

public class MovieRegistration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1
        int rent = 0;
        int sales = 0;
        int comedy = 0;
        int Horror = 0;
        int Scifi = 0;
        int Drama = 0;
        int Cartoons = 0;
        int dvdtotal = 0;
        int vcdtotal = 0;
        int tapetotal = 0;

        // Step 2
        String answer;
        do {
            System.out.print("""
                    Registration
                    1. DVD
                    2. VCD
                    3. Tape\n""");
            System.out.print("Choice: ");
            int code = sc.nextInt();
            if (code == 1) {
                System.out.println("Type: DVD");
                dvdtotal = dvdtotal + 1;
            } else if (code == 2) {
                System.out.println("Type: VCD");
                vcdtotal = vcdtotal + 1;
            } else if (code == 3) {
                System.out.println("Type: Tape");
                tapetotal = tapetotal + 1;
            }
            sc.nextLine();

            // Step 10
            System.out.print("Input title: ");
            String title = sc.nextLine();

            System.out.print("""
                    1. Horror
                    2. Scifi
                    3. Drama
                    4. Comedy
                    5. Cartoons
                    """);
            System.out.print("Category: ");
            int category = sc.nextInt();
            if (category == 1) {
                Horror = Horror + 1;
            } else if (category == 2) {
                Scifi = Scifi + 1;
            } else if (category == 3) {
                Drama = Drama + 1;
            } else if (category == 4) {
                comedy = comedy + 1;
            } else if (category == 5) {
                Cartoons = Cartoons + 1;
            }

            // Step 22
            System.out.print("Minutes: ");
            int minutes = sc.nextInt();
            sc.nextLine();

            System.out.print("Setting: ");
            String setting = sc.nextLine();

            System.out.print("""
                    1. Rental
                    2. Sales
                    """);
            System.out.print("Transaction: ");
            int transactionType = sc.nextInt();
            if (transactionType == 1) {
                rent = rent + 1;
            } else if (transactionType == 2) {
                sales = sales + 1;
            }

            // Step 29
            System.out.print("Input price: ");
            int price = sc.nextInt();
            sc.nextLine();

            System.out.print("Register another<yes/no>? ");
            answer = sc.nextLine().toLowerCase();
        } while (answer.equals("yes"));

        System.out.printf("""
                Reports
                For rent: %d
                For Sale: %d
                VCD Total: %d
                DVD Total: %d
                Tape Total: %d
                Horror movies: %d
                Scifi movies: %d
                Drama movies: %d
                Comedy movies: %d
                Cartoons : %d""", rent, sales, vcdtotal, dvdtotal, tapetotal, Horror, Scifi, Drama, comedy, Cartoons);

    }
}

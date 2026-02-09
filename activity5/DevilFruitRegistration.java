package activity5;
import java.util.Scanner;

public class DevilFruitRegistration {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        String strRegister;

        do {
            System.out.println("\nWG: Fruit Registration");

            System.out.print("What is the name of your Devil Fruit?\n    > ");
            String strDevilFruitName = InputString();

            System.out.printf("\nWhat is %s's class?", strDevilFruitName);
            System.out.print("\n| 1: Paramecia | 2: Zoan | 3: Logia |\n    > ");
            int iClass = InputInt();
            InputString();

            System.out.printf("\nWhat is the ability of %s\n    > ", strDevilFruitName);
            String strAbility = InputString();

            System.out.printf("\nWhat is the %s's weakness?\n    > ", strDevilFruitName);
            String strWeakness = InputString();

            System.out.printf("\nIs the %s awakened?", strDevilFruitName);
            System.out.print("\n| t | f |\n    > ");
            String sAwakened = InputString();

            Print(strDevilFruitName, iClass, strAbility, strWeakness, sAwakened);

            System.out.print("\nWould you like to register another Devil Fruit? (y/n)\n    > ");
            strRegister = InputString();
    
        } while (strRegister.equalsIgnoreCase("y"));

        System.out.println("\nProgram Terminating...\n");

    }

    public static String InputString() {
        return sc.nextLine();
    }

    public static int InputInt() {
        return sc.nextInt();
    }



    public static void Print(String name, int fruitClass, String ability, String weakness, String awakened) {
        System.out.println("\nSuccessfully Registered!");

        String strawakenedValue = "Unawakened";
        if (awakened.equalsIgnoreCase("t")) {
            strawakenedValue = "Awakened";
        }

        String strClass = "";
        switch (fruitClass) {
            case 1:
                strClass = "Paramecia";
                break;
            case 2:
                strClass = "Zoan";
                break;
            case 3:
                strClass = "Logia";
                break;
        }

        System.out.printf("\n%s type\n%s %s Fruit", strClass, strawakenedValue, name);
        System.out.println("\nAbility: " + ability);
        System.out.println("Weakness: " + weakness);
    }
}
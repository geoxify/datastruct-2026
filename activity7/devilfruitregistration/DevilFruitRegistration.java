package activity7.devilfruitregistration;

import java.util.Scanner;

public class DevilFruitRegistration {
    public static Scanner sc = new Scanner(System.in);

    // --- COLOR PALETTE ---
    public static final String RESET = "\u001B[0m";
    public static final String CYAN = "\u001B[36m";
    public static final String YELLOW = "\u001B[33m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";
    public static final String BLUE_BOLD = "\033[1;34m";
    public static final String WHITE_BOLD = "\033[1;37m";

    public static void main(String[] args) {

        String strRegister;

        do {
            // Clear screen (optional)
            System.out.print("\033[H\033[2J");
            System.out.flush();

            printHeader();

            System.out.println(WHITE_BOLD + " Enter Fruit Details:" + RESET);
            System.out.print(YELLOW + " What is the name of your Devil Fruit?\n    > " + RESET);
            String strDevilFruitName = InputString();

            System.out.println("\n" + WHITE_BOLD + " Select Class for " + CYAN + strDevilFruitName + RESET + ":");
            System.out.println(CYAN + " [1] " + RESET + "Paramecia");
            System.out.println(CYAN + " [2] " + RESET + "Zoan");
            System.out.println(CYAN + " [3] " + RESET + "Logia");
            System.out.print(YELLOW + "    > " + RESET);
            int iClass = InputInt();
            InputString(); // Consume newline

            System.out.printf("\n" + YELLOW + " What is the ability of %s?\n    > " + RESET, strDevilFruitName);
            String strAbility = InputString();

            System.out.printf("\n" + YELLOW + " What is the %s's weakness?\n    > " + RESET, strDevilFruitName);
            String strWeakness = InputString();

            System.out.printf("\n" + YELLOW + " Is the %s awakened?\n" + RESET, strDevilFruitName);
            System.out.print(CYAN + " [t] " + RESET + "True (Yes) | " + CYAN + "[f] " + RESET + "False (No)\n" + YELLOW + "    > " + RESET);
            String sAwakened = InputString();

            Print(strDevilFruitName, iClass, strAbility, strWeakness, sAwakened);

            System.out.println(CYAN + "\n------------------------------------------------" + RESET);
            System.out.print(YELLOW + " Would you like to register another Devil Fruit? (y/n)\n    > " + RESET);
            strRegister = InputString();

        } while (strRegister.equalsIgnoreCase("y"));

        System.out.println(GREEN + "\n Exiting Devil Fruit Registration..." + RESET);
        // Do not close scanner here to keep Main Menu alive
    }

    public static String InputString() {
        return sc.nextLine();
    }

    public static int InputInt() {
        // Simple error handling could be added here, but keeping it simple as per original logic
        return sc.nextInt();
    }

    public static void printHeader() {
        System.out.println(BLUE_BOLD + "\n================================================" + RESET);
        System.out.println(BLUE_BOLD + "         WORLD GOVERNMENT: FRUIT REGISTRY       " + RESET);
        System.out.println(BLUE_BOLD + "================================================" + RESET);
    }

    public static void Print(String name, int fruitClass, String ability, String weakness, String awakened) {
        System.out.println(GREEN + "\n >>> Successfully Registered! <<<" + RESET);

        String strawakenedValue = RED + "Unawakened" + RESET;
        if (awakened.equalsIgnoreCase("t")) {
            strawakenedValue = BLUE_BOLD + "Awakened" + RESET;
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
            default:
                strClass = "Unknown";
                break;
        }

        System.out.println(CYAN + "------------------------------------------------" + RESET);
        System.out.printf(" %s Type\n", strClass);
        System.out.printf(" %s %s Fruit\n", strawakenedValue, WHITE_BOLD + name + RESET);
        System.out.println(CYAN + "------------------------------------------------" + RESET);
        System.out.println(" Ability : " + ability);
        System.out.println(" Weakness: " + weakness);
        System.out.println(CYAN + "================================================" + RESET);
    }
}
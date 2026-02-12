import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DFRWithTranscription { // DFR = Devil Fruit Registration
    
    public static Scanner sc = new Scanner(System.in);

    public static FileWriter fw;

    public static void main(String[] args) {

        try {

            fw = new FileWriter("DevilFruitSessionLog.txt", true);
            // I added true so that it will append to the file instead of overwriting it

            log("= = = TRANSCRIPTION BEGIN = = =");

            String strRegister;

            do {

                System.out.println("\nWG: Fruit Registration");
                log("\nWG: Fruit Registration\n");

                System.out.print("What is the name of your Devil Fruit?\n    > ");
                log("What is the name of your Devil Fruit?\n    > ");

                String strDevilFruitName = InputString();

                String classPrompt = String.format("\nWhat is %s's class?", strDevilFruitName);
                System.out.print(classPrompt);
                log(classPrompt);

                System.out.print("\n| 1: Paramecia | 2: Zoan | 3: Logia |\n    > ");
                log("\n| 1: Paramecia | 2: Zoan | 3: Logia |\n    > ");

                int iClass = InputInt();
                InputString();

                String abilityPrompt = String.format("\nWhat is the ability of %s\n    > ", strDevilFruitName);
                System.out.print(abilityPrompt);
                log(abilityPrompt);
                String strAbility = InputString();

                String weaknessPrompt = String.format("\nWhat is the %s's weakness?\n    > ", strDevilFruitName);
                System.out.print(weaknessPrompt);
                log(weaknessPrompt);
                String strWeakness = InputString();

                String awakenedPrompt = String.format("\nIs the %s awakened?", strDevilFruitName);
                System.out.print(awakenedPrompt);
                log(awakenedPrompt);

                System.out.print("\n| t | f |\n    > ");
                log("\n| t | f |\n    > ");
                String sAwakened = InputString();

                Print(strDevilFruitName, iClass, strAbility, strWeakness, sAwakened);

                System.out.print("\nWould you like to register another Devil Fruit? (y/n)\n    > ");
                log("\nWould you like to register another Devil Fruit? (y/n)\n    > ");
                strRegister = InputString();

            } while (strRegister.equalsIgnoreCase("y"));

            System.out.println("\nProgram Terminating...\n");
            log("\nProgram Terminating...\n");

            log("= = = TRANSCRIPTION END = = =\n\n");

            fw.close();

        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }

    }

    public static void log(String text) {
        try {
            if (fw != null) {
                fw.write(text);
            }
        } catch (IOException e) {
            System.out.println("IOException Error Occured!");
        }
    }

    public static String InputString() {
        String input = sc.nextLine();
        log(input + "\n");
        return input;
    }

    public static int InputInt() {
        int input = sc.nextInt();
        log(String.valueOf(input) + "\n");
        return input;
    }

    public static void Print(String name, int fruitClass, String ability, String weakness, String awakened) {
        System.out.println("\nSuccessfully Registered!");
        log("\nSuccessfully Registered!\n");

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

        String outputLine1 = String.format("\n%s type\n%s %s Fruit", strClass, strawakenedValue, name);
        System.out.println(outputLine1);
        log(outputLine1 + "\n");

        System.out.println("Ability: " + ability);
        log("Ability: " + ability + "\n");

        System.out.println("Weakness: " + weakness);
        log("Weakness: " + weakness + "\n");
    }
}
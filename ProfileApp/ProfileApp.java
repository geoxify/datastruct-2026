package ProfileApp;

import java.util.Scanner;

public class ProfileApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // LIMITATION: We must choose a max size. Let's say 50.
        Profile[] profiles = new Profile[50]; 
        
        // This variable tracks how many actual profiles we've stored
        int count = 0; 
        
        String continueChoice;

        do {
            // Safety check: Don't let the array overflow
            if (count >= profiles.length) {
                System.out.println("Database is full!");
                break;
            }

            System.out.println("\n--- Enter New Profile ---");
            
            System.out.print("Enter Name: ");
            String name = input.nextLine();

            System.out.print("Enter Age: ");
            int age = input.nextInt();
            input.nextLine(); // Consume the 'Enter' key

            System.out.print("Enter Birth Date: ");
            String birthDate = input.nextLine();

            // Create the object and put it in the specific slot 'count'
            profiles[count] = new Profile(name, age, birthDate);
            
            // IMPORTANT: Move the counter to the next empty slot
            count++; 

            System.out.print("Add another profile? (y/n): ");
            continueChoice = input.nextLine();

        } while (continueChoice.equalsIgnoreCase("y"));

        System.out.println("\n\n=== ALL PROFILES ===");
        
        // Loop ONLY up to 'count'. 
        // If we looped to profiles.length, we would crash on the empty null slots.
        for (int i = 0; i < count; i++) {
            profiles[i].printDetails();
        }
        
        System.out.println("---------------------------");
        System.out.println("Total Profiles: " + count);
    }
}
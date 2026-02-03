package Main;

import java.util.Scanner;

import Grocery.GroceryMain;
import MovieRegistration.MainMovieRegistration;
import OwnRegistration.DevilFruitRegistration;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to G.E.O.\n(Global Engineering Operations)\nWe've got it all for you!");

        boolean running = true;
        while (running) {
            System.out.println("""
                    What would you like to do today?
                    [1] G.E.O Grocery ShopperMart POS
                    [2] G.E.O Movie Rental Registration
                    [3] G.E.O Devil Fruit Registration
                    [4] Exit
                    """);
            System.out.print("Choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    GroceryMain.main(null);
                    break;
                case 2:
                    MainMovieRegistration.main(null);
                    break;
                case 3:
                    DevilFruitRegistration.main(null);
                    break;
                case 4:
                    System.out.println("Shutting down GEO systems...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        }

        sc.close();
    }
}

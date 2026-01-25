package ProfileApp;

import java.util.Scanner;

// 1. THE CLASS (Stays exactly the same)
class Profile {
    String name;
    int age;
    String birthDate;

    public Profile(String name, int age, String birthDate) {
        this.name = name;
        this.age = age;
        this.birthDate = birthDate;
    }

    public void printDetails() {
        System.out.println("---------------------------");
        System.out.println("Name:       " + name);
        System.out.println("Age:        " + age);
        System.out.println("Birth Date: " + birthDate);
    }
}
package view;

import java.util.Scanner;

public class Menu {
    private static Menu instance;
    private final Scanner scanner;

    public static Menu getInstance() {
        return instance == null ?
                new Menu() : instance;
    }

    private Menu() {
        scanner = new Scanner(System.in);
    }

    public int mainMenu() {
        System.out.println("------ MAIN MENU ------");
        System.out.println("1. Manage customer");
        System.out.println("2. Manage address");
        System.out.println("3. Manage product");
        System.out.println("4. Manage discount");
        System.out.println("5. Quit");
        System.out.print("Please choose function: ");
        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice > 5 || choice < 1) {
                System.out.println("Your choice is invalid!");
                return mainMenu();
            } else {
                return choice;
            }
        } else {
            scanner.nextLine();
            System.out.println("Your choice is invalid!");
            return mainMenu();
        }
    }

    public int addressMenu() {
        System.out.println("------ ADDRESS MENU ------");
        System.out.println("1. Add new address");
        System.out.println("2. Update address");
        System.out.println("3. Show all address");
        System.out.println("4. Delete address");
        System.out.println("5. Back");
        System.out.print("Please choose function: ");
        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice > 5 || choice < 1) {
                System.out.println("Your choice is invalid!");
                return addressMenu();
            } else {
                return choice;
            }
        } else {
            scanner.nextLine();
            System.out.println("Your choice is invalid!");
            return addressMenu();
        }
    }
}

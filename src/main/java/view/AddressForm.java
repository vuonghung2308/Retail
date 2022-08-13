package view;

import model.Address;

import java.util.Scanner;

public class AddressForm {
    private static AddressForm instance;
    private final Scanner scanner;

    private AddressForm() {
        scanner = new Scanner(System.in);
    }

    public Address getAddress() {
        Address address = new Address();
        System.out.print("Enter city: ");
        address.setCity(scanner.nextLine());
        System.out.print("Enter district: ");
        address.setDistrict(scanner.nextLine());
        System.out.print("Enter sub-district: ");
        address.setSubDistrict(scanner.nextLine());
        System.out.print("Enter postal code: ");
        address.setPostalCode(scanner.nextLine());
        address.setDeliveryFee(getDeliveryFee());
        return address;
    }

    private int getDeliveryFee() {
        do {
            System.out.print("Enter delivery fee: ");
            if (scanner.hasNextInt()) {
                int salary = scanner.nextInt();
                scanner.nextLine();
                if (salary < 0) {
                    System.out.println("The value must be positive");
                    return getDeliveryFee();
                } else {
                    return salary;
                }
            } else {
                scanner.nextLine();
                System.out.println("The value must be integer");
                return getDeliveryFee();
            }
        } while (true);
    }

    public static AddressForm getInstance() {
        return instance == null ?
                new AddressForm() : instance;
    }
}

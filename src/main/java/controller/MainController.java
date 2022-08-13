package controller;

import view.Menu;

public class MainController {
    private final Menu menu;
    private final CustomerController customerController;
    private final AddressController addressController;

    public MainController() {
        menu = Menu.getInstance();
        customerController = new CustomerController();
        addressController = new AddressController();
    }

    public void run() {
        int choice;
        do {
            choice = menu.mainMenu();
            switch (choice) {
                case 1:
                    customerController.run();
                    break;
                case 2:
                    addressController.run();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
            }
        } while (choice != 5);
    }
}

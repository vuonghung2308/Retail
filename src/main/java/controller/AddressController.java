package controller;

import service.AddressService;
import service.impl.AddressServiceImpl;
import view.Menu;

public class AddressController {
    private final Menu menu;
    private final AddressService service;

    public AddressController() {
        service = new AddressServiceImpl();
        menu = Menu.getInstance();
    }

    public void run() {
        int choice;
        do {
            choice = menu.addressMenu();
            switch (choice) {
                case 1:
                    service.add();
                    break;
                case 2:
                    service.update();
                    break;
                case 3:
                    service.show();
                    break;
                case 4:
                    service.delete();
                case 5:
                    break;
            }
        } while (choice != 5);
    }
}
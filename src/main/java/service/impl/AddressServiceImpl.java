package service.impl;

import dao.AddressDao;
import dao.impl.AddressDaoImpl;
import model.Address;
import service.AddressService;
import view.AddressForm;

import java.util.List;

public class AddressServiceImpl implements AddressService {

    private final AddressForm form;
    private final AddressDao dao;

    public AddressServiceImpl() {
        form = AddressForm.getInstance();
        dao = new AddressDaoImpl();
    }

    @Override
    public void add() {
        System.out.println("------ Add address ------");
        Address address = form.getAddress();
        int id = dao.save(address);
        if (id != -1) {
            System.out.println("Add address successfully.");
        } else System.out.println("Add address failed.");
    }

    @Override
    public void update() {

    }

    @Override
    public void show() {
        List<Address> addresses = dao.findAll();
        System.out.println("------ List address ------");
        if (addresses.isEmpty()) {
            System.out.println("List address is empty.");
        } else addresses.forEach(System.out::println);
    }

    @Override
    public void delete() {

    }
}

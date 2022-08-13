package dao;

import model.Address;

import java.util.List;

public interface AddressDao {
    Address findById(int id);

    List<Address> findAll();

    int save(Address address);
}

package dao;

import model.Customer;

import java.util.List;

public interface CustomerDao {
    List<Customer> findAll();

    int save(Customer customer);
}

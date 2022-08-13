package dao.impl;

import dao.CustomerDao;
import model.Customer;
import utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    private final DBUtil dbUtil;
    private final AddressDaoImpl addressDaoImpl;

    public CustomerDaoImpl() {
        dbUtil = DBUtil.getInstance();
        addressDaoImpl = new AddressDaoImpl();
    }

    public List<Customer> findAll() {
        Connection connection = dbUtil.getConnection();
        List<Customer> customers = new ArrayList<>();
        String query = "SELECT * FROM CUSTOMER";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getInt("CUSTOMER_ID"));
                customer.setEmail(resultSet.getString("EMAIL"));
                customer.setPhone(resultSet.getString("PHONE_NUMBER"));
                customer.setName(resultSet.getString("FULL_NAME"));
                int addressId = resultSet.getInt("ADDRESS_ID");
                customer.setAddress(addressDaoImpl.findById(addressId));
                customers.add(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customers;
    }

    public int save(Customer customer) {
        Connection connection = dbUtil.getConnection();
        String query = "INSERT INTO CUSTOMER(FULL_NAME, EMAIL, PHONE_NUMBER, ADDRESS_ID) VALUES(?, ?, ?, ?)";
        return -1;
    }
}

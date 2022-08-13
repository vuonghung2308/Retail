package dao.impl;

import dao.AddressDao;
import model.Address;
import utils.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressDaoImpl implements AddressDao {
    private final DBUtil dbUtil;

    public AddressDaoImpl() {
        dbUtil = DBUtil.getInstance();
    }

    public Address findById(int id) {
        Connection connection = dbUtil.getConnection();
        Address address = null;
        try {
            String query = "SELECT * FROM ADDRESS WHERE ADDRESS_ID=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                address = new Address();
                setAddressAttribute(resultSet, address);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return address;
    }

    @Override
    public List<Address> findAll() {
        Connection connection = dbUtil.getConnection();
        List<Address> addresses = new ArrayList<>();
        try {
            String query = "SELECT * FROM ADDRESS";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Address address = new Address();
                setAddressAttribute(resultSet, address);
                addresses.add(address);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return addresses;
    }

    public int save(Address address) {
        Connection connection = dbUtil.getConnection();
        String query = "INSERT INTO ADDRESS(CITY, DISTRICT, SUB_DISTRICT," +
                " POSTAL_CODE, DELIVERY_FEE) VALUES(?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(
                    query, Statement.RETURN_GENERATED_KEYS
            );
            statement.setString(1, address.getCity());
            statement.setString(2, address.getDistrict());
            statement.setString(3, address.getSubDistrict());
            statement.setString(4, address.getPostalCode());
            statement.setInt(5, address.getDeliveryFee());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            } else {
                return -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    private void setAddressAttribute(ResultSet resultSet, Address address) throws SQLException {
        address.setId(resultSet.getInt("ADDRESS_ID"));
        address.setCity(resultSet.getString("CITY"));
        address.setDistrict(resultSet.getString("DISTRICT"));
        address.setSubDistrict(resultSet.getString("SUB_DISTRICT"));
        address.setPostalCode(resultSet.getString("POSTAL_CODE"));
        address.setDeliveryFee(resultSet.getInt("DELIVERY_FEE"));
    }
}

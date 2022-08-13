package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    private static DBUtil instance;
    String URL = "jdbc:mysql://127.0.0.1:3306/retail";
    String USERNAME = "root";
    String PASSWORD = "123456";

    public static DBUtil getInstance() {
        return instance = instance != null
                ? instance : new DBUtil();
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    URL, USERNAME, PASSWORD
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

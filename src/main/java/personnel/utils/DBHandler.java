package personnel.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHandler {

    private static final String URL = "jdbc:mysql://localhost:3306/personnel";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    private static DBHandler instance;

    private DBHandler() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static DBHandler getInstance() {
        if (instance == null) {
            synchronized (DBHandler.class) {
                if (instance == null) {
                    instance = new DBHandler();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Failed to connect to DB");
            e.printStackTrace();
            return null;
        }
    }
}

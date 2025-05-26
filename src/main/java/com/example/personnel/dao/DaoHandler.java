package com.example.personnel.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoHandler {

    private static final String URL = "jdbc:mysql://localhost:3306/personnel";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";


    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            System.err.println("Failed");
            e.printStackTrace();
            return null;
        }
    }

}
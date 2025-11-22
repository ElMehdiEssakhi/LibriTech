package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
    private static DBconnection instance;
    private Connection connection;

    private final String URL = "jdbc:mysql://localhost:3306/LIBRITECH";
    private final String USER = "root";
    private final String PASSWORD = "root";

    private DBconnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Connected to database");
        } catch (SQLException e) {
            System.err.println("❌ Database connection failed: " + e.getMessage());
        }
    }
    public static DBconnection getInstance() {
        if (instance == null) {
            instance = new DBconnection();
        }
        return instance;
    }
    public Connection getConnection() {
        return connection;
    }
}

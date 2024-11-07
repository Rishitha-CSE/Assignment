package com.klef.ep.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    static Connection con = null;
    
    public static Connection getConnection() {
        try {
            // Load PostgreSQL driver
            Class.forName("org.postgresql.Driver");
            System.out.println("PostgreSQL Driver Loaded");

            // Establish connection to PostgreSQL database
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/usermanagement", "postgres", "Rishitha@2004");
            System.out.println("PostgreSQL Connection Established");

        } catch (Exception e) {
            System.out.println("Database Connection Error: " + e);
        }
        return con;
    }
}

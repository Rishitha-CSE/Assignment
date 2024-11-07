package com.klef.ep.dao;

import java.sql.*;

public class AdminDAOOperations {

    // Check login credentials
    public boolean checkLogin(String uname, String pwd) {
        boolean flag = false;
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ? AND role = 'Admin'");
            ps.setString(1, uname);
            ps.setString(2, pwd);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                flag = true;
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return flag;
    }

    // Add new software
    public int addSoftware(String name, String description, String accessLevels) {
        int n = 0;
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO software (name, description, access_levels) VALUES (?, ?, ?)");
            ps.setString(1, name);
            ps.setString(2, description);
            ps.setString(3, accessLevels);

            n = ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return n;
    }
}

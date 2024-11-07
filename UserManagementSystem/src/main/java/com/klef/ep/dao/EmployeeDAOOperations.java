package com.klef.ep.dao;

import java.sql.*;

public class EmployeeDAOOperations {

    // Insert a new employee (used during sign-up)
    public int insertEmployee(Employee emp) {
        int n = 0;
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement psmt = conn.prepareStatement("INSERT INTO users (username, password, role, contactno) VALUES (?, ?, 'Employee', ?)");

            psmt.setString(1, emp.getUsername());
            psmt.setString(2, emp.getPassword());
            psmt.setString(3, emp.getContactNo());

            n = psmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return n;
    }

    // Check login credentials
    public boolean checkLogin(String uname, String pwd) {
        boolean flag = false;
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ? AND role = 'Employee'");
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
}

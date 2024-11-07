package com.klef.ep.dao;

import java.sql.*;

public class ManagerDAOOperations {

    // Check login credentials
    public boolean checkLogin(String uname, String pwd) {
        boolean flag = false;
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ? AND role = 'Manager'");
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

    // Approve or reject access request
    public int updateRequestStatus(int requestId, String status) {
        int n = 0;
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("UPDATE requests SET status = ? WHERE id = ?");
            ps.setString(1, status);
            ps.setInt(2, requestId);

            n = ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return n;
    }
}

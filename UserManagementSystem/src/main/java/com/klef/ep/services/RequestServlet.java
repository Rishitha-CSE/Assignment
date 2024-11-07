package com.klef.ep.services;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import com.klef.ep.dao.DBConnection;

import java.sql.*;

public class RequestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        int softwareId = Integer.parseInt(request.getParameter("softwareId"));
        String accessType = request.getParameter("accessType");
        String reason = request.getParameter("reason");

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO requests (user_id, software_id, access_type, reason, status) VALUES (?, ?, ?, ?, 'Pending')");
            ps.setInt(1, userId);
            ps.setInt(2, softwareId);
            ps.setString(3, accessType);
            ps.setString(4, reason);

            int result = ps.executeUpdate();
            conn.close();

            if (result > 0) {
                response.getWriter().println("Request submitted successfully.");
            } else {
                response.getWriter().println("Failed to submit request.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

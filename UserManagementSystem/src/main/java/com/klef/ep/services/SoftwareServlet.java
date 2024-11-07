package com.klef.ep.services;

import com.klef.ep.dao.AdminDAOOperations;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class SoftwareServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String accessLevels = request.getParameter("accessLevels");

        AdminDAOOperations adminDAO = new AdminDAOOperations();
        int result = adminDAO.addSoftware(name, description, accessLevels);

        if (result > 0) {
            response.getWriter().println("Software added successfully.");
        } else {
            response.getWriter().println("Failed to add software.");
        }
    }
}

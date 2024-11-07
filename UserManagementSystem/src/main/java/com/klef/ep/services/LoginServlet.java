package com.klef.ep.services;

import com.klef.ep.dao.EmployeeDAOOperations;
import com.klef.ep.dao.ManagerDAOOperations;
import com.klef.ep.dao.AdminDAOOperations;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        // Check login for each role
        EmployeeDAOOperations empDAO = new EmployeeDAOOperations();
        ManagerDAOOperations mgrDAO = new ManagerDAOOperations();
        AdminDAOOperations adminDAO = new AdminDAOOperations();

        if (empDAO.checkLogin(username, password)) {
            response.sendRedirect("requestAccess.jsp");  // Redirect to Employee page
        } else if (mgrDAO.checkLogin(username, password)) {
            response.sendRedirect("pendingRequests.jsp");  // Redirect to Manager page
        } else if (adminDAO.checkLogin(username, password)) {
            response.sendRedirect("createSoftware.jsp");  // Redirect to Admin page
        } else {
            response.getWriter().println("Invalid login credentials");
        }
    }
}

package com.klef.ep.services;

import com.klef.ep.dao.Employee;
import com.klef.ep.dao.EmployeeDAOOperations;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class SignUpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String contactNo = request.getParameter("contactNo");

        Employee employee = new Employee();
        employee.setUsername(username);
        employee.setPassword(password);
        employee.setContactNo(contactNo);

        EmployeeDAOOperations empDAO = new EmployeeDAOOperations();
        int result = empDAO.insertEmployee(employee);

        if (result > 0) {
            response.sendRedirect("login.jsp");  // Redirect to Login page upon successful registration
        } else {
            response.getWriter().println("Registration failed, please try again.");
        }
    }
}

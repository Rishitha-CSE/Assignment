package com.klef.ep.services;

import com.klef.ep.dao.ManagerDAOOperations;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ApprovalServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int requestId = Integer.parseInt(request.getParameter("requestId"));
        String status = request.getParameter("status"); // "Approved" or "Rejected"

        ManagerDAOOperations mgrDAO = new ManagerDAOOperations();
        int result = mgrDAO.updateRequestStatus(requestId, status);

        if (result > 0) {
            response.getWriter().println("Request " + status.toLowerCase() + " successfully.");
        } else {
            response.getWriter().println("Failed to update request status.");
        }
    }
}

<!DOCTYPE html>
<html>
<head><title>Pending Requests</title></head>
<body>
    <h2>Pending Access Requests</h2>
    <form action="ApprovalServlet" method="post">
        <!-- Example Request Row -->
        <input type="hidden" name="requestId" value="REQUEST_ID">
        <p>Employee: EMPLOYEE_NAME, Software: SOFTWARE_NAME, Access Type: ACCESS_TYPE</p>
        <button type="submit" name="status" value="Approved">Approve</button>
        <button type="submit" name="status" value="Rejected">Reject</button>
    </form>
</body>
</html>

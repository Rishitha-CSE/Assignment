<!DOCTYPE html>
<html>
<head><title>Request Access</title></head>
<body>
    <form action="RequestServlet" method="post">
        <label>Software ID:</label><input type="text" name="softwareId" required><br>
        <label>Access Type:</label><select name="accessType">
            <option value="Read">Read</option>
            <option value="Write">Write</option>
            <option value="Admin">Admin</option>
        </select><br>
        <label>Reason for Request:</label><textarea name="reason"></textarea><br>
        <input type="submit" value="Request Access">
    </form>
</body>
</html>

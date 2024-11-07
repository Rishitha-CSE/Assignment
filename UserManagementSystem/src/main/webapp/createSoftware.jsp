<!DOCTYPE html>
<html>
<head><title>Create Software</title></head>
<body>
    <form action="SoftwareServlet" method="post">
        <label>Software Name:</label><input type="text" name="name" required><br>
        <label>Description:</label><textarea name="description"></textarea><br>
        <label>Access Levels:</label><input type="text" name="accessLevels" placeholder="Read, Write, Admin" required><br>
        <input type="submit" value="Create Software">
    </form>
</body>
</html>

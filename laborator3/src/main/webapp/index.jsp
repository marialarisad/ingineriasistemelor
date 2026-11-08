<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lab 3</title>
</head>
<body>
    <br><br>
    <a href="CounterServlet?inc=1">CounterServlet GET</a>
    <br><br>
    <form action="CounterServlet" method="POST">
        <br>inc: <input type="text" name="inc" value="1">
        <br>dec: <input type="text" name="dec" value="1">
        <br><br>
        <input type="submit" value="CounterServlet POST">
    </form>
</body>
</html>
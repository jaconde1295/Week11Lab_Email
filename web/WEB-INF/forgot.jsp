<%-- 
    Document   : reset
    Created on : Apr 8, 2021, 3:07:22 PM
    Author     : 631503
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Notes</title>
    </head>
    <body>
        <h1>Forgot Password</h1>
        <p>Please enter your email address to retrieve your password.</p>
        <form action="forgot" method="post">
            Email Address: <input type="text" name="email" value="${email}"><br>
            <input type="submit" value="Submit">
        </form>
        ${message}
    </body>
</html>

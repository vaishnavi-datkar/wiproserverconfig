<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Successful</title>
</head>
<body>

    <h2>User Registered Successfully!</h2>

    <p><strong>Username:</strong> ${user.username}</p>
    <p><strong>Email:</strong> ${user.userEmail}</p>
    <p><strong>Phone:</strong> ${user.userPhone}</p>

</body>
</html>

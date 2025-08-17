<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>User Registration</title>
</head>
<body>
<h2>Register User</h2>
<form:form method="POST" action="submitUser" modelAttribute="user">
    Username: <form:input path="username"/><br><br>
    Email: <form:input path="userEmail"/><br><br>
    Phone: <form:input path="userPhone"/><br><br>
    <input type="submit" value="Register"/>
</form:form>
</body>
</html>

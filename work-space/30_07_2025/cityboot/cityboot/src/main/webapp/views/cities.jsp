<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cities in India</title>
</head>
<body>
    <h2>List of Cities in India</h2>
    <ul>
        <c:forEach var="city" items="${cities}">
            <li>${city.name}</li>
        </c:forEach>
    </ul>
</body>
</html>

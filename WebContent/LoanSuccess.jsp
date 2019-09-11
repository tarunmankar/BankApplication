<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Loan Apply</title>
</head>
<body>
<%
session=request.getSession();
out.println("Dear "+session.getAttribute("name")+", Thank you for your interest in loan. Our excutive will contact to you on your email "+session.getAttribute("email"));
%>
</body>
</html>
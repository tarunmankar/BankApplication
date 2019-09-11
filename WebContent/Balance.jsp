<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Check Balance Page</title>
</head>
<body>
<%
session=request.getSession();
out.println("Dear "+session.getAttribute("name")+", Your Balance is "+session.getAttribute("accno"));
%>
</body>
</html>
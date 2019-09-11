<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
session=request.getSession();
out.println("You Have transfered ");
out.println(session.getAttribute("al2"));
out.println("Rs to account number:");
out.println(session.getAttribute("al1"));
%>
</body>
</html>
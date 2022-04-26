<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
 <%
 	int total = (Integer)request.getAttribute("count");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Count</title>
</head>
<body>
	<h1 style="color:red">
		Count: <%= total %>
	</h1>
</body>
</html>
<%@page import="com.te.dtolayer.EmployeeDetails" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
    String message=(String)request.getAttribute("msg");
    EmployeeDetails details = (EmployeeDetails)request.getAttribute("savedEmpDetails");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Details </title>
</head>
<body>
<%=message %> Below details are here....!!!!!<br>
Your Generated Employee Id is : <%=details.getEmpId() %><br>
<%=details.getEmpName() %><br>
<%=details.getEmailAddress() %><br>
<%=details.getMobileNumber() %>
</body>
</html>
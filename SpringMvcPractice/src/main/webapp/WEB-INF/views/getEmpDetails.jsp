<%@page import="com.te.dtolayer.EmployeeDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
     EmployeeDetails employeeDetails = (EmployeeDetails)request.getAttribute("empFromDb");
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Detailss.....</title>
</head>
<body>
<b>Employee ID</b>            : <%=employeeDetails.getEmpId() %><br>
<b>Employee Name  </b>   : <%=employeeDetails.getEmpName() %><br>
<b>Email Address   </b>      : <%=employeeDetails.getEmailAddress() %><br>
<b>Mobile Number    </b>  : <%=employeeDetails.getMobileNumber()%><br>
<b>Password   </b>              : <%=employeeDetails.getPassword()%>


</body>
</html>
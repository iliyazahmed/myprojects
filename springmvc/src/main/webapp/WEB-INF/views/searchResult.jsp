<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@page import ="com.te.dto.UserDetails" %>  
  
  
  
    <% /* int uid = (Integer) request.getAttribute("userId");
	String uname = (String) request.getAttribute("name");
	String ukey = (String) request.getAttribute("secretKey"); */
	
	
	UserDetails ud =(UserDetails)request.getAttribute("userData");
	
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>
 <h3> Good Evening <%=ud.getEmpName()%>, Below are the details you have entered!!!</h3>
<em >
            UserId                = <%=ud.getEmpId()%> <br>
            UserName         = <%=ud.getEmpName()%><br> 
            User Password  = <%=ud.getPassKey() %> <br>
</em>
</body>
</html>
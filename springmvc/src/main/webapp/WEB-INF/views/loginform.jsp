<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
        <fieldset>
			<legend>Login Form</legend>
			<form action="./login4" method="post">
				<table>
					<tr>
						<td>Employee ID</td>
						<td>:</td>
						<td><input  type="number" name="empId" required="required"> </td>
					</tr>
					<tr>
						<td>Employee Name</td>
						<td>:</td>
						<td><input  type="text" name="empName" required="required"> </td>
					</tr>
					<tr>
						<td>Password</td>
						<td>:</td>
						<td><input  type="Password" name="passKey" required="required"> </td>
					</tr>
					<tr>
						<td><input type="submit" name="Submit"/></td>
					</tr>						
				</table>
			</form>
	</fieldset>


</body>
</html>
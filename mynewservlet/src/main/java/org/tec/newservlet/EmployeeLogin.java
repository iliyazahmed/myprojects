package org.tec.newservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmployeeLogin")
public class EmployeeLogin extends HttpServlet{
	
	String url = "jdbc:mysql://localhost:3306/hyd_batch?user=root&password=12345";
	String query = "select * from trainess where traineeId=? and traineeName=?";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String empId = req.getParameter("id");
		int eId = Integer.parseInt(empId);
		String eName =req.getParameter("na");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, eId);
			preparedStatement.setString(2, eName);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			PrintWriter printWriter = resp.getWriter();
			
			if(resultSet.next())
			{
				String userName = resultSet.getString("traineeName");
				String tCity = resultSet.getString("traineeCity");
				String age = resultSet.getString("traineeAge");
				int tAge = Integer.parseInt(age);
				
				printWriter.println("Welcome "+userName+ "!!!!");
				printWriter.println("Trainee City  is "+tCity);
				printWriter.println("Trainee Age is : "+tAge);
		    }
			else
		      printWriter.println("Invalid Credentials..!!!");
		} 
		catch (Exception e) {
			
			e.printStackTrace();
		}
	}
       
	
}

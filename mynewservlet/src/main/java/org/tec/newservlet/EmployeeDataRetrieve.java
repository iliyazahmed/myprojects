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

@WebServlet("/EmployeeDataRetrieve")
public class EmployeeDataRetrieve extends HttpServlet{
	
	
	String url = "jdbc:mysql://localhost:3306/hyd_batch?user=root&password=12345";
	String query ="select * from trainess where traineeId=?";
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String traineeId = req.getParameter("emp");
		int id=Integer.parseInt(traineeId);
		
		PrintWriter pw = resp.getWriter();
		pw.println("Trainee Id  is "+traineeId);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
	 	    
	 	    PreparedStatement preparedStatement = connection.prepareStatement(query);
	 	    preparedStatement.setInt(1,id);
	 	    
	 	    ResultSet resultSet = preparedStatement.executeQuery();
	 	    
	 	   while(resultSet.next())
	 	    {
	 	    	String userName = resultSet.getString("traineeName");
	 	    	String traineeGender = resultSet.getString("traineeGender");
	 	    	
	 	    	
	 	    	pw.println("Welcome "+userName+" !!!!!!");
	 	    	pw.println("Trainer Gender  is "+traineeGender);
	 	    }
	 	    
	 	    
	 	  connection.close();
		} 
		catch (Exception e) {
		
			e.printStackTrace();
		}
		
		
	}
	
	
	

}

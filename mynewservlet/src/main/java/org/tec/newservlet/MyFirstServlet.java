package org.tec.newservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(description = "My First Servlet" ,urlPatterns = { "/MyFirstServlet"})

public class MyFirstServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.setContentType("text/html");
       PrintWriter pw = response.getWriter();
       pw.println("Hello i am from GET");
       System.out.println("Hello i am frm GET");
	}

//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		  response.setContentType("text/html");
//	       PrintWriter pw = response.getWriter();
//	       pw.println("Hello i am from POST");
//	       System.out.println("Hello i am frm POST");
//	}
	
        
}

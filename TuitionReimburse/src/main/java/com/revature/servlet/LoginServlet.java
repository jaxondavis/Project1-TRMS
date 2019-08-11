package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.daoimpl.EmployeeDaoImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	//Creates request to access login page.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("In doGet of LoginServlet");
		//Use RequestDispatcher to present login page.
		//response.setContentType("text/html");
		RequestDispatcher rd = request.getRequestDispatcher("login.html");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//request.getRequestDispatcher("index.html").include(request, response); //Do we need this?
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		//Check against DaoImpl here. User/PW combo. Verification in EmployeeDaoImpl.
		int employeeID = 0;
		try {
			employeeID = edi.verifyPassword(email, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (employeeID > 0)
		{
			out.print("Welcome, " + email);
			HttpSession session = request.getSession();
			
	//		Cookie cookie = new Cookie("emplID", employeeID+""); //May not be needed if we're using session.
	//		response.addCookie(cookie);
			
			session.setAttribute("name", email);
			session.setAttribute("emplID", employeeID);
			response.sendRedirect("myAccount");
		}
		else
		{
			out.print("Sorry, username or password error.");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		
		out.close();
	}
	
	
	//Updates login info to be passed to LoginDaoImpl.
	//TODO: Complete implementation once DAO is completed.
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("In doPut of LoginServlet");
	}

}

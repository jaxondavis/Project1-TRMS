package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MyAccountApplicationsServlet for loading all applications belonging to an account
 */
public class MyAccountApplicationsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Gets current session (if not void) and sends redirect to appropriate path.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpSession session = null;
	//	EmployeeDaoImpl edi = new EmployeeDaoImpl();
	//	EmployeeHasTypeImpl ehti = new EmployeeHasTypeImpl();
	//	EmployeeTypeImpl eti = new EmployeeTypeImpl();
	//	Employee empl = null;
	//	String emplType = null;
		response.setContentType("text/html");
		if (request.getSession() == null)
		{
			System.out.println("Returning to login page.");
			//request.getRequestDispatcher("login.html").include(request, response);
			response.sendRedirect("login.html");
		}
		else
		{
			System.out.println("Redirect to applications page.");
			//session = request.getSession(); ///myAccount/application
			request.getRequestDispatcher("/applications.html").forward(request, response);
			//response.sendRedirect("applications");
			System.out.println("After dispatch Attempt");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

}

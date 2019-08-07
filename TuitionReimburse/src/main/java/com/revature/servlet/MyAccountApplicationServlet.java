package com.revature.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Employee;
import com.revature.daoimpl.EmployeeDaoImpl;

/**
 * Servlet implementation class MyAccountApplicationServlet
 */
public class MyAccountApplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Gets current session (if not void) and sends redirect to appropriate path.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = null;
	//	EmployeeDaoImpl edi = new EmployeeDaoImpl();
	//	EmployeeHasTypeImpl ehti = new EmployeeHasTypeImpl();
	//	EmployeeTypeImpl eti = new EmployeeTypeImpl();
	//	Employee empl = null;
	//	String emplType = null;
		
		if (request.getSession() == null)
		{
			System.out.println("Returning to login page.");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		else
		{
			session = request.getSession();
			response.sendRedirect("/myAccount/application");
		}
	}

}

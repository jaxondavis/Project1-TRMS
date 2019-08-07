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
 * Servlet implementation class MyAccountServlet
 */
public class MyAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Gets current session. If session's void, returns to login. Otherwise return employee info depending on whether employee or supervisor.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = null;
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
	//	EmployeeHasTypeImpl ehti = new EmployeeHasTypeImpl();
	//	EmployeeTypeImpl eti = new EmployeeTypeImpl();
		Employee empl = null;
		String emplType = null;
		
		if (request.getSession() == null)
		{
			System.out.println("Returning to login page.");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		else
		{
			session = request.getSession();
			Integer emplID = (Integer)session.getAttribute("emplID");
			try {
				empl = edi.getEmployee(emplID);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//Pass along employee vals to a PrintWriter(?)
		
		
		//Get value from EmployeeHasType table. Can either use to call EmployeeType table to get String or just use typeID for if statements.
	//	int typeID = ehti.getType(emplID);
	//	emplType = eti.getType(typeID);
		
		//Does check for employee/supervisor. May be removed/reimplemented for checks for admin specific functions.
		if (emplType == "employee")
		{
			//Pass to employee landing page.
			System.out.println("Redirecting to employee page.");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		else if (emplType == "benco" || emplType == "depthead" || emplType == "supervisor")
		{
			//Pass to admin landing page.
		}
		else if (emplType == null)
		{
			System.out.println("Something went wrong, let's try again.");
			request.getRequestDispatcher("login.html").include(request, response);
		}
	}
	
}

package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MyEmployeesEmployeeIDServlet
 * Class for getting employee info/application, and determining whether to approve or deny application.
 */
public class MyEmployeesEmployeeIDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Add employee info & application to response.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In doGet of My Employee Applications.");
		PrintWriter out = response.getWriter();
		
		if (request.getSession() == null)
		{
			System.out.println("Returning to login page.");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		else
		{
			session = request.getSession();
			Integer emplID = (Integer)session.getAttribute("emplID");
			out.write("Employee #" + emplID + ": ");
		}
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 * Changes application status. If "deny", forwards to /deny path to input cause of denial.
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Query/update application status function. If statement for deny to pass along to deny.
		String appStatus = "approved"; //Should be revised to read in from HTML after manipulation.
		
		
		if (appStatus.equals("approved"))
		{
			
		}
		else if (appStatus.equals("denied"))
		{
			response.sendRedirect("/deny");
		}
	}

}

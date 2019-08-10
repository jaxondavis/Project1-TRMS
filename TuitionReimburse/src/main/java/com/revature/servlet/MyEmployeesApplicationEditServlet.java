package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MyEmployeesApplicationEditServlet
 * Class for getting application info & sends info for needed edits/updates to employee.
 */
public class MyEmployeesApplicationEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Get session and application form.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In doGet of My Employee Application Edit.");
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * Sends email of necessary changes to user.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

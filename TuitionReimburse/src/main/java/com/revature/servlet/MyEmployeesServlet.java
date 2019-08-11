package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MyEmployeesServlet Admin only. Should be read
 * only.
 */
public class MyEmployeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response) If session isn't void, get session and all employees that
	 *      report to user, directly or indirectly. Should pass through DAO.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("In doGet of myEmployees.");
		HttpSession session = null;
		PrintWriter out = response.getWriter();

		if (request.getSession() == null) {
			System.out.println("Returning to login page.");
			request.getRequestDispatcher("login.html").include(request, response);
		} else {
			session = request.getSession();
			Integer emplID = (Integer) session.getAttribute("emplID");
			out.write("Employee #" + emplID + ": ");

			// Start getting list of Employees. Should we have this as procedure/method in
			// DaoImpl?
		}
	}

}

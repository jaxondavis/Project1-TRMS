package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MyEmployeesApplicationServlet Class for getting
 * Applications according to employee ID for review. TODO: Complete
 * implementation for getting employee applications using ApplicationDaoImpl,
 * display via AJAX?
 */
public class MyEmployeesApplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("In doGet of My Employee Applications.");
		HttpSession session = null;
		PrintWriter out = response.getWriter();

		if (request.getSession() == null) {
			System.out.println("Returning to login page.");
			request.getRequestDispatcher("login.html").include(request, response);
		} else {
			session = request.getSession();
			Integer emplID = (Integer) session.getAttribute("emplID");
			out.write("Employee #" + emplID + ": ");

			// Start getting list of employee's applications. Should we have this as
			// procedure/method in DaoImpl?
		}
	}

}

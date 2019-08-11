package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MyAccountApplicationIDServlet
 */
public class MyAccountApplicationIDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response) Gets session if valid, and redirects to new path (w/unique app
	 *      ID) TODO: Figure out how we're getting applicationID. Likely through
	 *      query statement from ApplicationDaoImpl
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = null;
		PrintWriter out = response.getWriter();
		int applicationID = 0;

		if (request.getSession() == null) {
			System.out.println("Returning to login page.");
			request.getRequestDispatcher("login.html").include(request, response);
		} else {
			session = request.getSession();
			Integer emplID = (Integer) session.getAttribute("emplID");
			out.write("Employee #" + emplID + ": ");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

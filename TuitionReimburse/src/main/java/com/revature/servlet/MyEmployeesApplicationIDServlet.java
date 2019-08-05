package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MyEmployeesApplicationIDServlet
 */
public class MyEmployeesApplicationIDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * To link up to benco_menu.html(?) Gonna look into getting form from there based off of application ID?
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("benco_menu.html").include(request, response);
		
		//Checks to see if session exists, if so returns null.
		HttpSession session = request.getSession(false);
		if (session != null)
		{
			String name = (String)session.getAttribute("name");
			out.print("Ello, " + name + ", welcome to Profile!");
		}
		else
		{
			out.print("Please login first");
			request.getRequestDispatcher("link.html").include(request, response);
		}
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

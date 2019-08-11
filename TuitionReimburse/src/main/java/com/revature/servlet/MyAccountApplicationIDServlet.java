package com.revature.servlet;

import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import com.google.gson.Gson;
//import com.revature.beans.Application;
//import com.revature.beans.ApplicationJSON;
//import com.revature.beans.Event;
//import com.revature.beans.EventLocation;
//import com.revature.beans.EventType;
//import com.revature.daoimpl.ApplicationDaoImpl;
//import com.revature.daoimpl.EmpHasTypeDaoImpl;
//import com.revature.daoimpl.EventDaoImpl;
//import com.revature.daoimpl.EventLocationDaoImpl;
//import com.revature.daoimpl.EventTypeDaoImpl;

/**
 * Servlet implementation class MyAccountApplicationIDServlet for opening a specific application
 */
public class MyAccountApplicationIDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response) Gets session if valid, and redirects to new path (w/unique app
	 *      ID) TODO: Figure out how we're getting applicationID. Likely through
	 *      query statement from ApplicationDaoImpl
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		if (request.getSession() == null)
		{
			System.out.println("Returning to login page.");
			//request.getRequestDispatcher("login.html").include(request, response);
			response.sendRedirect("login.html");
		}
		else
		{
			System.out.println("Redirect to application id page.");
			//session = request.getSession(); ///myAccount/application
			request.getRequestDispatcher("/applications_ID.html").forward(request, response);
			//response.sendRedirect("applications");
			System.out.println("After dispatch Attempt");
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

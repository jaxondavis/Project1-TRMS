package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Application;
import com.revature.daoimpl.ApplicationDaoImpl;

/**
 * Servlet implementation class MyEmployeesApplicationListServlet
 */
public class MyEmployeesApplicationListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doget for /myEmployeesApplications");
		HttpSession session = request.getSession();
		ApplicationDaoImpl adi = new ApplicationDaoImpl();
		Application app = null;			//Not used, but might be useful for something?
		ArrayList<Application> appList = null;
		
		
		if(session == null)
		{
			request.getRequestDispatcher("html/login.html").forward(request, response);
		}
		else
		{
			try {
				appList = new ArrayList<Application>(adi.getAllApplications());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
			
			//Writes object to JSON
			ObjectMapper mapper = new ObjectMapper();
			PrintWriter out = response.getWriter();
			String appListJSON = mapper.writeValueAsString(appList);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.println(appListJSON);
			System.out.println(appListJSON);
			out.flush();
			
			request.getRequestDispatcher("../../html/myemployeesapplications.html").forward(request, response);
		}
	}

}

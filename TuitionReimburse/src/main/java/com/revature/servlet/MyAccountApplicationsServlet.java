package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Application;
import com.revature.daoimpl.ApplicationDaoImpl;

/**
 * Servlet implementation class MyAccountApplicationsServlet for loading all applications belonging to an account
 */
public class MyAccountApplicationsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Gets current session (if not void) and sends redirect to appropriate path.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD:TuitionReimburse/src/main/java/com/revature/servlet/MyAccountApplicationServlet.java
		System.out.println("in doget for /application");
		HttpSession session = request.getSession();
		ApplicationDaoImpl adi = new ApplicationDaoImpl();
		Application app = null;
		Integer applicationID = 0;
		
		if (session == null)
=======
		//HttpSession session = null;
	//	EmployeeDaoImpl edi = new EmployeeDaoImpl();
	//	EmployeeHasTypeImpl ehti = new EmployeeHasTypeImpl();
	//	EmployeeTypeImpl eti = new EmployeeTypeImpl();
	//	Employee empl = null;
	//	String emplType = null;
		response.setContentType("text/html");
		if (request.getSession() == null)
>>>>>>> d140fc92882c587028aab56bfba263d384848413:TuitionReimburse/src/main/java/com/revature/servlet/MyAccountApplicationsServlet.java
		{
			System.out.println("Returning to login page.");
			//request.getRequestDispatcher("login.html").include(request, response);
			response.sendRedirect("login.html");
		}
		else
		{
<<<<<<< HEAD:TuitionReimburse/src/main/java/com/revature/servlet/MyAccountApplicationServlet.java
			try {
				app = adi.getApplication(applicationID);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
			
			//Writes object to JSON
			ObjectMapper mapper = new ObjectMapper();
			PrintWriter out = response.getWriter();
			String appJSON = mapper.writeValueAsString(app);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.println(appJSON);
			System.out.println(appJSON);
			out.flush();
			
			request.getRequestDispatcher("html/myapplication.html").forward(request, response);
=======
			System.out.println("Redirect to applications page.");
			//session = request.getSession(); ///myAccount/application
			request.getRequestDispatcher("/applications.html").forward(request, response);
			//response.sendRedirect("applications");
			System.out.println("After dispatch Attempt");
>>>>>>> d140fc92882c587028aab56bfba263d384848413:TuitionReimburse/src/main/java/com/revature/servlet/MyAccountApplicationsServlet.java
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

}

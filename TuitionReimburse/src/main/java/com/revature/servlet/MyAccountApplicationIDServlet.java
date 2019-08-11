package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.revature.beans.Application;
import com.revature.beans.ApplicationJSON;
import com.revature.beans.Event;
import com.revature.beans.EventLocation;
import com.revature.beans.EventType;
import com.revature.daoimpl.ApplicationDaoImpl;
import com.revature.daoimpl.EmpHasTypeDaoImpl;
import com.revature.daoimpl.EventDaoImpl;
import com.revature.daoimpl.EventLocationDaoImpl;
import com.revature.daoimpl.EventTypeDaoImpl;

/**
 * Servlet implementation class MyAccountApplicationIDServlet for opening a specific application
 */
public class MyAccountApplicationIDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Gets session if valid, and redirects to new path (w/unique app ID)
	 * TODO: Figure out how we're getting applicationID. Likely through query statement from ApplicationDaoImpl
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = null;
		PrintWriter out = response.getWriter();
		Integer appID = 0;
		Integer emplID = 0;
		EmpHasTypeDaoImpl ehdi = new EmpHasTypeDaoImpl();
		ApplicationDaoImpl adi = new ApplicationDaoImpl();
		EventLocationDaoImpl eldi = new EventLocationDaoImpl();
		EventDaoImpl edi = new EventDaoImpl();
		EventTypeDaoImpl etdi = new EventTypeDaoImpl();
		
		Application app = new Application();
		
		if (request.getSession() == null)
		{
			System.out.println("Returning to login page.");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		else
		{
			session = request.getSession();
			appID = (Integer)session.getAttribute("appID");
			emplID = (Integer)session.getAttribute("emplID");
			request.getRequestDispatcher("/applications.html").include(request, response);
			///myAccount/myEmployees/applications
			//out.write("Employee #" + emplID + ": ");
			try 
			{
				app = adi.getApplication(appID);
				Event eve = edi.getEvent(app.getEventID());
				EventLocation eveLoc = eldi.getEventLocation(eve.getLocationID());
				//System.out.println(eveLoc);
				EventType eveType = etdi.getEventType(eve.getTypeID());
				//System.out.println(eveType);
				ApplicationJSON json = new ApplicationJSON(app, eve, eveLoc, eveType);
				
				if(ehdi.getTypeID(emplID) == 1)
				{
					Gson gSon = new Gson();
					//System.out.println(gSon.toJson(combinedList));
					PrintWriter pw = response.getWriter();
					response.setContentType("application/json");
					//response.setCharacterEncoding("UTF-8");
					//pw.print(jsonString);
					pw.print(gSon.toJson(json));
					//request.getRequestDispatcher("/applications").include(request, response);
				}
				else
				{
					//forward to /myAccount/myEmployees/applications
					request.getRequestDispatcher("").forward(request, response);
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

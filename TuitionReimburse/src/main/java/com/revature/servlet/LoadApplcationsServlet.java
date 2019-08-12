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
 * Servlet implementation class LoadApplcationsServlet
 */
public class LoadApplcationsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = null;
		EmpHasTypeDaoImpl ehdi = new EmpHasTypeDaoImpl();
		ApplicationDaoImpl adi = new ApplicationDaoImpl();
		EventLocationDaoImpl eldi = new EventLocationDaoImpl();
		EventDaoImpl edi = new EventDaoImpl();
		EventTypeDaoImpl etdi = new EventTypeDaoImpl();
		
		ArrayList<Application> appList = new ArrayList<Application>();
		ArrayList<ApplicationJSON> combinedList = new ArrayList<ApplicationJSON>();
		
		if (request.getSession() == null)
		{
			System.out.println("Returning to login page.");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		else
		{
			session = request.getSession();
			Integer emplID = (Integer)session.getAttribute("emplID");
			try 
			{
				appList = adi.getAllApplicationsFromEmployee(emplID);
				//locList = eldi.getAllEventLocations();
				//eventList = edi.getAllEvents();
				//System.out.println(appList.get(0));
				for(int i = 0; i < appList.size(); i++)
				{
					Event eve = edi.getEvent(appList.get(i).getEventID());
					//System.out.println(eve);
					EventLocation eveLoc = eldi.getEventLocation(eve.getLocationID());
					//System.out.println(eveLoc);
					EventType eveType = etdi.getEventType(eve.getTypeID());
					//System.out.println(eveType);
					ApplicationJSON json = new ApplicationJSON(appList.get(i), eve, eveLoc, eveType);
					combinedList.add(json);
				}
				
				if(ehdi.getTypeID(emplID) == 1)
				{
					Gson gSon = new Gson();
					//System.out.println(gSon.toJson(combinedList));
					PrintWriter pw = response.getWriter();
					response.setContentType("application/json");
					//response.setCharacterEncoding("UTF-8");
					//pw.print(jsonString);
					pw.print(gSon.toJson(combinedList));
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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = null;
		EmpHasTypeDaoImpl ehdi = new EmpHasTypeDaoImpl();
		ApplicationDaoImpl adi = new ApplicationDaoImpl();
		EventLocationDaoImpl eldi = new EventLocationDaoImpl();
		EventDaoImpl edi = new EventDaoImpl();
		EventTypeDaoImpl etdi = new EventTypeDaoImpl();
		
		Application app = new Application();
		//ArrayList<ApplicationJSON> combinedList = new ArrayList<ApplicationJSON>();
		
		if (request.getSession() == null)
		{
			System.out.println("Returning to login page.");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		else
		{
			session = request.getSession();
			Integer appID = Integer.parseInt(request.getParameter("appID"));
			session.setAttribute("appID", appID);
			//Integer appID = (Integer)session.getAttribute("appID");
			System.out.println(appID);
			Integer emplID = (Integer)session.getAttribute("emplID");
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
					//request.getRequestDispatcher("/application_ID.html").forward(request, response);
					
					System.out.println("at the end of dopost");
					//response.sendRedirect("/myAccount/applications/applicationID");
					System.out.println("after send redirect");
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
}

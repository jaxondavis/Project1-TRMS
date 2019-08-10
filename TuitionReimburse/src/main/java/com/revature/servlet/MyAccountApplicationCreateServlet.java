package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Application;
import com.revature.daoimpl.ApplicationDaoImpl;
import com.revature.daoimpl.EventDaoImpl;
import com.revature.daoimpl.EventLocationDaoImpl;
import com.revature.daoimpl.EventTypeDaoImpl;
import com.revature.daoimpl.GradingFormatDaoImpl;

/**
 * Servlet implementation class MyAccountApplicationCreateServlet
 */
public class MyAccountApplicationCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Get current session & params if session isn't void.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doget for /application/create");
		HttpSession session = request.getSession();
		ApplicationDaoImpl adi = new ApplicationDaoImpl();
		EventDaoImpl edi = new EventDaoImpl();
		EventLocationDaoImpl eldi = new EventLocationDaoImpl();
		GradingFormatDaoImpl gdi = new GradingFormatDaoImpl();
		EventTypeDaoImpl etdi = new EventTypeDaoImpl();
		Application app = null;
		
		Integer eventID = 0;
		Integer locationID = 0;
		Integer presID = 0;
		
		if(session == null)
		{
			request.getRequestDispatcher("html/login.html").forward(request, response);
		}
		else
		{
			//Get params from form.
			String eventName = (String)session.getAttribute("event_name");
			Date date = (Date)session.getAttribute("date");
			Time time = (Time)session.getAttribute("time");
			String location = (String)session.getAttribute("location");
			String city = (String)session.getAttribute("city");
			String state = (String)session.getAttribute("state");
			String zip = (String)session.getAttribute("zip");
			String eventType = (String)session.getAttribute("event_type");
			Double cost = (Double)session.getAttribute("cost");
			String grading = (String)session.getAttribute("grading_format");
			String description = (String)session.getAttribute("description");
			String justify = (String)session.getAttribute("justification");
			
			//Get params from session.
			Integer employeeID = (Integer)session.getAttribute("employeeID");
			
			//Creates account using params passed through. Should get Parameter/Element names.
			try {
				eldi.addEventLocation(location, city, state, zip);
				locationID = eldi.confirmEventLocation(location, city, state, zip);
				
				Integer formatID = gdi.getGradingID(grading);
				Integer typeID = etdi.getTypeID(eventType);
				
				edi.addEvent(eventName, date.toString(), time.toString(), cost, description, locationID, formatID, typeID);
				
				eventID = edi.getEventID(eventName);
				
				adi.addApplication(justify, employeeID, 1, eventID, typeID, presID);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("Couldn't connect to database. Please try again later.");
			}
			
			System.out.println("Application submitted.");
			
			//Do we want a call here to get the most recent app ID? Might come in handy for printing. :D
			
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
		}
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 * Send submitted info to ApplicationDaoImpl to create/update row in DB. (Would this be done by setAttribute or getAttribute for session?
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}

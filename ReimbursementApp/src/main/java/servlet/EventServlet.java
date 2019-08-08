package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.Event;
import com.revature.daoimpl.EventDaoImpl;

/**
 * Servlet implementation class EventServlet
 */
public class EventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doget for /events");
		/*
		 * PrintWriter out=response.getWriter(); EventDaoImpl event = new
		 * EventDaoImpl(); List<Event> events = null;
		 * 
		 * events = event.getEvents();
		 * 
		 * response.setContentType("application/json");
		 * response.setCharacterEncoding("UTF-8");
		 * 
		 * out.print(events);
		 */
		
		RequestDispatcher rd = request.getRequestDispatcher("html/events.html");
		//rd.include(request, response);
		rd.forward(request, response);
		
		//out.flush();
	}

}

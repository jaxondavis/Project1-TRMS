package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	 * Gets list of events 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doget for /events");
		HttpSession session = request.getSession();
		EventDaoImpl edi = new EventDaoImpl();
		List<Event> events = null;
		
		//Checks to ensure session is valid.
		if (session == null)
		{
			request.getRequestDispatcher("html/login.html").forward(request, response);
		}
		else
		{
			try {
				events = edi.getEvents();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			
			for (int i = 0; i < events.size(); i++)
			{
				out.write(events.get(i).toString());
			}
			out.flush();
			
			RequestDispatcher rd = request.getRequestDispatcher("html/events.html");
			rd.forward(request, response);
			
			
			
		}
		
	}

}

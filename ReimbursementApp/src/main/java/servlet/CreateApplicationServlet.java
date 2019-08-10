package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Application;
import com.revature.daoimpl.ApplicationDaoImpl;

/**
 * Servlet implementation class CreateApplicationServlet
 */
public class CreateApplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateApplicationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doget for /application/create");
		HttpSession session = request.getSession();
		ApplicationDaoImpl adi = new ApplicationDaoImpl();
		Application app = null;
		
		if(session == null)
		{
			request.getRequestDispatcher("html/login.html").forward(request, response);
		}
		else
		{
			//TODO: Confirm attribute names are correct. If this isn't useful, replace with a JSON parser.
			String justify = (String)session.getAttribute("justification");
			Integer employeeID = (Integer)session.getAttribute("employeeID");
			Integer reqID = (Integer)session.getAttribute("requestID");
			Integer eventID = (Integer)session.getAttribute("eventID");
			
			//Creates account using params passed through. Should get Parameter/Element names.
			try {
				adi.insertApplication(justify, employeeID, reqID, eventID);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
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
	 * For altering data in application(?). Would this be similar to EditMyApplicationServlet?
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

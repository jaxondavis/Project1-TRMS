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
 * Servlet implementation class MyApplicationServlet
 */
public class MyApplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyApplicationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Can use ApplicationDaoImpl to create object to display on page.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doget for /application");
		HttpSession session = request.getSession();
		ApplicationDaoImpl adi = new ApplicationDaoImpl();
		Application app = null;
		Integer applicationID = 0;
		
		if(session == null)
		{
			request.getRequestDispatcher("html/login.html").forward(request, response);
		}
		else
		{
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
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}

package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.daoimpl.EmployeeDaoImpl;
import com.revature.daoimpl.EmployeeTypeDaoImpl;
import com.revature.daoimpl.LoginDaoImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in doget for /login");
		RequestDispatcher rd = request.getRequestDispatcher("html/login.html");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		//PrintWriter out = response.getWriter();  

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		LoginDaoImpl ldi = new LoginDaoImpl();
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		EmployeeTypeDaoImpl etdi = new EmployeeTypeDaoImpl();

		Integer employeeid = 0;// change back to 0 after test
		Integer typeid = 0;
		String name = "";
		String employeetype = "";
		//try {
			//employeeid = ldi.checkLogin(email, password);
			if (employeeid > 0 && employeeid != null) {
				//session.setAttribute("employeeid", employeeid);
				//name = edi.getName(employeeid);
				//session.setAttribute("name", name);
				//typeid = edi.getTypeId(employeeid);
				//employeetype = etdi.getType(typeid);
				//session.setAttribute("employeetype", employeetype);
				response.sendRedirect("account");
			}
			else {
				response.setContentType("text/html");
				//out.print("<h3>Sorry UserName or Password Error!</h3>");  
		        RequestDispatcher rd=request.getRequestDispatcher("html/login.html");  
		        rd.include(request, response);  
			}
		//} catch (SQLException e) {
			//e.printStackTrace();
		//}
	}
}

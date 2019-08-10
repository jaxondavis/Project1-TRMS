package servlet;

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
import com.revature.beans.Address;
import com.revature.beans.Employee;
import com.revature.daoimpl.AddressDaoImpl;
import com.revature.daoimpl.EmployeeDaoImpl;

/**
 * Servlet implementation class MyEmployeesServlet
 */
public class MyEmployeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyEmployeesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Guess this should return list of employees reporting to user?
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doget for /myEmployees");
		HttpSession session = request.getSession();
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		AddressDaoImpl adi = new AddressDaoImpl();
		Integer employeeID = 0;
		ArrayList<Employee> employeeList = null;
		Employee employee = null;
		String reportsTo = null;
		Address address = null;
		
		if(session == null)
		{
			request.getRequestDispatcher("html/login.html").forward(request, response);
		}
		else
		{
			employeeID = (Integer)session.getAttribute("employeeid");
			try {
				employeeList = new ArrayList<Employee>(edi.viewEmployeesReportingTo(employeeID));
			} catch (SQLException e) {
				// TODO Auto-generated catch block. DON'T PRINT STACK.
				//e.printStackTrace();
			}
			
		//Writes object to JSON
		ObjectMapper mapper = new ObjectMapper();
		PrintWriter out = response.getWriter();
		String emplListJSON = mapper.writeValueAsString(employeeList);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.println(emplListJSON);
		System.out.println(emplListJSON);
		out.flush();
		
		request.getRequestDispatcher("html/myaccount/myEmployees.html").forward(request, response);
			
		}
		
	}

}

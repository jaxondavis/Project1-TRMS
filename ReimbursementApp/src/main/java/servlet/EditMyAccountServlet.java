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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Address;
import com.revature.beans.Employee;
import com.revature.daoimpl.AddressDaoImpl;
import com.revature.daoimpl.EmployeeDaoImpl;
import com.revature.daoimpl.LoginDaoImpl;

/**
 * Servlet implementation class EditMyAccountServlet
 */
public class EditMyAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditMyAccountServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in doget for /account/edit");
		HttpSession session = request.getSession();
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		AddressDaoImpl adi = new AddressDaoImpl();
		Integer employeeID = 0;
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
				employee = edi.getEmployee(employeeID);
				reportsTo = edi.getReportsTo(employee.getReportsTo());
				address = adi.getAddress(employee.getAddressID());
			} catch (SQLException e) {
				// TODO Auto-generated catch block. DON'T PRINT STACK.
				//e.printStackTrace();
			}
			
		//Writes object to JSON
		ObjectMapper mapper = new ObjectMapper();
		PrintWriter out = response.getWriter();
		String emplJSON = mapper.writeValueAsString(employee);
		String repToJSON = mapper.writeValueAsString(reportsTo);
		String addrJSON = mapper.writeValueAsString(address);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.println(emplJSON);
		out.println(repToJSON);
		out.println(addrJSON);
		System.out.println(emplJSON);
		System.out.println(repToJSON);
		System.out.println(addrJSON);
		out.flush();
		
		request.getRequestDispatcher("html/myaccount.html").forward(request, response);
			
		}
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 * 
	 * 	This is gonna be crazy elaborate for the time frame. We'd need individual if statements for each DAO to check for every individual column,
	 *	some which are foreign keys to other tables. I don't believe we have enough time for this, and recommend we delay until high priority tasks
	 *	are complete.
	 *
	 *	
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		AddressDaoImpl adi = new AddressDaoImpl();
		LoginDaoImpl ldi = new LoginDaoImpl();

		Integer employeeid;
		if (session != null) {
			employeeid = (Integer) session.getAttribute("employeeid");
			String column = null; //session.getAttribute("columnName");
			String newVal = null; //session.getAttribute("newValue");
			
			//variable = request.getParameter("") till we have all from from
			//can't auto turn into obj because putting info into multiple tables
			//call respective dao put methods to send updates to each table
		}else {
			response.sendRedirect("/login");
		}
	}

}

package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.revature.beans.Address;
import com.revature.beans.Employee;
import com.revature.beans.EmployeeHasType;
import com.revature.beans.Login;
import com.revature.beans.MyAccountJSON;
import com.revature.daoimpl.AddressDaoImpl;
import com.revature.daoimpl.EmpHasTypeDaoImpl;
import com.revature.daoimpl.EmployeeDaoImpl;
import com.revature.daoimpl.LoginDaoImpl;

/**
 * Servlet implementation class MyAccountServlet
 */
public class MyAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Gets current session. If session's void, returns to login. Otherwise return employee info depending on whether employee or supervisor.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = null;
		AddressDaoImpl adi = new AddressDaoImpl();
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		EmpHasTypeDaoImpl ehti = new EmpHasTypeDaoImpl();
		LoginDaoImpl ldi = new LoginDaoImpl();
		
		Employee empl = null;
		Address add = null;
		Login log = null;
		EmployeeHasType empType = new EmployeeHasType();
		
		if (request.getSession() == null)
		{
			System.out.println("Returning to login page.");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		else
		{
			session = request.getSession();
			//Integer emplID = (Integer)session.getAttribute("emplID");
			Integer emplID = 1;
			try {
				empl = edi.getEmployee(emplID);
				add = adi.getAddress(empl.getAddressID());
				empType.setTypeID(ehti.getTypeID(emplID));
				log = ldi.getLoginFromEmployee(emplID);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		JsonObject employeeJSON = new JsonObject();
		employeeJSON.addProperty("employeeid", empl.getEmployeeID());
		employeeJSON.addProperty("firstname", empl.getFirstname());
		employeeJSON.addProperty("lastname", empl.getLastname());
		employeeJSON.addProperty("email", log.getEmail());
		String typeName = "";
		switch(empType.getTypeID())
		{
			case 1:
				typeName = "Employee";
				break;
			case 2:
				typeName = "Direct Supervisor";
				break;
			case 3:
				typeName = "Department Head";
				break;
			case 4:
				typeName = "Benefits Coordinator";
				break;
		}
		employeeJSON.addProperty("type", typeName);
		employeeJSON.addProperty("address", add.getAddress());
		employeeJSON.addProperty("city", add.getCity());
		employeeJSON.addProperty("state", add.getState());
		employeeJSON.addProperty("zipcode", add.getZipcode());
		employeeJSON.addProperty("birthdate", empl.getBirthdate().toString());
		try {
			employeeJSON.addProperty("reportsto", edi.getName(empl.getReportsTo()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Pass along employee vals to a PrintWriter(?)
		System.out.println(employeeJSON.toString());
		
		//response.setContentType("text/html");
		
		ObjectMapper mapper = new ObjectMapper();
		MyAccountJSON jsonThing = new MyAccountJSON(empl, add, log, empType);
		String jsonString = mapper.writeValueAsString(jsonThing);

		PrintWriter pw = response.getWriter();
		//response.setContentType("application/json");
		//response.setCharacterEncoding("UTF-8");
		//pw.print(jsonString);
		pw.print(employeeJSON.toString());
		
		//Get value from EmployeeHasType table. Can either use to call EmployeeType table to get String or just use typeID for if statements.
	//	int typeID = ehti.getType(emplID);
	//	emplType = eti.getType(typeID);
		
		//Does check for employee/supervisor. May be removed/reimplemented for checks for admin specific functions.
		if (session != null)
		{
			//Pass to employee landing page.
			response.setContentType("text/html");
			System.out.println("Redirecting to employee page.");
			request.getRequestDispatcher("myaccount.html").forward(request, response);
		}
		else
		{
			System.out.println("Something went wrong, let's try again.");
			request.getRequestDispatcher("login").include(request, response);
		}
	}
	
}

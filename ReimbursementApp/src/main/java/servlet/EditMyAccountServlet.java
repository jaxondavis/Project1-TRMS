package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
//		HttpSession session = request.getSession();
//		EmployeeDaoImpl edi = new EmployeeDaoImpl();
//		AddressDaoImpl adi = new AddressDaoImpl();
//		LoginDaoImpl ldi = new LoginDaoImpl();
//
//		Integer employeeid;
//		String reportsTo;
//		Address a;
//		Employee e;
//		String email;
//
//		if (session != null) {

//			employeeid = (Integer) session.getAttribute("employeeid");
//			e = edi.getEmployee(employeeid);
//			reportsTo = edi.getReportsTo(e.getReportsTo());
//			a = adi.getAddress(e.getAddressId());
//			email = ldi.getEmail(employeeid);

			// send it as json
			RequestDispatcher rd=request.getRequestDispatcher("../html/editmyaccount.html");  
	        rd.forward(request, response);

//		} else {
//			response.sendRedirect("/login");
//		}
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
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
			//variable = request.getParameter("") till we have all from from
			//can't auto turn into obj because putting info into multiple tables
			//call respective dao put methods to send updates to each table
		}else {
			response.sendRedirect("/login");
		}
	}

}

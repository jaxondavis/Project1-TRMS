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

/**
 * Servlet implementation class MyAccountServlet
 */
public class MyAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doget for /account");
		/*
		 * HttpSession session = request.getSession(); EmployeeDaoImpl edi = new
		 * EmployeeDaoImpl(); AddressDaoImpl adi = new AddressDaoImpl();
		 * 
		 * Integer employeeid; String reportsTo; Address a; Employee e;
		 */
		
		//if(session != null) {
			
			//employeeid = (Integer) session.getAttribute("employeeid");
			//e = edi.getEmployee(employeeid);
			//reportsTo = edi.getReportsTo(e.getReportsTo());
			//a = adi.getAddress(e.getAddressId());
			//send it as json
			
			request.getRequestDispatcher("html/myaccount.html").forward(request, response);
			
		/*
		 * }else { response.sendRedirect("/login"); }
		 */
	}

}

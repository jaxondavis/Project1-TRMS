package com.revature.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Employee;
import com.revature.daoimpl.EmployeeDaoImpl;

/**
 * Servlet implementation class MyAccountEditServlet
 */
public class MyAccountEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response) Checks to confirm session isn't void, then gets current
	 *      session.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = null;
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		// EmployeeHasTypeImpl ehti = new EmployeeHasTypeImpl();
		// EmployeeTypeImpl eti = new EmployeeTypeImpl();
		Employee empl = null;
		String emplType = null;

		if (request.getSession() == null) {
			System.out.println("Returning to login page.");
			request.getRequestDispatcher("login.html").include(request, response);
		} else {
			session = request.getSession();
			Integer emplID = (Integer) session.getAttribute("emplID");
			try {
				empl = edi.getEmployee(emplID);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response) Sends all info to the appropriate DAO implementation
	 *      (EmployeeDaoImpl?)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		// TODO: How am I getting the values from the form?
		doGet(request, response);
	}

}

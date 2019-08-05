package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.Employee;
import com.revature.dao.EmployeeDao;
import com.revature.util.ConnFactory;

public class EmployeeDaoImpl implements EmployeeDao {

	public static ConnFactory cf = ConnFactory.getInstance();
	
	//Confirms that username/password match in EmployeeLogin table, then use userID to get Employee.
	//PARAMS: username, password - ideally from LoginServlet
	@Override
	public int verifyPassword(String username, String password) throws SQLException {
		Connection conn = cf.getConnection();
		//Statement - compiles on SQL side. Generally terrible. Allows for SQL Injection. Headaches. DON'T DO IT.
		String sql = "SELECT PASSWORD FROM LOGIN WHERE USERNAME = ?";
		String pw = null;
		int employeeID = 0;
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		while (rs.next())
		{
			pw = rs.getString(1);
		}
		//If password checks out, return employeeID for use to getEmployee.
		if (password.equals(pw))
		{
			String sql2 = "SELECT EMPLOYEEID FROM LOGIN WHERE USERNAME = ? AND PASSWORD = ?";
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps2.setString(1, username);
			ps2.setString(2, password);
			ResultSet rs2 = ps.executeQuery();
			while (rs2.next())
			{
				employeeID = rs.getInt(1);
			}
			return employeeID;
		}
		else return 0;
	}

	//Will likely remove due to security risk w/Employee class. Returns an Employee object.
	@Override
	public Employee getEmployee(int userID) throws SQLException {
		Employee empl = null;
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM EMPLOYEE WHERE EMPLOYEEID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, userID);
		ResultSet rs = ps.executeQuery();
		if (rs.equals(null))
		{
			System.out.println("Invalid login. Please try again.");
		}
		else
		{
			while (rs.next())
			{
				//ResultSet columns start at 1.
				//empl = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
			}
		}
		
		return empl;
	}

}

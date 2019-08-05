package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.Address;
import com.revature.beans.Employee;
import com.revature.beans.EmployeeHasType;
import com.revature.beans.Login;
import com.revature.dao.EmployeeDao;
import com.revature.util.ConnFactory;

public class EmployeeDaoImpl implements EmployeeDao {

	public static ConnFactory cf = ConnFactory.getInstance();
	
	//Confirms that username/password match in EmployeeLogin table, then use userID to get Employee.
	//PARAMS: username, password - ideally from LoginServlet
	@Override
	public int verifyPassword(String username, String password) throws SQLException 
	{
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
		else
		{
			return 0;
		}
	}

	//Will likely remove due to security risk w/Employee class. Returns an Employee object.
	@Override
	public Employee getEmployee(int userID) throws SQLException 
	{
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
				if(rs.getInt(1) == userID)
				{
					empl = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4),rs.getInt(5),rs.getInt(6),rs.getInt(7));
				}
			}
		}
		return empl;
	}

	@Override
	public void updateEmployee(Employee emp, EmployeeHasType empT, Address add, Login log) throws SQLException 
	{
		Connection conn = cf.getConnection();
		String sql = "UPDATE EMPLOYEE SET FIRSTNAME = ?, LASTNAME = ?, BIRTHDATE = ?, REPORTSTO = ? WHERE EMPLOYEEID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, emp.getFirstname());
		ps.setString(2, emp.getLastname());
		ps.setDate(3, emp.getBirthdate());
		ps.setInt(4, emp.getReportsTo());
		ps.setInt(5, emp.getEmployeeID());
		ResultSet rs = ps.executeQuery();
		
		sql = "UPDATE LOGIN SET EMAIL = ?, PASSWORD = ? WHERE EMPLOYEEID = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, log.getEmail());
		ps.setString(2, log.getPassword());
		ps.setInt(3, emp.getEmployeeID());
		rs = ps.executeQuery();
		
		sql = "UPDATE ADDRESS SET ADDRESS = ?, CITY = ?, STATE = ?, ZIPCODE = ? WHERE EMPLOYEEID = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, add.getAddress());
		ps.setString(2, add.getCity());
		ps.setString(3, add.getState());
		ps.setString(4, add.getZipcode());
		ps.setInt(5, emp.getEmployeeID());
		rs = ps.executeQuery();
		
		sql = "UPDATE ADDRESS SET ADDRESS = ?, CITY = ?, STATE = ?, ZIPCODE = ? WHERE EMPLOYEEID = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, add.getAddress());
		ps.setString(2, add.getCity());
		ps.setString(3, add.getState());
		ps.setString(4, add.getZipcode());
		ps.setInt(5, emp.getEmployeeID());
		rs = ps.executeQuery();
		
		sql = "UPDATE EMPLOYEEHASTYPE SET TYPEID = ? WHERE EMPLOYEEID = ?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, empT.getTypeID());
		ps.setInt(2, emp.getEmployeeID());
		rs = ps.executeQuery();
	}
}

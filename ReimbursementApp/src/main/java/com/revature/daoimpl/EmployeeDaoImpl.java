/**
 * 
 */
package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.util.ConnFactory;

/**
 * @author Revature Guest
 *
 */
public class EmployeeDaoImpl {
	public static ConnFactory cf = ConnFactory.getInstance();

	
	//TODO: create update method to utilize the procedure
	public String getName(Integer employeeid) throws SQLException {
		Connection conn = cf.getConnection();
		String name = null;
		String sql = "SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE WHERE EMPLOYEEID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, employeeid);
		ResultSet rs = ps.executeQuery();
		while (rs.next())
		{
			name = rs.getString(1) + " " + rs.getString(2);
		}
		return name;
	}

	public Integer getTypeId(Integer employeeid) throws SQLException {
		Connection conn = cf.getConnection();
		Integer typeID = 0;
		String sql = "SELECT TYPEID FROM EMPLOYEEHASTYPE WHERE EMPLOYEEID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, employeeid);
		ResultSet rs = ps.executeQuery();
		while (rs.next())
		{
			typeID = rs.getInt(1);
		}
		return typeID;
	}

	public Employee getEmployee(Integer employeeid) throws SQLException {
		Employee employee = null;
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM EMPLOYEE WHERE EMPLOYEEID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, employeeid);
		ResultSet rs = ps.executeQuery();
		if (rs.equals(null))
		{
			System.out.println("Invalid login. Please try again.");
		}
		else
		{
			while (rs.next())
			{
				employee = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4),rs.getInt(5),
				rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9),rs.getInt(10),rs.getInt(11));
			}
		}
		
		return employee;
	}

	public String getReportsTo(int reportsTo) throws SQLException {
		String employeeName="";
		Connection conn = cf.getConnection();
		String sql = "SELECT firstname, lastname FROM EMPLOYEE WHERE EMPLOYEEID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, reportsTo);
		ResultSet rs = ps.executeQuery();
		if (rs.equals(null))
		{
			System.out.println("Invalid login. Please try again.");
		}
		else
		{
			while (rs.next())
			{
				employeeName += rs.getString(1) + " " + rs.getString(2);
			}
		}
		
		return employeeName;
	}
	
	//Uses stored procedure to delete employee from table.
	public void deleteEmployee(Integer employeeID) throws SQLException
	{
		Connection conn = cf.getConnection();
		String sql = "{ call deleteemployee(?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, employeeID);
		call.execute();
		System.out.println("Employee has been DELETED! YEEEEEEEEAAAASSSSSSSSS.");
	}
	
	//Returns list of employees that report to a given user. Will need to access ReportsTo table. Check into this.
	public List<Employee> viewEmployeesReportingTo(Integer reportsTo) throws SQLException
	{
		Connection conn = cf.getConnection();
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		String sql = "SELECT * FROM EMPLOYEE WHERE REPORTSTO = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, reportsTo);
		ResultSet rs = ps.executeQuery();
		while (rs.next())
		{
			//Don't understand why this is throwing an error. It matches the args for the constructor...
			Employee employee = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4),rs.getInt(5),
					rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9),rs.getInt(10),rs.getInt(11));
			employeeList.add(employee);
		}
		return employeeList;
	}

}

/**
 * 
 */
package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getTypeId(Integer employeeid) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public Employee getEmployee(Integer employeeid) throws SQLException {
		Employee empl = null;
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
				//ResultSet columns start at 1.
				//empl = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
			}
		}
		
		return empl;
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

}

/**
 * 
 */
package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.revature.beans.Employee;
import com.revature.util.ConnFactory;

/**
 * @author Revature Guest
 *
 */
public class EmployeeDaoImpl {
	public static ConnFactory cf = ConnFactory.getInstance();

	// TODO: create update method to utilize the procedure
	public void updateEmployee(int employeeID, String firstname, String lastname, Date birthdate, int reportsTo, int emplTypeID, int addressID) throws SQLException{
		Connection conn = cf.getConnection();
		String sql = "{ call insertevent(?,?,?,?,?,?,?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, employeeID);
		call.setString(2, firstname);
		call.setString(3, lastname);
		call.setDate(4, (java.sql.Date) birthdate);
		call.setInt(5, reportsTo);
		call.setInt(6, emplTypeID);
		call.setInt(7, addressID);
		//call.setInt(8, typeID);
		
		call.execute();
		System.out.println("Insert sequence complete!");
	}

	public Employee getEmployee(Integer employeeid) throws SQLException {
		Employee empl = null;
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM EMPLOYEE WHERE EMPLOYEEID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, employeeid);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			// ResultSet columns start at 1.
			// empl = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3),
			// rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
		}

		return empl;
	}

	public String getReportsTo(int reportsTo) throws SQLException {
		String employeeName = "";
		Connection conn = cf.getConnection();
		String sql = "SELECT firstname, lastname FROM EMPLOYEE WHERE EMPLOYEEID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, reportsTo);
		ResultSet rs = ps.executeQuery();
		if (rs.equals(null)) {
			System.out.println("Invalid login. Please try again.");
		} else {
			while (rs.next()) {
				employeeName += rs.getString(1) + " " + rs.getString(2);
			}
		}

		return employeeName;
	}

}

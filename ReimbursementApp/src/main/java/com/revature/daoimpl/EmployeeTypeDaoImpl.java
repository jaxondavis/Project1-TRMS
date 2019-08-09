/**
 * 
 */
package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.Address;
import com.revature.util.ConnFactory;

/**
 * @author Revature Guest
 *
 */
public class EmployeeTypeDaoImpl {
	
	public static ConnFactory cf = ConnFactory.getInstance();

	public String getType(Integer typeID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT TYPE FROM EMPLOYEETYPE WHERE TYPEID = ?";
		String type = null;
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, typeID);
		ResultSet rs = ps.executeQuery();
		while (rs.next())
		{
			type = rs.getString(2);
		}
		return type;
	}

	public void insertEmployeeHasType(Integer employeeID, Integer typeID) throws SQLException
	{
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO EMPLOYEEHASTYPE VALUES(?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, employeeID);
		ps.setInt(2, typeID);
		ps.execute();
		System.out.println("Employee has been given type.");
	}
	
	public void deleteEmployeeHasType(Integer employeeID) throws SQLException
	{
		Connection conn = cf.getConnection();
		String sql = "DELETE FROM EMPLOYEEHASTYPE WHERE EMPLOYEEID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, employeeID);
		ps.execute();
		System.out.println("Employee's type has been removed.");
	}
	
}

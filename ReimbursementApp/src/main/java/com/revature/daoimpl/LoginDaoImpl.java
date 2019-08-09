/**
 * 
 */
package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.beans.Employee;
import com.revature.util.ConnFactory;

/**
 * @author Revature Guest
 *
 */
public class LoginDaoImpl {
	
	public static ConnFactory cf = ConnFactory.getInstance();

	public Integer checkLogin(String email, String password) throws SQLException {
		Connection conn = cf.getConnection();
		Integer employeeID = 0;
		String sql = "SELECT EMPLOYEEID FROM LOGIN WHERE EMAIL = ? AND PASSWORD = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, email);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		while (rs.next())
		{
			employeeID = rs.getInt(1);
		}
		return employeeID;
	}

	public String getEmail(Integer employeeid) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//Updates login info.
	public void updateLogin(Integer employeeID, String email, String password) throws SQLException
	{
		Connection conn = cf.getConnection();
		String sql = "UPDATE LOGIN SET EMAIL = ? AND PASSWORD = ? WHERE EMPLOYEEID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, email);
		ps.setString(2, password);
		ps.setInt(3, employeeID);
		ps.execute();
		System.out.println("Login credentials updated.");
	}

}

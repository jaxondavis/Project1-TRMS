package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.util.ConnFactory;

/*
 * TODO: Have method to get the reimbursement key? Or should we revise the procedure where we pass the employeeID in as the primary key?
 */

public class AvailableReimbursementImpl {
	
	public static ConnFactory cf = ConnFactory.getInstance();
	
	//Inserts value into table using stored procedure.
	public void insertAvailableReimbursement(Double funds) throws SQLException
	{
		Connection conn = cf.getConnection();
		String sql = "{ call insertavailablereimbursement(?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setDouble(1, funds);
		call.execute();
		System.out.println("$" + funds + " has been made available for reimbursement.");
	}
	
	//Procedure needs to be completed in SQL.
	public void updateAvailableReimbursement(Integer availID, Double funds) throws SQLException
	{
		Connection conn = cf.getConnection();
		String sql = "{ call updateavailablereimbursement(?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, availID);
		call.setDouble(2, funds);
		call.execute();
		System.out.println("$" + funds + " are now available for reimbursement.");
	}
	
	//Procedure not yet created in SQL, will use default DELETE statement.
	public void deleteAvailableReimbursement(Integer availID) throws SQLException
	{
		Connection conn = cf.getConnection();
		String sql = "DELETE FROM AVAILABLEREIMBURSEMENT WHERE AVAILABLEID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, availID);
		ps.execute();
		System.out.println("Employee no longer has access to funds.");
	}
	
	//Returns available reimbursement for an employee.
	public Double getAvailableReimbursement(Integer employeeID) throws SQLException
	{
		Connection conn = cf.getConnection();
		Double funds = 0.0;
		String sql = "SELECT AVAILABLEFUNDS FROM AVAILABLEREIMBURSEMENT, EMPLOYEE WHERE EMPLOYEEID = ? AND AVAILABLEREIMBURSEMENT.AVAILABLEID = EMPLOYEE.AVAILABLEID";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, employeeID);
		ResultSet rs = ps.executeQuery();
		while (rs.next())
		{
			funds = rs.getDouble(1);
		}
		return funds;
	}
	
	public Integer getCurrentIndex() throws SQLException
	{
		Connection conn = cf.getConnection();
		Integer maxID = 0;
		String sql = "SELECT MAX(AVAILABLEID) FROM AVAILABLEREIMBURSEMENT";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next())
		{
			maxID = rs.getInt(1);
		}
		return maxID;
	}

}

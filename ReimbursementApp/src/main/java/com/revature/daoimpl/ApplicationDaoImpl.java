package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Application;
import com.revature.util.ConnFactory;

public class ApplicationDaoImpl {
	
	public static ConnFactory cf = ConnFactory.getInstance();
	
	public void insertApplication(String justify, Integer employeeID, Integer reqID, Integer eventID) throws SQLException
	{
		Connection conn = cf.getConnection();
		String sql = "{ call insertapplication(?,?,?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, justify);
		call.setInt(2, employeeID);
		call.setInt(3, reqID);
		call.setInt(4, eventID);
		call.execute();
		System.out.println("Application has been added.");
	}
	
	public void updateApplication(Integer applicationID, String justify, Date subDate, Integer employeeID, Integer reqID, Integer eventID) throws SQLException
	{
		Connection conn = cf.getConnection();
		String sql = "{ call updateapplication(?,?,?,?,?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, applicationID);
		call.setString(2, justify);
		call.setDate(3, subDate);
		call.setInt(4, employeeID);
		call.setInt(5, reqID);
		call.setInt(6, eventID);
		call.execute();
		System.out.println("Application has been updated.");
	}
	
	public void deleteApplication(Integer applicationID) throws SQLException
	{
		Connection conn = cf.getConnection();
		String sql = "{ call deleteapplication(?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, applicationID);
		call.execute();
		System.out.println("Application has been DELETED! A PREMONEEEEEETION!.");
	}
	
	public Application getApplication(Integer applicationID) throws SQLException
	{
		Connection conn = cf.getConnection();
		Application app = null;
		String sql = "SELECT * FROM APPLICATION WHERE APPID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, applicationID);
		ResultSet rs = ps.executeQuery();
		if (rs.equals(null))
		{
			System.out.println("Application not found.");
		}
		else
		{
			while (rs.next())
			{
				app = new Application(rs.getString(2), rs.getDate(3), rs.getInt(4),rs.getInt(5), rs.getInt(6));
			}
		}
		
		return app;
	}
	
	public List<Application> getApplicationList(Integer employeeID) throws SQLException
	{
		Connection conn = cf.getConnection();
		ArrayList<Application> appList = new ArrayList<Application>();
		Application app = null;
		String sql = "SELECT * FROM APPLICATION WHERE EMPLOYEEID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, employeeID);
		ResultSet rs = ps.executeQuery();
		if (rs.equals(null))
		{
			System.out.println("No applications found.");
		}
		else
		{
			while (rs.next())
			{
				app = new Application(rs.getString(2), rs.getDate(3), rs.getInt(4),rs.getInt(5), rs.getInt(6));
				appList.add(app);
			}
		}
		
		return appList;
	}

}

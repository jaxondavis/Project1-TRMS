package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.beans.Login;
import com.revature.dao.LoginDao;
import com.revature.util.ConnFactory;

public class LoginDaoImpl implements LoginDao
{

public static ConnFactory cf = ConnFactory.getInstance();
	
	@Override
	public Login getLogin(int logID) throws SQLException 
	{
		Login log = null;
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM Login WHERE LoginID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, logID);
		ResultSet rs = ps.executeQuery();
		if (rs.equals(null))
		{
			System.out.println("Couldn't find Login matching Loginid "+logID);
		}
		else
		{
			while (rs.next())
			{
				if(rs.getInt(1) == logID)
				{
					log = new Login(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
				}
			}
		}
		return log;
	}

	@Override
	public ArrayList<Login> getAllLogins() throws SQLException 
	{
		Login app = null;
		ArrayList<Login> list = new ArrayList<Login>();
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM Login";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next())
		{
			app = new Login(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			list.add(app);
		}
		return list;
	}

	@Override
	public void addLogin(String email, String password, int employeeID) throws SQLException 
	{
		// adds a new Login to the database
		Connection conn = cf.getConnection();
		String sql = "{ call insertLogin(?,?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, email);
		call.setString(2, password);
		call.setInt(3, employeeID);
		call.execute();
		System.out.println("Insert sequence complete!");
	}

	@Override
	public void updateLogin(int logID, String email, String password, int employeeID) throws SQLException 
	{
		// updates the Logins info in the database
		Connection conn = cf.getConnection();
		String sql = "{ call updateLogin(?,?,?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, logID);
		call.setString(2, email);
		call.setString(3, password);
		call.setInt(4, employeeID);
		call.execute();
		System.out.println("Update sequence complete!");
	}

	@Override
	public void deleteLogin(int logID) throws SQLException 
	{
		// deletes the Login associated with appID in the database
		Connection conn = cf.getConnection();
		String sql = "{ call deletelogin(?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, logID);
		call.execute();
	}
}

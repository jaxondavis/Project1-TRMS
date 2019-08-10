package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.Address;
import com.revature.beans.Employee;
import com.revature.dao.AddressDao;
import com.revature.util.ConnFactory;

/*
 * For use with Address table in DB.
 */

public class AddressDaoImpl implements AddressDao {
	
	public static ConnFactory cf = ConnFactory.getInstance();

	//Creates Address object based off of address ID. May not be necessary?
	@Override
	public Address getAddress(int addrID) throws SQLException 
	{
		Address add = null;
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM ADDRESS WHERE ADDRESSID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, addrID);
		ResultSet rs = ps.executeQuery();
		if (rs.equals(null))
		{
			System.out.println("No address found for "+addrID);
		}
		else
		{
			while (rs.next())
			{
				add = new Address(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
		}
		
		return add;
	}

	//Should revise to include column name & new value as args.
	@Override
	public void editAddress(int addrID, String column, String newVal) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "UPDATE ADDRESS SET ? = ? WHERE addressID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, column);
		ps.setString(2, newVal);
		ps.setInt(3, addrID);
		ps.execute();
		System.out.println("Address has been altered.");
	}

	//Removes address from table.
	@Override
	public void removeAddress(int addrID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "DELETE FROM ADDRESS WHERE addressID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, addrID);
		ps.execute();
		System.out.println("Address has been removed.");
	}

	//Should add address using params.
	@Override
	public void addAddress(String addr, String city, String state, String zip) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ call insertaddress(?,?,?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, addr);
		call.setString(2, city);
		call.setString(3, state);
		call.setString(4, zip);
		call.execute();
		System.out.println("Sequence complete!");
	}

	//Confirms address exists in table. If so, returns its address ID. If not, returns 0.
	@Override
	public int confirmAddress(String addr, String city, String state, String zip) throws SQLException {
		int addrID = 0;
		Connection conn = cf.getConnection();
		String sql = "SELECT addressID FROM ADDRESS WHERE ADDRESS = ?, CITY = ?, STATE = ?, ZIPCODE = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, addr);
		ps.setString(2, city);
		ps.setString(3, state);
		ps.setString(4, zip);
		ResultSet rs = ps.executeQuery();
		while (rs.next())
		{
			//ResultSet columns start at 1.
			addrID = rs.getInt(1);
		}
		return addrID;
	}
	
	public Address viewAddress(int addrId) throws SQLException {
		Connection conn = cf.getConnection();
		//Object [] addressAttributes = new Object[5];
		Address a = null;
		
		String sql = "SELECT * FROM ADDRESS WHERE addressid = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, addrId);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next())
		{
			a = new Address(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
		}
		
		return a;
	}

}

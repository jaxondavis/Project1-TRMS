/**
 * 
 */
package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import com.revature.beans.Address;
import com.revature.util.ConnFactory;

/**
 * @author Revature Guest
 *
 */
public class AddressDaoImpl {

	public static ConnFactory cf = ConnFactory.getInstance();
	
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
			a = new Address(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
		}
		
		return a;
	}
	
	
	public Address getAddress(int addressId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
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
	
	public void editAddress(int addrId, String addr, String city, String state, String zip) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ call updateaddress(?,?,?,?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, addr);
		call.setString(2, addr);
		call.setString(3, city);
		call.setString(4, state);
		call.setString(5, zip);
		call.execute();
		System.out.println("Sequence complete!");
	}
	
	public void deleteAddress(int addrId) throws SQLException{
		Connection conn = cf.getConnection();
		String sql = "{ call deleteaddress(?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, addrId);
		call.execute();
		System.out.println("Sequence complete!");
	}
	
}

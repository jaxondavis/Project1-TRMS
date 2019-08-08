package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.revature.beans.Address;
import com.revature.dao.EventLocationDao;
import com.revature.util.ConnFactory;

public class EventLocationDaoImpl implements EventLocationDao {
	
	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public Address getEventLocation(int addrID) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEventLocation(int addrID, String addr, String city, String state, String zip) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ call updateeventlocation(?,?,?,?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, addrID);
		call.setString(2, addr);
		call.setString(3, city);
		call.setString(4, state);
		call.setString(5, zip);
		call.execute();
		System.out.println("Event location updated.");
	}

	@Override
	public void removeEventLocation(int addrID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ call deleteEventLocation(?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, addrID);
		call.execute();
		System.out.println("Event location removed.");
	}

	@Override
	public void addEventLocation(String addr, String city, String state, String zip) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ call inserteventlocation(?,?,?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, addr);
		call.setString(2, city);
		call.setString(3, state);
		call.setString(4, zip);
		call.execute();
		System.out.println("Event location added.");
	}

	@Override
	public int confirmEventLocation(String addr, String city, String state, String zip) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}

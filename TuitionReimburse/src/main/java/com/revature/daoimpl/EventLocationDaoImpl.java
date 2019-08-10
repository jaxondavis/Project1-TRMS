package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.beans.EventLocation;
import com.revature.dao.EventLocationDao;
import com.revature.util.ConnFactory;

public class EventLocationDaoImpl implements EventLocationDao
{

	public static ConnFactory cf = ConnFactory.getInstance();
	
	@Override
	public EventLocation getEventLocation(int locID) throws SQLException 
	{
		EventLocation loc = null;
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM EVENTLOCATION WHERE EVENTLOCATIONID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, locID);
		ResultSet rs = ps.executeQuery();
		if (rs.equals(null))
		{
			System.out.println("Couldn't find EventLocation matching id "+locID);
		}
		else
		{
			while (rs.next())
			{
				if(rs.getInt(1) == locID)
				{
					loc = new EventLocation(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				}
			}
		}
		return loc;
	}

	@Override
	public ArrayList<EventLocation> getAllEventLocations() throws SQLException 
	{
		EventLocation loc = null;
		ArrayList<EventLocation> list = new ArrayList<EventLocation>();
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM EVENTLOCATION";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next())
		{
			loc = new EventLocation(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			list.add(loc);
		}
		return list;
	}
	
	//Method to insert event location into EventLocation table.
	@Override
	public void addEventLocation(String addr, String city, String state, String zip) throws SQLException 
	{
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

	//Calls stored procedure to update event location.
	@Override
	public void updateEventLocation(int locID, String addr, String city, String state, String zip) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ call updateeventlocation(?,?,?,?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, locID);
		call.setString(2, addr);
		call.setString(3, city);
		call.setString(4, state);
		call.setString(5, zip);
		call.execute();
		System.out.println("Event location updated.");
		
	}

	//Calls stored procedure to remove event location.
	@Override
	public void deleteEventLocation(int locID) throws SQLException 
	{
		Connection conn = cf.getConnection();
		String sql = "{ call deleteeventlocation(?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, locID);
		call.execute();
		System.out.println("Event location removed.");
	}
	
	@Override
	public boolean checkLocation(int locID) throws SQLException
	{
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM EVENTLOCATION";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next())
		{
			if(locID == rs.getInt(1))
			{
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int getCurrentIndex() throws SQLException
	{
		int max = 1;
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM EVENTLOCATION";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next())
		{
			max = rs.getInt(1);
		}
		return max;
	}
	
	public int confirmEventLocation(String addr, String city, String state, String zip) throws SQLException {
		int locationID = 0;
		Connection conn = cf.getConnection();
		String sql = "SELECT LOCATIONID FROM EVENTLOCATION WHERE LOCATION = ?, CITY = ?, STATE = ?, ZIPCODE = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, addr);
		ps.setString(2, city);
		ps.setString(3, state);
		ps.setString(4, zip);
		ResultSet rs = ps.executeQuery();
		while (rs.next())
		{
			//ResultSet columns start at 1.
			locationID = rs.getInt(1);
		}
		return locationID;
	}
}

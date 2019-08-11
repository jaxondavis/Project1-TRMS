package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.beans.Event;
import com.revature.dao.EventDao;
import com.revature.util.ConnFactory;

/*
 * Uses Event DB & Stored Procedures to create, alter, and remove events and info.
 */

public class EventDaoImpl implements EventDao {
	
	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public Event getEvent(int eventID) throws SQLException
	{
		Event event = null;
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM EVENT WHERE EVENTID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, eventID);
		ResultSet rs = ps.executeQuery();
		if (rs.equals(null))
		{
			System.out.println("Couldn't find event matching id "+eventID);
		}
		else
		{
			while (rs.next())
			{
				if(rs.getInt(1) == eventID)
				{
					event = new Event(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getInt(9));
				}
			}
		}
		return event;
	}
	
	@Override
	public ArrayList<Event> getAllEvents() throws SQLException
	{
		return null;
	}
	
	@Override
	public void addEvent(String eventName, String eventDate, String eventTime, double eventCost, String eventDesc,
			int locationID, int formatID, int typeID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ call insertevent(?,?,?,?,?,?,?,?,?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, eventName);
		call.setString(2, eventDate);
		call.setString(3, eventTime);
		call.setDouble(4, eventCost);
		call.setString(5, eventDesc);
		call.setInt(6, locationID);
		call.setInt(7, formatID);
		call.setInt(8, typeID);
		call.execute();
		System.out.println("Insert sequence complete!");
	}

	//May look to implement procedure in another method for larger scale changes.
	@Override
	public void editEvent(int eventID, String eventName, String eventDate, String eventTime, double eventCost, String eventDesc,
			int locationID, int formatID, int typeID) throws SQLException 
	{
		Connection conn = cf.getConnection();
		String sql = "{ call updateevent(?,?,?,?,?,?,?,?,?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, eventID);
		call.setString(2, eventName);
		call.setString(3, eventDate);
		call.setString(4, eventTime);
		call.setDouble(5, eventCost);
		call.setString(6, eventDesc);
		call.setInt(7, locationID);
		call.setInt(8, formatID);
		call.setInt(9, typeID);
		call.execute();
		System.out.println("Event has been altered.");
	}

	//Calls stored procedure to delete event.
	@Override
	public void deleteEvent(int eventID) throws SQLException 
	{
		Connection conn = cf.getConnection();
		String sql = "{ call deleteevent(?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, eventID);
		call.execute();
	}
	
	@Override
	public int getCurrentIndex() throws SQLException
	{
		int max = 1;
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM EVENT";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next())
		{
			max = rs.getInt(1);
		}
		return max;
	}
	
	public Integer getEventID(String eventName) throws SQLException
	{
		Connection conn = cf.getConnection();
		Integer eventID = 0;
		String sql = "SELECT EVENTID FROM EVENT WHERE EVENTNAME = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, eventName);
		ResultSet rs = ps.executeQuery();
		while (rs.next())
		{
			eventID = rs.getInt(1);
		}
		return eventID;
	}
}
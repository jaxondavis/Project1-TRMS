package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.dao.EventDao;
import com.revature.util.ConnFactory;

/*
 * Uses Event DB & Stored Procedures to create, alter, and remove events and info.
 */

public class EventDaoImpl implements EventDao {
	
	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public void addEvent(String eventName, String eventDate, String eventTime, Double eventCost, String eventDesc,
			int locationID, int formatID, int typeID, int gradeID, int presentationID) throws SQLException {
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
		call.setInt(9, gradeID);
		call.setInt(10, presentationID);
		call.execute();
		System.out.println("Insert sequence complete!");
	}

	//May look to implement procedure in another method for larger scale changes.
	@Override
	public void editEvent(int eventID, String column, String newVal) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "UPDATE ADDRESS SET ? = ? WHERE addressID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, column);
		ps.setString(2, newVal);
		ps.setInt(3, eventID);
		ps.execute();
		System.out.println("Event has been altered.");
	}

	//Calls stored procedure to delete event.
	@Override
	public void deleteEvent(int eventID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ call deleteevent(?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, eventID);
		
	}

	//Method to insert address into EventLocation table.
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
	public void deleteEventLocation(int locID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ call deleteEventLocation(?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, locID);
		call.execute();
		System.out.println("Event location removed.");
	}

}

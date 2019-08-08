/**
 * 
 */
package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Event;
import com.revature.util.ConnFactory;

/**
 * @author Revature Guest
 *
 */
public class EventDaoImpl {

	public static ConnFactory cf = ConnFactory.getInstance();

	public void addEvent(String eventName, String eventDate, String eventTime, Double eventCost, String eventDesc,
			int locationID, int formatID, int typeID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ call insertevent(?,?,?,?,?,?,?,?)";
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
	
	
	public List<Event> getEvents() {
		// TODO Auto-generated method stub
		return null;
	}

	//create read method that selects an event by its id
	//create update method utilizing the procedure
	
	public void deleteEvent(int eventID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ call deleteevent(?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, eventID);
		
	}
}

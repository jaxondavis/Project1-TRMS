package com.revature.dao;

import java.sql.SQLException;

public interface EventDao {

	public abstract void addEvent(String eventName, String eventDate, String eventTime, Double eventCost, String eventDesc,
			int locationID, int formatID, int typeID, int gradeID, int presentationID) throws SQLException;
	
	public abstract void editEvent(int eventID, String column, String newVal) throws SQLException;
	
	public abstract void deleteEvent(int eventID) throws SQLException;
	
	public abstract void addEventLocation(String addr, String city, String state, String zip) throws SQLException;
	
	public abstract void updateEventLocation(int locID, String addr, String city, String state, String zip) throws SQLException;
	
	public abstract void deleteEventLocation(int locID) throws SQLException;
	
}

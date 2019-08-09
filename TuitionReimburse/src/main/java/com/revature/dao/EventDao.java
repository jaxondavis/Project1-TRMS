package com.revature.dao;

import java.sql.SQLException;

public interface EventDao {

	public abstract void addEvent(String eventName, String eventDate, String eventTime, Double eventCost, String eventDesc,
			int locationID, int formatID, int typeID, int gradeID, int presentationID) throws SQLException;
	
	public abstract void editEvent(int eventID, String column, String newVal) throws SQLException;
	
	public abstract void deleteEvent(int eventID) throws SQLException;
	
}

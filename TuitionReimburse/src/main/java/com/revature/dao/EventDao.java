package com.revature.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.beans.Event;

public interface EventDao 
{
	public abstract Event getEvent(int eventID) throws SQLException;
	
	public abstract ArrayList<Event> getAllEvents() throws SQLException;
	
	public abstract void addEvent(String eventName, String eventDate, String eventTime, double eventCost, String eventDesc,
			int locationID, int formatID, int typeID) throws SQLException;
	
	public abstract void editEvent(int eventID, String eventName, String eventDate, String eventTime, double eventCost, String eventDesc,
			int locationID, int formatID, int typeID) throws SQLException;
	
	public abstract void deleteEvent(int eventID) throws SQLException;
}
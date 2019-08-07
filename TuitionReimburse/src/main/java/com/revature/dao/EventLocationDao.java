package com.revature.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.beans.EventLocation;

public interface EventLocationDao 
{
	public abstract EventLocation getEventLocation(int locID) throws SQLException;
	
	public abstract ArrayList<EventLocation> getAllEventLocations() throws SQLException;
	
	public abstract void addEventLocation(String addr, String city, String state, String zip) throws SQLException;
	
	public abstract void updateEventLocation(int locID, String addr, String city, String state, String zip) throws SQLException;
	
	public abstract void deleteEventLocation(int locID) throws SQLException;
}
